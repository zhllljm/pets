package com.zkt.entitys;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel("管理员登录表")
@Data
public class Manager {

    @ApiModelProperty("管理员ID")
    private int id;
    @ApiModelProperty("管理员名字")
    private String uname;
    @ApiModelProperty("管理员密码")
    private String pwd;

}
