package com.zkt.entitys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("宠物种类表")
public class Kind implements Serializable {

    @ApiModelProperty(value = "种类表id")
    private int kindId;
    @ApiModelProperty(value = "种类名称")
    private String kindName;
}
