package com.zkt.web.controller;

import com.zkt.web.base.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class DemoController extends BaseController {

    // index页面
    public static final String INDEX = "index";

    @RequestMapping("/index")
    public String index(HttpServletRequest request,String token) {
        log.info(" 我的web工程搭建成功啦!,userName:{}",getUserEntity(token).getUsername());
        return INDEX;
    }
}
