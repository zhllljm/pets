package com.zkt.api.service;


import com.zkt.entitys.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@RequestMapping("order")
public interface OrderService {

    /**
     * 查询订单id查询多个商品 一对多关系 order--orderdetail
     * @return
     */
    @PostMapping("/getOrdersList")
    List<Orders> getOrdersList(int id);




    /**
     * 根据生成的订单id增加订单详情表信息
     *
     */
    @PostMapping("/insertOrderdetail")
    Map<String,Object> insertOrderdetail(Orderdetail orderdetail);

    /**
     * 通过订单id删除该订单
     * @return
     */
    @PostMapping("/deleteOrder")
    Map<String,Object> deleteOrder(int id);

    /**
     * 然后用订单id删除订单详细表本次订单的内容
     */
    @PostMapping("/deleteOrderdetail")
    Map<String,Object> deleteOrderdetail(int orderId);

    @RequestMapping("saveOrder")
    Map<String,Object> saveOrder(Or[] or);

    @PostMapping("lookOrders")
    List<Orders> lookOrders(int userId);

    @PostMapping("lookOrdersbystatic")
    List<Orders> lookOrdersbystatic(Orders orders);

}
