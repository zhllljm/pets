package com.zkt.entitys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("用户收货地址")
@Data
public class Address implements Serializable {
    @ApiModelProperty("编号")
    private int adderid;

    @ApiModelProperty("省")
    private String province;

    @ApiModelProperty("市")
    private String market;

    @ApiModelProperty("区")
    private String district;

    @ApiModelProperty("详细地址")
    private String detaadder;

    @ApiModelProperty("用户收货电话号码")
    private String temphone;

    @ApiModelProperty("用户收货姓名")
    private String shname;

    @ApiModelProperty("默认地址")
    private String mr;

    @ApiModelProperty("用户id")
    private int uid;

}