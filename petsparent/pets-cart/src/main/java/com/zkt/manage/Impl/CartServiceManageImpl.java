package com.zkt.manage.Impl;

import com.zkt.common.api.BaseApiService;
import com.zkt.dao.CartMapper;
import com.zkt.entitys.Cart;
import com.zkt.entitys.Items;
import com.zkt.manage.CartServiceManage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CartServiceManageImpl extends BaseApiService implements CartServiceManage {

    @Autowired
    private CartMapper cartMapper;


    @Override
    public List<Items> getCartList(int userId) {
        return cartMapper.getCartList(userId);
    }


    @Override
    public Map<String, Object> insertCart(int pronum, int userId, int wareId) {
        cartMapper.insertCart(pronum, userId, wareId);
        return setResultSuccess();
    }

    @Override
    public Map<String, Object> deleteCartItem(int userId, int wareid) {
        cartMapper.deleteCartItem(userId, wareid);
        return setResultSuccess();
    }

    @Override
    public Map<String, Object> clearCartItem(int userId) {
        cartMapper.clearCartItem(userId);
        return setResultSuccess();
    }

    @Override
    public Cart selectCart(int userId, int wareId) {
        log.info("进入逻辑层层用户id"+userId+"商品id"+wareId);
        return cartMapper.selectCart(userId,wareId);
    }

    @Override
    public Map<String, Object> upnum(int pronum, int wareId) {
        cartMapper.upnum(pronum,wareId);
        return setResultSuccess();
    }
}
