
package com.zkt.web.controller;

import java.lang.annotation.Retention;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import co.zkt.entity.UserEntity;
import com.zkt.constants.BaseApiConstants;
import com.zkt.web.base.controller.BaseController;
import com.zkt.web.feign.UserFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class RegistController extends BaseController {
	private static final String LOCAREGIST = "locaRegist";
	private static final String LGOIN = "login";

	@Autowired
	private UserFeign userFeign;

	@RequestMapping("/item-add")
	public String itemList(){
	    return "item-add";
    }

	@RequestMapping("/locaRegist")
	public String locaRegist() {
		return LOCAREGIST;
	}

	@RequestMapping("/regist")
	public String regist(UserEntity userEntity, HttpServletRequest request) {
		log.info("这是注册开始----用户名为"+userEntity.getUsername());
		try {
			Map<String, Object> registMap = userFeign.regist(userEntity);
			System.out.println(registMap);
			Integer code = (Integer) registMap.get(BaseApiConstants.HTTP_CODE_NAME);
			System.out.println(code);
			if (!code.equals(BaseApiConstants.HTTP_200_CODE)) {
				String msg = (String) registMap.get("msg");
				return setError(request, msg, LOCAREGIST);
			}
			// 注册成功
			return LGOIN;

		} catch (Exception e) {
			return setError(request, "注册失败!", LOCAREGIST);
		}
	}

}
