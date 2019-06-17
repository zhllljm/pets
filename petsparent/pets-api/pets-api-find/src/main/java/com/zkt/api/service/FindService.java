package com.zkt.api.service;


import com.zkt.entitys.FindPojo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface FindService {


    /**
     * 新添加寻找宠物信息
     * @param findPojo
     */
    @PostMapping("/find/addpets")
    public Map<String,Object> insertFinds(FindPojo findPojo);

    /**
     * 上传图片到服务器
     * @param files
     * @return
     */
    @PostMapping("/find/picture")
    public String uploadFileToFast(@RequestParam("files") MultipartFile files);

    /**
     * 根据城市显示所有寻宠信息
     * @return
     */
    @RequestMapping("/find/getListPets")
    public List<FindPojo> getListPets(@RequestParam("fcity") String fcity);

    /**
     * 根据种类ID和fcity显示寻宠信息
     * @param fkind
     * @param fcity
     * @return
     */
    @PostMapping("/find/KindIdAndFcity")
    public List<FindPojo> getPetsKindIdAndFcity(int fkind, String fcity);

    /**
     * 根据userID显示寻宠信息
     * @param userId
     * @return
     */
    @PostMapping("/find/getUserIdInfo")
    public List<FindPojo> getPetsUserId(int userId);

    /**
     * 根据寻宠Id查询详细信息
     * @param fid
     * @return
     */
    @PostMapping("/find/getOneInfo")
    public FindPojo getOneInfo(int fid);
}
