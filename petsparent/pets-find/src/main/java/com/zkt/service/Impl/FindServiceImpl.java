package com.zkt.service.Impl;

import com.zkt.api.service.FindService;
import com.zkt.entitys.FindPojo;
import com.zkt.manage.FindManage;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class FindServiceImpl implements FindService {

    @Autowired
    private FindManage findManage;

    /**
     * 添加寻宠信息
     * @param findPojo
     * @return
     */
    @Override
    public Map<String, Object> insertFinds(@RequestBody FindPojo findPojo) {
        /*System.out.println("2:" + files);*/
        System.out.println("1:" + findPojo);
        return findManage.insertFinds(findPojo);
    }

    /**
     * 上传图片
     * @param files
     * @return
     */
    @Override
    public String uploadFileToFast(MultipartFile files) {
        System.out.println("picture:" + files);
        return findManage.uploadFileToFast(files);
    }

    /**
     * 根据城市显示所有寻宠信息
     * @return
     */
    @Override
    public List<FindPojo> getListPets(String fcity){
        System.out.println(fcity);
        return findManage.getListPets(fcity);
    }

    @Override
    public List<FindPojo> getPetsKindIdAndFcity(@RequestParam("fkind")int fkind,@RequestParam("fcity")String fcity) {
        System.out.println("3--id:" + fkind);
        System.out.println("4--fcity:" + fcity);
       /* if (fcity.equals("定位中.")){

        }else{
            List<FindPojo> list =
        }*/
        /*Integer fic = Integer.parseInt(fkind);*/
        return findManage.getPetsKindIdAndFcity(fkind,fcity);
    }

    @Override
    public List<FindPojo> getPetsUserId(int userId) {
        return findManage.getPetsUserId(userId);
    }

    @Override
    public FindPojo getOneInfo(@RequestParam("fid") int fid) {

        System.out.println("根据ID查询的:" + fid);

        return findManage.getOneInfo(fid);
    }


}
