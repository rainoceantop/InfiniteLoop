package com.InfiniteLoop.service.impl;

import com.InfiniteLoop.dao.UserAccountMapper;
import com.InfiniteLoop.pojo.UserAccount;
import com.InfiniteLoop.service.CommonService;
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

    public UserAccount selectByPrimaryKey(Integer primaryKey) {
        return userAccountMapper.selectByPrimaryKey(primaryKey);
    }
    public UserAccount selectByUsername(String username){
        return userAccountMapper.selectByUsername(username);
    }

    public int updateByPrimaryKeySelective(UserAccount record) {
        return userAccountMapper.updateByPrimaryKeySelective(record);
    }
    public int updateByPrimaryKey(UserAccount record) {
        return userAccountMapper.updateByPrimaryKey(record);
    }

}
