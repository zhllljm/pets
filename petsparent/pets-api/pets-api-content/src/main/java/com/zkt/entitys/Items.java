package com.zkt.entitys;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
@ApiModel("商品表")
public class Items implements Serializable {

    @ApiModelProperty(value="商品id")
    private int wareid;
    @ApiModelProperty(value="商品名称")
    private String warename;
    @ApiModelProperty(value="商品现价")
    private float proprice;

    @ApiModelProperty(value="发布时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date waretime;

    @ApiModelProperty(value="商品详情")
    private String waredetailed;
    @ApiModelProperty(value="商品销量")
    private int warefreight;

    @ApiModelProperty(value="商品状态，是否上下架")
    private char warestatus;

    @ApiModelProperty(value="分类编号")
    private int cid;

    private ItemCat itemCat;

    private List<Wareimg> wareimgs;


}
