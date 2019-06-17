package com.zkt.entitys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: Administrator
 * @Date: 2019/5/29 15:34
 * @Description:
 */
@Data
@ApiModel("领养条件表")
public class AdoptionConditions implements Serializable {
    @ApiModelProperty(value = "领养条件表id")
    private int acId;
    @ApiModelProperty(value = "领养条件内容")
    private String conditions;
}
