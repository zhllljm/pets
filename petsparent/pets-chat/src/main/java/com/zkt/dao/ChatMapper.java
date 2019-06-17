package com.zkt.dao;

import co.zkt.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatMapper {

    UserEntity getUser(int id);
}
