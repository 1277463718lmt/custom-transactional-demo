package com.linmt.service.impl;

import com.linmt.mapper.UserMapper;
import com.linmt.po.UserPo;
import com.linmt.service.IUserService;
import com.linmt.transaction.annocations.CustomTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @CustomTransactional
    public void insertOne(UserPo userPo) {
        userMapper.insertOne(userPo);

        int i = 1/0;
    }
}
