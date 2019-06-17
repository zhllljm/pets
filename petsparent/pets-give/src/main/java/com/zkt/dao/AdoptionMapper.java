package com.zkt.dao;

import com.zkt.entitys.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2019/5/29 11:39
 * @Description:
 */
@Mapper
public interface AdoptionMapper {

    /**
     * 功能描述: 查询宠物种类
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/29 19:50
     */
    @Select(" SELECT * FROM kind")
    List<Kind> getKindList();

    /**
     * 功能描述: 查询宠物年龄表
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/29 15:43
     */
    @Select("SELECT * FROM petAge")
    List<PetAge> getPetAgeList();

    /**
     * 功能描述:  查询领养条件表
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/29 15:45
     */
    @Select("SELECT * FROM adoptionConditions")
    List<AdoptionConditions> getAdoptionConditionsList();

    /**
     * 功能描述: 增加送养宠物信息
     *
     * @param: adoption
     * @return: Map<String, Object>
     * @auther: Administrator
     * @date: 2019/5/29 11:28
     */

   int insertAdoption(Adoption adoption);

    /**
     * 功能描述: 增加宠物图片表信息 3张图片地址
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/29 19:52
     */

    void inp(PetImages petImages);

    /**
     * 功能描述: 增加送养表的领养条件限制 关系表
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/29 19:58
     */

    void insertRelationship(Relationship relationship);

    /**
     * 功能描述:    根据种类表id查询adoption表
     *
     * @param: kindId
     * @return: List<Adoption>
     * @auther: Administrator
     * @date: 2019/5/29 19:50
     */
    List<Adoption> getAdoptionList(Adoption adoption);

    /**
     * 功能描述: 根据送养表id 查询宠物送养信息
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/30 15:39
     */
    List<Adoption> getAdoption(@Param("adid")Integer adid);

    /**
     * 功能描述:   增加领养人信息
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/30 14:44
     */
    void insertAdopter(Adopter adopter);

    /**
     * 功能描述: 根据送养人微信号用户唯一id查询该送养人送养的宠物列表
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/30 18:20
     */

    List<Adoption> getAdoptionByWeChat(@Param("id") int id);

    /**
     * 查询助养信息
     * @param userId
     * @return
     */
    @Select("select * from adoption where userId=#{userId}")
    List<Adoption> getAList(@Param("userId") int userId);

    List<Relationship> getRelationship(@Param("adid") int adid);

    void saveAdoption(Adopter adopter);
}
