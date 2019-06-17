package com.zkt.manage.Impl;


import com.sun.tools.javac.jvm.Items;
import com.zkt.common.api.BaseApiService;
import com.zkt.dao.OrderMapper;
import com.zkt.entitys.Orders;
import com.zkt.entitys.Orderdetail;
import com.zkt.manage.OrderServiceManage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: petsparent
 * @description: OrderServiceManageImpl
 * @author: Administrator
 * @create: 2019-05-21 11:11
 */
@Service
@Slf4j
public class OrderServiceManageImpl extends BaseApiService implements OrderServiceManage {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Orders> getOrdersList(int id) {
        return orderMapper.getOrdersList(id);
    }

    @Override
    public int insertOrder(Orders order) {
        return orderMapper.insertOrder(order);
    }

    @Override
    public Map<String, Object> insertOrderdetail(Orderdetail orderdetail) {
        orderMapper.insertOrderdetail(orderdetail);
        return setResultSuccess();
    }

    @Override
    public Map<String, Object> deleteOrder(int id) {
        orderMapper.deleteOrder(id);
        return setResultSuccess();
    }

    @Override
    public Map<String, Object> deleteOrderdetail(int orderid) {
        orderMapper.deleteOrderdetail(orderid);
        return setResultSuccess();
    }

    @Override
    public Map<String, Object> saveOrder(Items items, int userId) {
        return null;
    }

    @Override
    public List<Orders> lookOrders(int userId) {
        return orderMapper.lookOrders(userId);
    }

    @Override
    public List<Orders> lookOrdersbystatic(Orders orders) {

        return orderMapper.lookOrdersbystatic(orders);
    }

    @Override
    public void delCart(int userId) {
        orderMapper.delCart(userId);
    }
}
