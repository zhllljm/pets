package com.zkt.service.Impl;

import com.zkt.api.service.AddressServer;
import com.zkt.entitys.Address;
import com.zkt.manage.AddressManage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class AddressServiceImpl implements AddressServer {

    @Autowired
    private AddressManage addressManage;

    @Override
    public List<Address> getAddrss(@RequestParam("uid") int uid) {
        log.info("进入控制层"+uid);
        return addressManage.getAddrss(uid);
    }

    @Override
    public List<Address> getlistbyid(@RequestBody Address address) {
        log.info("进入控制层"+address);
        return addressManage.getAddrssbyid(address);
    }

    @Override
    public Map<String, Object> addAddress(@RequestBody Address address) {
        log.info("进入控制层"+address);
        return addressManage.addAddress(address);
    }

    @Override
    public Map<String, Object> updateAddress(@RequestBody Address address) {
        log.info("进入控制层"+address);
        return addressManage.upAddress(address);
    }

    @Override
    public Map<String, Object> delAddress(@RequestParam("adderid") int adderid) {
        log.info("进入控制层"+adderid);
        return addressManage.delAddress(adderid);
    }

    @Override
    public Address getAddressbymr() {
        return addressManage.getAddressbymr();
    }

}
