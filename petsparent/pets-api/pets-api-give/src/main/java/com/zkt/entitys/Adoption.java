package com.zkt.entitys;


import co.zkt.entity.UserEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@ApiModel("送养表")
public class Adoption implements Serializable {
    @ApiModelProperty(value = "送养表adid")
    private int adid;
    @ApiModelProperty(value = "宠物昵称")
    private String name;
    @ApiModelProperty(value = "宠物性别 1 - 男孩 0 - 女孩 ")
    private int sex;
    @ApiModelProperty(value = "是否注射疫苗 1 -是 0-否")
    private String isVaccine;
    @ApiModelProperty(value = "是否绝育 1 -是 0-否 ")
    private String isNeuter;
    @ApiModelProperty(value = "是否驱虫 1 -是 0-否 ")
    private String isEP;
    @ApiModelProperty(value = "宠物描述或送养原因 ")
    private String describe;
    @ApiModelProperty(value = "城市 ")
    private String city;
    @ApiModelProperty(value = "详细地址 ")
    private String detailed;
    @ApiModelProperty(value = "种类表id")
    private int kindId;
    @ApiModelProperty(value = "宠物年龄表id")
    private int petAgeId;
    @ApiModelProperty(value = "用户id")
    private int userId;

    List<PetImages> petImages;

    PetAge petAge;

    Kind kind;

    UserEntity userEntity;


}
