package com.zkt.service.Impl;

import com.zkt.api.service.CartService;
import com.zkt.entitys.Cart;
import com.zkt.entitys.Items;
import com.zkt.manage.CartServiceManage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class CartServiceImpl implements CartService {
    @Autowired
    private CartServiceManage cartServiceManage;


    @Override
    public List<Items> getCartList(@RequestParam("userId") int userId) {
        return cartServiceManage.getCartList(userId);
    }

    @Override
    public Map<String,Object> upnum(@RequestParam("pronum") int pronum,@RequestParam("wareId") int wareId) {
        return cartServiceManage.upnum(pronum,wareId);
    }


    @Override
    public Map<String, Object> insertCart(@RequestParam("pronum") int pronum,@RequestParam("userId") int userId,@RequestParam("wareId") int wareId) {
        return cartServiceManage.insertCart(pronum, userId, wareId);
    }

    @Override
    public Map<String, Object> deleteCartItem(int userId, int wareId) {
        return cartServiceManage.deleteCartItem(userId, wareId);
    }

    @Override
    public Map<String, Object> clearCartItem(int userId) {
        return cartServiceManage.clearCartItem(userId);
    }

    @Override
    public Cart selectCart(@RequestParam("userId") int userId, @RequestParam("wareId") int wareId) {
        log.info("进入Controller层用户id"+userId+"商品id"+wareId);
        return cartServiceManage.selectCart(userId,wareId);
    }
}
