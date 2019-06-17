package com.zkt.common.token;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Uuidutil {

	public String getUUID() {
		String uuidResult = "";
		String uuidTemp = "";
		uuidTemp = java.util.UUID.randomUUID().toString();
		uuidResult = uuidTemp.replaceAll("-", "");
		return uuidResult;
	}

	public String getCharAndNumr(int length) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			if ("char".equalsIgnoreCase(charOrNum)) {
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (choice + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) { // ����
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}

	public String getNumber(int length) {
		char[] chars = { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= length; i++) {
			sb.append(chars[random.nextInt(chars.length)]);
		}
		return sb.toString();
	}

}
