package com.linmt.mapper;

import com.linmt.po.UserPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insertOne(UserPo userPo);
}
