package com.zkt.service.Impl;

import com.zkt.api.service.OrderService;
import com.zkt.common.token.Uuidutil;
import com.zkt.entitys.*;
import com.zkt.manage.OrderServiceManage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.PathParam;
import java.util.List;
import java.util.Map;

/**
 * @program: petsparent
 * @description: OrderServiceImpl
 * @author: Administrator
 * @create: 2019-05-21 11:10
 */
@RestController
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderServiceManage orderServiceManage;
    @Override
    public List<Orders> getOrdersList(@RequestBody int id) {
        return orderServiceManage.getOrdersList(id);
    }


    @Override
    public Map<String, Object> insertOrderdetail(Orderdetail orderdetail) {
        return orderServiceManage.insertOrderdetail(orderdetail);
    }

    @Override
    public Map<String, Object> deleteOrder(@RequestBody int id) {
        return orderServiceManage.deleteOrder(id);
    }

    @Override
    public Map<String, Object> deleteOrderdetail(int orderid) {
        return orderServiceManage.deleteOrderdetail(orderid);
    }

    @Override
    public Map<String, Object> saveOrder(@RequestBody Or[] orders ) {
        Orders orders1=new Orders();
        Integer userId=null;
        for (Or ob:
             orders) {
            log.info("进入Controller商品信息"+ob);
            orders1.setUserId(ob.getUserId());
            orders1.setPayment(ob.getTatol());
            userId=ob.getUserId();
        }
        Uuidutil uuidutil=new Uuidutil();
        orders1.setOrderNo(uuidutil.getCharAndNumr(12));
        orders1.setStatus(2);
        orderServiceManage.insertOrder(orders1);
        int i=orders1.getId();
        System.out.println("订单id"+i);

        Map<String,Object> map=null;
        for (Or ob:
                orders) {
            Orderdetail orderdetail=new Orderdetail();
            log.info("进入Controller商品信息"+ob);
            orderdetail.setItemId(ob.getWareid());
            orderdetail.setOrderId(i);
            orderdetail.setNum(ob.getPronum());
            orderdetail.setItemName(ob.getItemname());
            orderdetail.setPrice(ob.getProprice());
            map=orderServiceManage.insertOrderdetail(orderdetail);
        }

        orderServiceManage.delCart(userId);

        return map;
    }

    @Override
    public List<Orders> lookOrders(int userId) {
        log.info("传过来的数据为"+userId);
        return orderServiceManage.lookOrders(userId);
    }

    @Override
    public List<Orders> lookOrdersbystatic(Orders orders) {
        log.info("传过来的数据为"+orders.toString());
        return orderServiceManage.lookOrdersbystatic(orders);
    }
}
