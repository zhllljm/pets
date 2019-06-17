package com.zkt.api.service;

import com.zkt.entitys.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RequestMapping("adoption")
public interface AdoptionService {
    /**
     * 功能描述: 查询宠物种类
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/29 19:50
     */
    @PostMapping("/getKindList")
    List<Kind> getKindList();

    /**
     * 功能描述: 查询宠物年龄表
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/29 15:43
     */
    @PostMapping("/getPetAgeList")
    List<PetAge> getPetAgeList();

    /**
     * 功能描述:  查询领养条件表
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/29 15:45
     */
    @PostMapping("/getAdoptionConditionsList")
    List<AdoptionConditions> getAdoptionConditionsList();

    /**
     * 功能描述: 增加送养宠物信息
     *
     * @param: adoption
     * @return: Map<String, Object>
     * @auther: Administrator
     * @date: 2019/5/29 11:28
     */
    @PostMapping("/insertAdoption")
    Map<String, Object> insertAdoption(@RequestBody Object[] adoption);


    /**
     * 功能描述:    根据种类表id 或 城市名称查询adoption表 关联宠物图片表，同时关联宠物年龄表
     *
     * @param: kindId    city
     * @return: List<Adoption>
     * @auther: Administrator
     * @date: 2019/5/29 19:50
     */
    @PostMapping("/getAdoptionList")
    List<Adoption> getAdoptionList(Adoption adoption);
    /**
     *
     * 功能描述: 根据送养表id 查询宠物送养信息
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/30 15:39
     */
    @PostMapping("/getAdoption")
    List<Adoption> getAdoption(Integer adid);

    /**
     *
     * 功能描述:   增加领养人信息
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/30 14:44
     */
    @PostMapping("/insertAdopter")
    Map<String, Object> insertAdopter(Object[] shuju);
    /**
     *
     * 功能描述: 根据送养人微信号查询该送养人送养的宠物列表
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/30 18:20
     */
    @PostMapping("/getAdoptionByWeChat")
    List<Adoption> getAdoptionByWeChat(@Param("id") int id);

    /**
     * 上传图片到服务器
     * @param file
     * @return
     */
    @PostMapping("/picture")
    public String uploadFileToFast(@RequestParam("file") MultipartFile[] file);

    /**
     * 查询助养信息
     * @param userId
     * @return
     */
    @PostMapping("/getAList")
    List<Adoption> getAList(int userId);

    @PostMapping("/getRelationship")
    List<Relationship> getRelationship(int adid);

    @PostMapping("/saveadopter")
    Map<String,Object> saveAdoption(Adopter adopter);

}
