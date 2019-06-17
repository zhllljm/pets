package com.zkt.api.service;

import com.zkt.entitys.Cart;
import com.zkt.entitys.Items;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@RequestMapping("cart")
public interface CartService {

    /**
     * 查询当前用户所有购物车信息
     *
     * @param userId 用户id
     * @return
     */
    @PostMapping("/getCartList")
    List<Items> getCartList(@RequestParam("userId") int userId);

    @PostMapping("/upnum")
    Map<String,Object> upnum(int pronum, int wareId);



    /**
     * 加入购物车
     *
     * @param pronum 商品数量
     * @param userId 用户id
     * @param wareId 商品id
     * @return
     */
    @PostMapping("/insertCart")
    Map<String, Object> insertCart(int pronum,int userId, int wareId);


    /**
     * 删除购物车信息
     *
     * @param userId 用户id
     * @return
     */
    @PostMapping("/deleteCartItem")
    Map<String, Object> deleteCartItem(@RequestBody int userId, @RequestBody int wareId);

    /**
     * 清空当前用户购物车
     *
     * @param userId 用户id
     * @return
     */
    @PostMapping("/clearCartItem")
    Map<String, Object> clearCartItem(@RequestBody int userId);


    @PostMapping("/selectCart")
    Cart selectCart(int userId, int wareId);
}
