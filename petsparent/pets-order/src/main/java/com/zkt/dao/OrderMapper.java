package com.zkt.dao;


import com.zkt.entitys.Orders;
import com.zkt.entitys.Orderdetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: petsparent
 * @description: ${description}
 * @author: Administrator
 * @create: 2019-05-21 11:08
 */

@Mapper
public interface OrderMapper {

    /**
     * 查询订单id查询多个商品 一对多关系 order--orderdetail
     * @return
     */

    List<Orders> getOrdersList(int id);


    /**
     * 增加order订单信息
     */

   int insertOrder(Orders order);

    /**
     * 根据生成的订单id增加订单详情表信息
     *
     */

    void insertOrderdetail(Orderdetail orderdetail);

    /**
     * 通过订单id删除该订单
     * @return
     */

   void deleteOrder(int id);

    /**
     * 然后用订单id删除订单详细表本次订单的内容
     */

    void deleteOrderdetail(int orderid);

    List<Orders> lookOrders(int userId);

    List<Orders> lookOrdersbystatic(Orders orders);

    void delCart(int userId);
}
