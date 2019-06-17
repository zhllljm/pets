package com.zkt.manage;

import com.zkt.entitys.Cart;
import com.zkt.entitys.Items;

import java.util.List;
import java.util.Map;

public interface CartServiceManage {

    /**
     * 查询当前用户所有购物车信息
     *
     * @param userId 用户id
     * @return
     */
    List<Items> getCartList(int userId);



    /**
     * 加入购物车
     *
     * @param pronum 商品数量
     * @param userId 用户id
     * @param wareId 商品id
     * @return
     */

    Map<String, Object> insertCart(int pronum, int userId, int wareId);


    /**
     * 删除购物车信息
     *
     * @param userId 用户id
     * @param wareid 商品id
     * @return
     */

    Map<String, Object> deleteCartItem(int userId, int wareid);

    /**
     * 清空当前用户购物车
     *
     * @param userId 用户id
     * @return
     */

    Map<String, Object> clearCartItem(int userId);

    Cart selectCart(int userId, int wareId);

    Map<String,Object> upnum(int pronum, int wareId);
}
