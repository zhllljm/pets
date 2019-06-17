package com.zkt.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SearchItem implements Serializable {
    private String wareid;
    private String warename;
    private long proprice;
    private String name;
    private String waredetailed;

}
