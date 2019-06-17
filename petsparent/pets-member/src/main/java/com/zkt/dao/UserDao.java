package com.zkt.dao;

import co.zkt.entity.UserEntity;
import com.zkt.common.mybatis.BaseDao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao extends BaseDao {
    @Select("select * from mb_user WHERE phone=#{phone} and password=#{password}")
    public UserEntity getUserPhoneAndPwd(@Param("phone") String phone, @Param("password") String password);

    @Select("select id,username,password,phone,email,img,created,updated from mb_user  WHERE id=#{id}")
    public UserEntity getUserInfo(@Param("id") Long id);




}
