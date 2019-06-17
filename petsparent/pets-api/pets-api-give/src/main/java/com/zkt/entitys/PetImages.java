package com.zkt.entitys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("宠物图片表")
public class PetImages implements Serializable {

    @ApiModelProperty(value = "宠物图片表id")
    private int imgId;
    @ApiModelProperty(value = "宠物图片地址")
    private String img;
    @ApiModelProperty(value = "送养表id")
    private int adid;
}
