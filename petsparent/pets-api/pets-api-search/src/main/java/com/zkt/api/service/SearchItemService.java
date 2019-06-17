package com.zkt.api.service;

import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

public interface SearchItemService {

    /**
     * 一键导入索引库
     * @return
     */
    @PostMapping("/importAllItems")
    public Map<String,Object> importAllItems();

}
