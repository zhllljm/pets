package com.zkt.entitys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@ApiModel("商品分类表")
@Data
public class ItemCat implements Serializable {
    @ApiModelProperty("编号")
    private int id;
    @ApiModelProperty("分类名称")
    private String name;
    @ApiModelProperty("分类图片")
    private String img;

    private List<Items> items;
}
