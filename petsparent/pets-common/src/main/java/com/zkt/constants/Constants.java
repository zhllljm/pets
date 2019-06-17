
package com.zkt.constants;

public interface Constants {
	// 响应code
	String HTTP_RES_CODE_NAME = "code";
	// 响应msg
	String HTTP_RES_CODE_MSG = "msg";
	// 响应data
	String HTTP_RES_CODE_DATA = "data";
	// 响应请求成功
	String HTTP_RES_CODE_200_VALUE = "success";
	// 响应请求失败
	String HTTP_RES_CODE_400_VALUE = "error";
	// 系统错误
	String HTTP_RES_CODE_500_VALUE = "fial";
	// 响应请求成功code
	Integer HTTP_RES_CODE_200 = 200;
	// 响应请求失败code
	Integer HTTP_RES_CODE_400 = 400;
	// 系统错误
	Integer HTTP_RES_CODE_500 = 500;

	String SMS_MAIL = "sms_mail";

	//用户会话保存90天
	Long USER_TOKEN_TERMVALIDITY = 60 * 60 * 24 * 90l;
	int WEBUSER_COOKIE_TOKEN_TERMVALIDITY = 1000*60 * 60 * 24 * 90;
	String USER_TOKEN = "token";

	//服务器ip
	String F_W_IP = "http://119.23.74.128/";





}
