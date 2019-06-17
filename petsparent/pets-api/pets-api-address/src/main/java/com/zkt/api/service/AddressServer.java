package com.zkt.api.service;

import com.zkt.entitys.Address;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@RequestMapping("address")
public interface AddressServer {

    @PostMapping("getlist")
    public List<Address> getAddrss(@RequestParam("uid") int uid);

    @PostMapping("getlistbyid")
    public List<Address> getlistbyid(@RequestBody Address address);

    @PostMapping("add")
    public Map<String,Object> addAddress(@RequestBody Address address);

    @PostMapping("up")
    Map<String,Object> updateAddress(@RequestBody Address address);

    @PostMapping("del")
    Map<String,Object> delAddress(@RequestParam("adderid") int adderid);

    @PostMapping("getAddressbymr")
    Address getAddressbymr();

}
