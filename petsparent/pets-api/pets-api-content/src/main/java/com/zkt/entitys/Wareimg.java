package com.zkt.entitys;

import lombok.Data;

import java.io.Serializable;

@Data
public class Wareimg implements Serializable {
    private int lid;
    private String limg;
    private int Wareid;

}
