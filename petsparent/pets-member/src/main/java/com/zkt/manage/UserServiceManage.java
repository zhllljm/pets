
package com.zkt.manage;

import co.zkt.entity.UserEntity;
import com.zkt.utils.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface UserServiceManage {
	/**
	 * 
	 * @methodDesc: 功能描述:(注册服务)
	 * @param: @param
	 *             UserEntity
	 */
	public Map<String, Object>  regist(UserEntity userEntity);

	public String md5PassSalt(String phone,String password);

    public Map<String, Object> login(UserEntity userEntity) ;

    public Map<String, Object> getUser(String token);

	public String uoloadFileToFast(MultipartFile file);

	public UserEntity getUserbyid(Long id);

}
