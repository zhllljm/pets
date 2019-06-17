package com.zkt.manage;

import com.sun.tools.javac.jvm.Items;
import com.zkt.entitys.Orders;
import com.zkt.entitys.Orderdetail;

import java.util.List;
import java.util.Map;

/**
 * @program: petsparent
 * @description: ${description}
 * @author: Administrator
 * @create: 2019-05-21 11:09
 */
public interface OrderServiceManage {
    /**
     * 查询订单id查询多个商品 一对多关系 order--orderdetail
     *
     * @return
     */

    List<Orders> getOrdersList(int id);


    /**
     * 增加order订单信息
     */

    int insertOrder(Orders order);

    /**
     * 根据生成的订单id增加订单详情表信息
     */

    Map<String, Object> insertOrderdetail(Orderdetail orderdetail);

    /**
     * 通过订单id删除该订单
     *
     * @return
     */

    Map<String, Object> deleteOrder(int id);

    /**
     * 然后用订单id删除订单详细表本次订单的内容
     */

    Map<String, Object> deleteOrderdetail(int orderid);

    Map<String,Object> saveOrder(Items items, int userId);

    List<Orders> lookOrders(int userId);

    List<Orders> lookOrdersbystatic(Orders orders);

    void delCart(int userId);
}
