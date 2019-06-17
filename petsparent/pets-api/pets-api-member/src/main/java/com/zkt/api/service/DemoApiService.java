package com.zkt.api.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/demo")
public interface DemoApiService {

    @GetMapping("/demo")
    public String demo();
}
