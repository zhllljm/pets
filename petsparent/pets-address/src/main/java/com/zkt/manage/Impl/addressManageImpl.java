package com.zkt.manage.Impl;

import com.zkt.common.api.BaseApiService;
import com.zkt.dao.AddressMapper;
import com.zkt.entitys.Address;
import com.zkt.manage.AddressManage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class addressManageImpl extends BaseApiService implements AddressManage {

    @Autowired
    private AddressMapper addressMapper;
    
    @Override
    public List<Address> getAddrss(int uid) {
        log.info("进入逻辑实现:"+uid);
        List<Address> addresses=addressMapper.getAddress(uid);
        for (Address address:
             addresses) {
            log.info("数据:"+address);
          if (address.getMr().equals("1")){
              System.out.println("进入默认");
              address.setMr("默认");

          }else {
              System.out.println("进入不是默认");
              address.setMr("");
          }
        };
        return addresses;
    }

    @Override
    public List<Address> getAddrssbyid(Address address) {
        log.info("进入逻辑实现:"+address);
        List<Address> addresses=addressMapper.getAddressbyid(address);
        for (Address address1 : addresses) {
            if (address1.getMr().equals("1")){
                System.out.println("进入默认");
                address.setMr("默认");

            }else {
                System.out.println("进入不是默认");
                address1.setMr("");
            }
        }
        return addresses;
    }

    @Override
    public Map<String, Object> addAddress(Address address) {
        log.info("进入逻辑实现:"+address);
        if (address.getMr().equals("1")){
            addressMapper.updateAddress1();
        }
        addressMapper.addAddress(address);
        return setResultSuccess();
    }


    @Override
    public Map<String, Object> delAddress(int adderid) {
        log.info("进入逻辑实现:"+adderid);
        addressMapper.delAddress(adderid);
        return setResultSuccess();
    }

    @Override
    public Map<String, Object> upAddress(Address address) {
        log.info("进入逻辑实现:"+address);
        if (address.getMr().equals("1")){
            System.out.println("默认的");
            addressMapper.updateAddress1();
            addressMapper.updateAddress2(address);
        }else {
            addressMapper.updateAddress2(address);
        }
        return setResultSuccess();
    }

    @Override
    public Address getAddressbymr() {
        return addressMapper.getAddressbymr();
    }
}
