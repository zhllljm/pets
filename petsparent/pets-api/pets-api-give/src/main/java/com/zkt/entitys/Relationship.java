package com.zkt.entitys;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019/5/29 15:37
 * @Description:
 */
@Data
@ApiModel("关系表")
public class Relationship implements Serializable {
    @ApiModelProperty(value = "关系表id")
    private int reId;
    @ApiModelProperty(value = "领养条件表id")
    private int acId;
    @ApiModelProperty(value = "送养表id")
    private int adid;

    Adoption adoption;
    List<AdoptionConditions> as;
}
