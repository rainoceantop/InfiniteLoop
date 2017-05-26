package com.InfinitelyLoop.service.impl;

import com.InfinitelyLoop.dao.UserAccountMapper;
import com.InfinitelyLoop.pojo.UserAccount;
import com.InfinitelyLoop.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService implements CommonService<UserAccount>{
    @Autowired
    private UserAccountMapper userAccountMapper;

    public int deleteByPrimaryKey(Integer primaryKey) {
        return userAccountMapper.deleteByPrimaryKey(primaryKey);
    }

    public int insert(UserAccount record) {
        return userAccountMapper.insert(record);
    }

    public int insertSelective(UserAccount record) {
        return userAccountMapper.insertSelective(record);
    }

    public UserAccount selectByPrimaryKey(Integer commentId) {
        return userAccountMapper.selectByPrimaryKey(commentId);
    }

    public int updateByPrimaryKeySelective(UserAccount record) {
        return userAccountMapper.updateByPrimaryKeySelective(record);
    }
    public int updateByPrimaryKey(UserAccount record) {
        return userAccountMapper.updateByPrimaryKey(record);
    }

}
