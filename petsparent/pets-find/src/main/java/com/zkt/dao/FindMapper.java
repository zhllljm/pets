package com.zkt.dao;

import com.zkt.entitys.FindPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Mapper
public interface FindMapper {

    /**
     * 新添加寻找宠物信息
     * @param findPojo
     */
    public void insertFinds(FindPojo findPojo);

    /**
     * 根据城市显示所有寻宠信息
     * @return
     */
    public List<FindPojo> getListPets(String fcity);

    /**
     * 根据种类ID和fcity显示寻宠信息
     * @param fkind
     * @param fcity
     * @return
     */
    public List<FindPojo> getPetsKindIdAndFcity(@Param("fkind") int fkind, @Param("fcity") String fcity);

    /**
     * 根据ID和userID显示寻宠信息
     * @param userId
     * @return
     */
    public List<FindPojo> getPetsUserId(int userId);

    /**
     * 根据寻宠Id查询详细信息
     * @param fid
     * @return
     */
    public FindPojo getOneInfo(int fid);


}
