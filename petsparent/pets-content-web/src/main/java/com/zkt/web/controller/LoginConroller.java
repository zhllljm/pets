
package com.zkt.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.zkt.entity.UserEntity;
import com.zkt.constants.BaseApiConstants;
import com.zkt.constants.Constants;
import com.zkt.web.CookieUtil;
import com.zkt.web.base.controller.BaseController;
import com.zkt.web.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginConroller extends BaseController {
	private static final String LGOIN = "login";
	private static final String INDEX = "index";
	@Autowired
	private UserFeign userFeign;



	@RequestMapping("/locaLogin")
	public String locaLogin() {
		return LGOIN;
	}

	@RequestMapping("/login")
	public String login(UserEntity userEntity, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> login = userFeign.login(userEntity);
		Integer code = (Integer) login.get(BaseApiConstants.HTTP_CODE_NAME);
		if (!code.equals(BaseApiConstants.HTTP_200_CODE)) {
			String msg = (String) login.get("msg");
			return setError(request, msg, LGOIN);
		}
		// 登录成功之后,获取token.将这个token存放在cookie
		String token = (String) login.get("data");
		CookieUtil.addCookie(response, Constants.USER_TOKEN, token, Constants.WEBUSER_COOKIE_TOKEN_TERMVALIDITY);
		return INDEX;

	}

}
