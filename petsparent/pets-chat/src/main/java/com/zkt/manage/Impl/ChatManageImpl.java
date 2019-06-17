package com.zkt.manage.Impl;

import co.zkt.entity.UserEntity;
import com.zkt.dao.ChatMapper;
import com.zkt.manage.ChatManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatManageImpl implements ChatManage {

    @Autowired
    ChatMapper chatMapper;

    @Override
    public UserEntity getUser(int id) {
        System.out.println("进入Controller层");
        return chatMapper.getUser(id);
    }
}
