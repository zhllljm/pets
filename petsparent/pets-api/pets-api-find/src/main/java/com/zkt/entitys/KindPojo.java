package com.zkt.entitys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "宠物类型")
public class KindPojo implements Serializable {

    @ApiModelProperty(value = "宠物种类ID")
    private int kindId;
    @ApiModelProperty(value = "宠物种类名称")
    private String kindName;
}
