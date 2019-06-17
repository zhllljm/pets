package com.zkt.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/*
 * 订单信息
 */
@Data
@ApiModel(value = "用户订单表")
public class Orders implements Serializable {
    @ApiModelProperty("订单列表id")
    private int id;
    @ApiModelProperty("订单号")
    private String orderNo;
    @ApiModelProperty("用户编号")
    private int userId;
    @ApiModelProperty("实付金额")
    private String payment;
    @ApiModelProperty("订单状态")
    private int status;
    @ApiModelProperty("订单创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createtime;


    @ApiModelProperty("订单明细")
    private List<Orderdetail> ord;


}
