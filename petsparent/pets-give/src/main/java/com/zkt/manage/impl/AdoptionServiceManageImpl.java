package com.zkt.manage.impl;

import com.zkt.common.api.BaseApiService;
import com.zkt.common.file.CommonFileUtil;
import com.zkt.constants.Constants;
import com.zkt.dao.AdoptionMapper;
import com.zkt.entitys.*;
import com.zkt.manage.AdoptionServiceManage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

/**
 * @Auther: Administrator
 * @Date: 2019/5/29 11:45
 * @Description:
 */
@Service
@Slf4j
public class AdoptionServiceManageImpl extends BaseApiService implements AdoptionServiceManage {

    @Autowired
    private AdoptionMapper mapper;

    @Autowired
    private CommonFileUtil commonFileUtil;

    @Override
    public List<Kind> getKindList() {
        return mapper.getKindList();
    }

    @Override
    public List<PetAge> getPetAgeList() {
        return mapper.getPetAgeList();
    }

    @Override
    public List<AdoptionConditions> getAdoptionConditionsList() {
        return mapper.getAdoptionConditionsList();
    }

    @Override
    public Map<String, Object> insertAdoption(Object[] adoption) {
        for (Object o:
             adoption) {
            System.out.println("逻辑层:" + o);
        }

        Adoption adoption1 = new Adoption();
        adoption1.setName((String) adoption[3]);
        String sex= (String) adoption[4];
        int sex1=Integer.parseInt(sex);
        adoption1.setSex(sex1);
        adoption1.setIsVaccine((String) adoption[6]);
        adoption1.setIsNeuter((String) adoption[7]);
        adoption1.setIsEP((String) adoption[8]);
        adoption1.setDescribe((String) adoption[9]);
        adoption1.setCity((String) adoption[15]);
        adoption1.setDetailed((String) adoption[16]);
        String age= (String) adoption[18];
        int age1=Integer.parseInt(age);
        adoption1.setPetAgeId(age1);
        String kind= (String) adoption[5];
        int kind1=Integer.parseInt(kind);
        adoption1.setKindId(kind1);
        String userid= (String) adoption[17];
        int userid1=Integer.parseInt(userid);
        adoption1.setUserId(userid1);
        System.out.println(adoption1.toString());
        int adid = mapper.insertAdoption(adoption1);
        int id=adoption1.getAdid();
        log.info("返回的id为："+id);
        System.out.println("逻辑层:" + id);
        List<String> imgss=new ArrayList<String>();
        imgss.add((String) adoption[0]);
        imgss.add((String) adoption[1]);
        imgss.add((String) adoption[2]);
        List<String> li=new ArrayList<String>();
        li.add((String) adoption[10]);
        li.add((String) adoption[11]);
        li.add((String) adoption[12]);
        li.add((String) adoption[13]);
        li.add((String) adoption[14]);
        for (String s:
                imgss) {
            PetImages petImages=new PetImages();
            petImages.setImg(s);
            petImages.setAdid(id);
            System.out.println("数据为="+petImages);
            mapper.inp(petImages);
        }
        for (String s:
                li) {
            int a=Integer.parseInt(s);
            log.info("条件："+a);
            Relationship relationship=new Relationship();
            relationship.setAdid(id);
            relationship.setAcId(a);
            mapper.insertRelationship(relationship);
        }
        return setResultSuccess();
    }



    @Override
    public List<Adoption> getAdoptionList(Adoption adoption) {
        return mapper.getAdoptionList(adoption);
    }

    @Override
    public List<Adoption> getAdoption(Integer adid) {
        return mapper.getAdoption(adid);
    }


    @Override
    public List<Adoption> getAdoptionByWeChat(int id) {
        return mapper.getAdoptionByWeChat(id);
    }


    @Override
    public String uploadFileToFast(@RequestParam("file") MultipartFile[] file) {
        System.out.println("逻辑层图片上传：" + file);
        try {
            if (file.length == 0) {
                log.info("文件不存在");
            }
            //遍历文件数组执行上传
            String path = null;
            for (int i = 0; i < file.length; i++) {
                if (file[i] != null) {
                    //调用上传方法
                    path = commonFileUtil.uploadFile(file[i]);
                    System.out.println("path:" + Constants.F_W_IP + path);
                }
            }
            return Constants.F_W_IP + path;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Adoption> getAList(int userId) {
        return mapper.getAList(userId);
    }

    @Override
    public List<Relationship> getRelationship(int adid) {
        List<Relationship> rl=mapper.getRelationship(adid);
        for (Relationship re:
             rl) {
            System.out.println(re);
        }
        return rl;
    }

    @Override
    public Map<String, Object> saveAdoption(Adopter adopter) {
        mapper.saveAdoption(adopter);
        return setResultSuccess();
    }


    public Map<String, Object> insertPetimg(List<String> imgss,int id) {
        log.info("添加图片："+id);
        for (String s:
                imgss) {
            System.out.println(s);
            log.info("图片："+s);
            PetImages petImages=new PetImages();
            petImages.setImg(s);
            petImages.setAdid(id);
            System.out.println("数据为="+petImages);
            mapper.inp(petImages);
        }
        return setResultSuccess();
    }

    public  Map<String, Object> insertRe(List<String> li,int id) {
        log.info("添加条件："+id);
        for (String s:
                li) {
            int a=Integer.parseInt(s);
            Relationship relationship=new Relationship();
            relationship.setAdid(id);
            relationship.setAcId(a);
            mapper.insertRelationship(relationship);
        }
        return setResultSuccess();
    }

}
