package com.zkt.manage.Impl;

import com.zkt.common.api.BaseApiService;
import com.zkt.common.file.CommonFileUtil;
import com.zkt.constants.Constants;
import com.zkt.dao.FindMapper;
import com.zkt.entitys.FindPojo;
import com.zkt.manage.FindManage;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class FindManageImpl extends BaseApiService implements FindManage {

    @Autowired
    private FindMapper findMapper;

    @Autowired
    private CommonFileUtil commonFileUtil;


    @Override
    public Map<String, Object> insertFinds(FindPojo findPojo) {
        findMapper.insertFinds(findPojo);
        return setResultSuccess();
    }

    @Override
    public String uploadFileToFast(@RequestParam("files") MultipartFile files) {
        try {
            if (files.isEmpty()) {
                log.info("文件不存在");
            }
            String path = null;
            path = commonFileUtil.uploadFile(files);
            return Constants.F_W_IP + path;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<FindPojo> getListPets(String fcity) {
        System.out.println("逻辑层:" + fcity);
        List<FindPojo> list = findMapper.getListPets(fcity);
        System.out.println("list:" + list);
        return list;
    }

    @Override
    public List<FindPojo> getPetsKindIdAndFcity(int fkind, String fcity) {
        List<FindPojo> list = findMapper.getPetsKindIdAndFcity(fkind, fcity);
        System.out.println("list:" + list);
        return list;
    }

    @Override
    public List<FindPojo> getPetsUserId(int userId) {
        return findMapper.getPetsUserId(userId);
    }

    @Override
    public FindPojo getOneInfo(int fid) {
        FindPojo findPojo = findMapper.getOneInfo(fid);
        System.out.println("fid:" + fid);
        return findPojo;
    }
}
