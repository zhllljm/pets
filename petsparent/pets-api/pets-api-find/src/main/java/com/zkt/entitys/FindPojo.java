package com.zkt.entitys;


import co.zkt.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "发布寻宠")
public class FindPojo implements Serializable {

    @ApiModelProperty("寻宠id")
    private int fid;
    @ApiModelProperty("宠物照片")
    private String fimg;
    @ApiModelProperty("发布类型")
    private String ftype;
    @ApiModelProperty("宠物昵称")
    private String fname;
    @ApiModelProperty("所在城市")
    private String fcity;
    @ApiModelProperty("丢失时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date ftime;
    @ApiModelProperty("丢失地址")
    private String faddress;
    @ApiModelProperty("有效时间")
    private int fontime;
    @ApiModelProperty("种类")
    private int fkind;
    @ApiModelProperty("宠物描述")
    private String fdesc;
    @ApiModelProperty("用户ID")
    private int userId;
    @ApiModelProperty("种类表字段表")
    private KindPojo kindPojo;
    @ApiModelProperty("种类表字段表")
    private UserEntity userEntity;
    }
