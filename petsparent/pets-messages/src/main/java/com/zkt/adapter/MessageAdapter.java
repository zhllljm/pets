
package com.zkt.adapter;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * 
 * @classDesc: 功能描述:(所有消息都会交给他进行妆发)
 */
public interface MessageAdapter {
	//接受消息
    public void distribute(JSONObject jsonObject);
}
