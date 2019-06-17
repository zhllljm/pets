package com.zkt.entitys;

import co.zkt.entity.UserEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: Administrator
 * @Date: 2019/5/30 14:33
 * @Description:
 */

@Data
@ApiModel("领养人信息表")
public class Adopter implements Serializable {

    @ApiModelProperty(value = "领养人信息表id")
    private int teId;
    @ApiModelProperty(value = "领养人性别 1 麻麻 0 爸爸")
    private String sex;
    @ApiModelProperty(value = "领养人年代 6 60后  7 70后 8 80后 9 90后 0 00后")
    private String age;
    @ApiModelProperty(value = "领养人工作状态  1 无业 2 学生 3 工作  0退休")
    private String status;
    @ApiModelProperty(value = "养宠经验  1 有经验 0 无经验")
    private String experience;
    @ApiModelProperty(value = "婚姻状况  1 单身 2 恋爱中 0 已婚")
    private String marriage;
    @ApiModelProperty(value = "住房状况  1 自住房 2 整租房 0 合租")
    private String lodging;
    @ApiModelProperty(value = "我的月收入 1 小于三千 2 三千到六千 3 六千到一万 4 大于一万")
    private String income;
    @ApiModelProperty(value = "自述详情")
    private String de;
    @ApiModelProperty(value = "userId")
    private int userId;


}
