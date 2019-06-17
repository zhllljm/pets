package com.zkt.web.controller;


import com.zkt.web.feign.SearchFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SearchItemController {

    @Autowired
    private SearchFeign searchFeign;

    @PostMapping("/index/item/import")
    public Map<String,Object> importItemList(){
        Map<String,Object> map = searchFeign.importAllItems();
        return map;
    }

}
