package com.zkt.entitys;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(value="订单明细表")
public class Orderdetail implements Serializable {
	@ApiModelProperty("订单明细表id")
	private int id;
	@ApiModelProperty("商品id")
	private int itemId;
	@ApiModelProperty("订单id")
	private int orderId;
	@ApiModelProperty("商品购买数量")
	private int num;
	@ApiModelProperty("商品名字")
	private String itemName;
	@ApiModelProperty("商品单价")
	private  int price;

	Items items;

}
