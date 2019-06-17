package com.zkt.entitys;

import com.sun.tools.javac.jvm.Items;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("购物车")
public class Cart implements Serializable {

    @ApiModelProperty("购物车id")
    private int cartId;
    @ApiModelProperty("商品数量")
    private int pronum;
    @ApiModelProperty("用户id")
    private int userId;
    @ApiModelProperty("商品id")
    private int wareId;
    @ApiModelProperty("关联商品信息表")
    private List<Items> items;

}
