package com.zkt.dao;

import com.zkt.entitys.Address;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AddressMapper {

    @Select("select * from address where uid=#{uid}")
    public List<Address> getAddress(int uid);

    @Insert("insert into address(province,market,district,detaadder,temphone,shname,mr,uid) values(#{province},#{market},#{district},#{detaadder},#{temphone},#{shname},#{mr},#{uid})")
    public void addAddress(Address address);

    @Select("select * from address where uid=#{uid} and adderid=#{adderid}")
    public List<Address> getAddressbyid(Address address);

    @Update("update address set mr='0'")
    void updateAddress1();

    @Update("update address set province=#{province},market=#{market},district=#{district},detaadder=#{detaadder},temphone=#{temphone},shname=#{shname},mr=#{mr} where adderid=#{adderid}")
    void updateAddress2(Address address);

    @Delete("delete from address where adderid=#{adderid}")
    void delAddress(int adderid);

    @Select("select * from address where mr='1'")
    Address getAddressbymr();


}
