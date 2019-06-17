package com.zkt.web.controller;

import com.zkt.entitys.Manager;
import com.zkt.web.feign.ItemFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class InterfaceController {

    @Autowired
    private ItemFeign itemFeign;

    @RequestMapping("/manager")
    public String shouye() {
        return "manager";
    }

    @RequestMapping("/local")
    public String index() {
        return "local";
    }

    @RequestMapping("/dylb")
    public String dylb() {
        return "dylb";
    }

    @RequestMapping("/dyxxgl")
    public String dyxxgl() {
        return "dyxxgl";
    }

    @RequestMapping("/index-item")
    public String Seaitem() {
        return "index-item";
    }

    @RequestMapping("/localss")
    public String loginList(Manager manager, HttpSession session) {

        Manager loginType = itemFeign.queryUserLogin(manager);
        System.out.println("登录页面数据：" + manager);
        System.out.println("loginType:" + loginType);
        if (loginType != null) {
            String name = loginType.getUname();
            //获取session并将userName存入session对象
            session.setAttribute("name", name);
            return "local";
        }
        String msg="输入账户或密码有误！！！";
        session.setAttribute("msg", msg);
        return "redirect:/manager";
    }

}
