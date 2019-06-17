package com.zkt.service.Impl;

import co.zkt.entity.UserEntity;
import com.zkt.api.service.UserService;
import com.zkt.common.api.BaseApiService;
import com.zkt.manage.UserServiceManage;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class UserServiceImpl extends BaseApiService implements UserService {

    @Autowired
    private UserServiceManage usm;

    @Override
    public Map<String, Object> regist(@RequestBody  UserEntity userEntity) {

        log.info("这是注册开始----用户名为"+userEntity.getUsername());
        log.info(userEntity.getImg());
        if(StringUtils.isEmpty(userEntity.getUsername())){
            return setResultError("用户名称不能为空!");
        }
        if(StringUtils.isEmpty(userEntity.getPassword())){
            return setResultError("密码不能为空!");
        }
        try {
            usm.regist(userEntity);
            return setResultSuccess();
        } catch (Exception e) {
            return setResultError("注册失败!");
        }

    }

    @Override
    public Map<String, Object> login(@RequestBody UserEntity userEntity) {
        System.out.println(userEntity.getPhone());
        System.out.println(userEntity.getPassword());
        return usm.login(userEntity);
    }

    @Override
    public Map<String, Object> getUser(@RequestParam("token") String token) {
        System.out.println("token为"+token);
        return usm.getUser(token);
    }

    @Override
    public String uoloadFileToFast(@RequestParam("file") MultipartFile file) {
        return usm.uoloadFileToFast(file);
    }

    @Override
    public UserEntity getUserbyid(Long id) {
        System.out.println(id);
        UserEntity userEntity=usm.getUserbyid(id);
        System.out.println(userEntity.toString());
        return userEntity;
    }

    @Override
    public Map<String, Object> decodeUserInfo(String encryptedData, String iv, String code) throws IOException {
        Map map=new HashMap();
        // 登录凭证不能为空
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return map;
        }

        System.out.println("encryptedData:"+encryptedData+"iv:"+iv+"code:"+code);

        // 小程序唯一标识 (在微信小程序管理后台获取)
        String wxspAppid = "wx87c7f060291f8f3c";
        // 小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = "9986fb5ee752dad3393300aff93b163e";

        StringBuilder url = new StringBuilder("https://api.weixin.qq.com/sns/jscode2session?");
        url.append("appid=");//appid设置
        url.append(wxspAppid);
        url.append("&secret=");//secret设置
        url.append(wxspSecret);
        url.append("&js_code=");//code设置
        url.append(code);
        url.append("&grant_type=authorization_code");
        CloseableHttpClient client= HttpClientBuilder.create().build();
        System.out.println("url等于"+url.toString());
        HttpGet get=new HttpGet(url.toString());
        HttpResponse response = client.execute(get);//提交GET请求
        HttpEntity result = response.getEntity();//拿到返回的HttpResponse的"实体"
        String content = EntityUtils.toString(result);
        System.out.println(content);//打印返回的信息
        JSONObject json = JSONObject.fromObject(content);//把信息封装为json
        // 获取会话密钥（session_key）
        String session_key = json.get("session_key").toString();
        // 用户的唯一标识（openid）
        String openid = (String) json.get("openid");

        System.out.println("进入解密");
        // 被加密的数据
        byte[] dataByte = org.codehaus.xfire.util.Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = org.codehaus.xfire.util.Base64.decode(session_key);
        // 偏移量
        byte[] ivByte = org.codehaus.xfire.util.Base64.decode(iv);

        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String b = new String(resultByte, "UTF-8");
                System.out.println(b);
                JSONObject userInfoJSON  = JSONObject.fromObject(b);

                System.out.println(userInfoJSON);
                UserEntity userEntity=new UserEntity();
                userEntity.setEmail("123@qq.com");
                userEntity.setImg(userInfoJSON.getString("avatarUrl"));
                userEntity.setUsername(userInfoJSON.getString("nickName"));
                userEntity.setPhone("13556340995");
                userEntity.setPassword("123");
                usm.regist(userEntity);
                UserEntity userEntity1=new UserEntity();
                userEntity1.setPhone("13556340995");
                userEntity1.setPassword("123");
                map= usm.login(userEntity1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }


}
