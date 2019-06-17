package com.zkt.manage;

import com.zkt.entitys.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2019/5/29 11:43
 * @Description:
 */
public interface AdoptionServiceManage {

    /**
     * 功能描述: 查询宠物种类
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/29 19:50
     */

    List<Kind> getKindList();

    /**
     * 功能描述: 查询宠物年龄表
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/29 15:43
     */

    List<PetAge> getPetAgeList();

    /**
     * 功能描述:  查询领养条件表
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/29 15:45
     */

    List<AdoptionConditions> getAdoptionConditionsList();

    /**
     * 功能描述: 增加送养宠物信息
     *
     * @param: adoption
     * @return: Map<String, Object>
     * @auther: Administrator
     * @date: 2019/5/29 11:28
     */

    Map<String,Object> insertAdoption(Object[] adoption);




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
    List<Adoption> getAdoption(Integer adid);


    /**
     * 功能描述: 根据送养人微信号查询该送养人送养的宠物列表
     *
     * @param:
     * @return:
     * @auther: Administrator
     * @date: 2019/5/30 18:20
     */
    List<Adoption> getAdoptionByWeChat(int id);

    /**
     * 上传图片到服务器
     *
     * @param file
     * @return
     */
    public String uploadFileToFast(MultipartFile[] file);

    /**
     * 查询助养信息
     * @param userId
     * @return
     */
    List<Adoption> getAList(int userId);

    List<Relationship> getRelationship(int adid);

    Map<String, Object> saveAdoption( Adopter adopter);
}
