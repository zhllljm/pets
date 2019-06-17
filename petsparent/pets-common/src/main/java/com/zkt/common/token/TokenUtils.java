
package com.zkt.common.token;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class TokenUtils {

	   public String getToken(){
		return UUID.randomUUID().toString();
	   }
	
}
