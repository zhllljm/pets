package com.zkt.api.service;

import co.zkt.entity.UserEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@RequestMapping("/member")
public interface UserService {
    @PostMapping("/regist")
    public Map<String,Object> regist(@RequestBody  UserEntity userEntity);

    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody UserEntity userEntity);

    @PostMapping("/getUser")
    public Map<String, Object> getUser(@RequestParam ("token") String token);

    //使用fastdfs进行文件上传
    @RequestMapping("/uploadFileToFast")
    public String uoloadFileToFast(@RequestParam("file") MultipartFile file);

    @PostMapping("/getUserbyid")
    public UserEntity getUserbyid(Long id);

    @PostMapping(value = "/decodeUserInfo")
    public Map<String,Object> decodeUserInfo(String encryptedData, String iv, String code) throws IOException;
}
