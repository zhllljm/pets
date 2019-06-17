package com.zkt.manage;

import com.zkt.entitys.Address;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface AddressManage {
    public List<Address> getAddrss(int uid);

    public List<Address> getAddrssbyid(Address address);

    public Map<String, Object> addAddress(Address address);

    Map<String, Object> delAddress(int adderid);

    Map<String,Object> upAddress(Address address);

    public Address getAddressbymr();
}
