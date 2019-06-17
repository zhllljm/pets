package com.zkt.entitys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("宠物年龄表")
public class PetAge implements Serializable {

    @ApiModelProperty(value = "宠物年龄表id")
    private int ageId;
    @ApiModelProperty(value = "宠物年龄")
    private String age;
}
