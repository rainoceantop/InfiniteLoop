package com.InfiniteLoop.service.impl;

import com.InfiniteLoop.dao.UserDetailMapper;
import com.InfiniteLoop.pojo.UserDetail;
import com.InfiniteLoop.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements CommonService<UserDetail> {
    @Autowired
    private UserDetailMapper userDetailMapper;

    public int deleteByPrimaryKey(Integer primaryKey) {
        return userDetailMapper.deleteByPrimaryKey(primaryKey);
    }

    public int insert(UserDetail record) {
        return userDetailMapper.insert(record);
    }

    public int insertSelective(UserDetail record) {
        return userDetailMapper.insertSelective(record);
    }

    public UserDetail selectByPrimaryKey(Integer primaryKey) {
        return userDetailMapper.selectByPrimaryKey(primaryKey);
    }
    public UserDetail selectByUserId(Integer userId){
        return userDetailMapper.selectByUserId(userId);
    }

    public int updateByPrimaryKeySelective(UserDetail record) {
        return userDetailMapper.updateByPrimaryKeySelective(record);
    }
    public int updateByUserIdSelective(UserDetail record) {
        return userDetailMapper.updateByUserIdSelective(record);
    }
    public int updateByPrimaryKey(UserDetail record) {
        return userDetailMapper.updateByPrimaryKey(record);
    }
    public int updateUserAvatarByUserId(UserDetail record){
        return userDetailMapper.updateUserAvatarByUserId(record);
    }
}
