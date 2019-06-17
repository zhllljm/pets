
package com.zkt.web.base.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import co.zkt.entity.UserEntity;
import com.zkt.common.api.BaseApiService;
import com.zkt.constants.BaseApiConstants;
import com.zkt.web.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * @classDesc: 功能描述:()
 */
@Controller
public class BaseController {

	@Autowired
	private UserFeign uF;

	public UserEntity getUserEntity(String token) {
		Map<String, Object> userMap = uF.getUser(token);
		System.out.println(userMap);
		Integer code = (Integer) userMap.get(BaseApiConstants.HTTP_CODE_NAME);
		if (!code.equals(BaseApiConstants.HTTP_200_CODE)) {
			return null;
		}
		// 获取data参数
		LinkedHashMap linkedHashMap = (LinkedHashMap) userMap.get(BaseApiConstants.HTTP_DATA_NAME);
		System.out.println(linkedHashMap);
		String json = new JSONObject().toJSONString(linkedHashMap);
		UserEntity userEntity = new JSONObject().parseObject(json, UserEntity.class);
		return userEntity;

	}

	public String setError(HttpServletRequest request, String msg, String addres) {
		request.setAttribute("error", msg);
		return addres;
	}

}
