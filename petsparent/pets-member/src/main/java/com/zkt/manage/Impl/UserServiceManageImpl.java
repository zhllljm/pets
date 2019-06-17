package com.zkt.manage.Impl;

import co.zkt.entity.UserEntity;
import com.alibaba.fastjson.JSONObject;
import com.zkt.common.api.BaseApiService;
import com.zkt.common.file.CommonFileUtil;
import com.zkt.common.redis.BaseRedisService;
import com.zkt.common.token.TokenUtils;
import com.zkt.common.token.Uuidutil;
import com.zkt.constants.Constants;
import com.zkt.constants.ConstantsTables;
import com.zkt.constants.MQInterfaceType;
import com.zkt.dao.UserDao;
import com.zkt.manage.UserServiceManage;
import com.zkt.mq.roducer.RegisterMailboxProducer;
import com.zkt.utils.DateUtils;
import com.zkt.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.jms.Destination;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

@Service
@Slf4j
public class UserServiceManageImpl extends BaseApiService implements UserServiceManage {

    @Autowired
    private UserDao ud;

    @Autowired
    private RegisterMailboxProducer registerMailboxProducer;

    @Value("${messages.queue}")
    private  String messages_queue;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private Uuidutil uud;

    @Autowired
    private BaseRedisService baseRedisService;

    @Autowired
    private CommonFileUtil commonFileUtil;



    @Override
    public Map<String, Object> regist(UserEntity userEntity) {
            userEntity.setCreated(DateUtils.getTimestamp());
            userEntity.setUpdated(DateUtils.getTimestamp());
            String phone=userEntity.getPhone();
            String password=userEntity.getPassword();
            String newpassword=md5PassSalt(phone,password);
            log.info("新密码为"+newpassword);
            userEntity.setPassword(newpassword);
            ud.save(userEntity, ConstantsTables.TABLE_MB_USER);
            return setResultSuccess();
        //队列
        /*Destination acMq=new ActiveMQQueue(messages_queue);
        String jsonObject=MailMessage(userEntity.getUsername(),userEntity.getEmail());
        System.out.println(jsonObject);
        registerMailboxProducer.send(acMq,jsonObject);*/
    }

    @Override
    public String md5PassSalt(String phone, String password) {
        System.out.println(phone+password);
        String newPass= MD5Util.MD5(phone+password);
        return newPass;
    }

    @Override
    public Map<String, Object> login(UserEntity userEntity) {
        // 往数据进行查找数据
        String phone = userEntity.getPhone();
        String password = userEntity.getPassword();
        String newPassWord = md5PassSalt(phone, password);
        System.out.println("新密码为"+newPassWord);
        UserEntity userPhoneAndPwd = ud.getUserPhoneAndPwd(phone, newPassWord);
        System.out.println(userPhoneAndPwd);
        if (userPhoneAndPwd == null) {
            return setResultError("账号或密码错误");
        }
        String token =uud.getCharAndNumr(10);
        Long userId = userPhoneAndPwd.getId();
        // key为自定义令牌,用户的userId作作为value 存放在redis中
        baseRedisService.setString(token, userId + "", Constants.USER_TOKEN_TERMVALIDITY);
        return setResultData(token);
    }

    @Override
    public Map<String, Object> getUser(String token) {
        // 从redis中查找到userid
        String userId= (String) baseRedisService.get(token);
        if (StringUtils.isEmpty(userId)) {
            return setResultError("用户已经过期!");
        }
        Long newUserIdl = Long.parseLong(userId);
        UserEntity userInfo = ud.getUserInfo(newUserIdl);
        userInfo.setPassword(null);
        return setResultData(userInfo);
    }

    @Override
    public String uoloadFileToFast(MultipartFile file) {
        try {
            if(file.isEmpty()){
                log.info("文件不存在");
            }
            String path = null;
            path = commonFileUtil.uploadFile(file);
            System.out.println(path);
            return path;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserEntity getUserbyid(Long id) {
        System.out.println("进入逻辑层");
        return ud.getUserInfo(id);
    }


    private String MailMessage(String userName,String email){
        //组装报文格式
        JSONObject root=new JSONObject();
        JSONObject header=new JSONObject();
        header.put("interfaceType", MQInterfaceType.SMS_MAIL);
        JSONObject content=new JSONObject();
        String mail=email;
        String username = userName;
        content.put("mail",mail);
        content.put("username",username);
        root.put("header",header);
        root.put("content",content);
        return root.toJSONString();
    }
}
