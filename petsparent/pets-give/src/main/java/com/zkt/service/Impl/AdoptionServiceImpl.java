package com.zkt.service.Impl;

import com.zkt.api.service.AdoptionService;
import com.zkt.entitys.*;
import com.zkt.manage.AdoptionServiceManage;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2019/5/29 11:47
 * @Description:
 */
@RestController
@Slf4j
public class AdoptionServiceImpl implements AdoptionService {

    @Autowired
    private AdoptionServiceManage manage;

    @Override
    public List<Kind> getKindList() {
        return manage.getKindList();
    }

    @Override
    public List<PetAge> getPetAgeList() {
        return manage.getPetAgeList();
    }

    @Override
    public List<AdoptionConditions> getAdoptionConditionsList() {
        return manage.getAdoptionConditionsList();
    }

    @Override
    public Map<String,Object> insertAdoption(Object[] adoption) {
        System.out.println("添加:" + adoption);
        Map<String, Object> id  =  manage.insertAdoption(adoption);
        return id;
    }



    @Override
    public List<Adoption> getAdoptionList(@RequestBody Adoption adoption) {
        System.out.println("1.city:" + adoption.getCity());
        System.out.println("2.kindId:" + adoption.getKind());
        return manage.getAdoptionList(adoption);
    }

    @Override
    public List<Adoption> getAdoption(@Param("adid") Integer adid) {
        System.out.println("查询所有id:" + adid);
        return manage.getAdoption(adid);
    }

    @Override
    public Map<String, Object> insertAdopter(@RequestBody Object[] shuju) {
        return manage.insertAdoption(shuju);
    }

    @Override
    public List<Adoption> getAdoptionByWeChat(@Param("id") int id) {
        return manage.getAdoptionByWeChat(id);
    }

    @Override
    public String uploadFileToFast(@RequestParam("file") MultipartFile[] file) {
        System.out.println("多张图片路径:" + file);
        return manage.uploadFileToFast(file);
    }

    @Override
    public List<Adoption> getAList(int userId) {
        return manage.getAList(userId);
    }

    @Override
    public List<Relationship> getRelationship(int adid) {
        return manage.getRelationship(adid);
    }

    @Override
    public Map<String, Object> saveAdoption(@RequestBody Adopter adopter) {
        log.info("传来的数据为"+adopter.toString());
        return manage.saveAdoption(adopter);
    }


}
