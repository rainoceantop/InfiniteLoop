package com.InfinitelyLoop.service.impl;

import com.InfinitelyLoop.dao.UserLanguageMapper;
import com.InfinitelyLoop.pojo.UserLanguage;
import com.InfinitelyLoop.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLanguageService implements CommonService<UserLanguage> {
    @Autowired
    private UserLanguageMapper userLanguageMapper;

    public int deleteByPrimaryKey(Integer primaryKey) {
        return userLanguageMapper.deleteByPrimaryKey(primaryKey);
    }

    public int insert(UserLanguage record) {
        return userLanguageMapper.insert(record);
    }

    public int insertSelective(UserLanguage record) {
        return userLanguageMapper.insertSelective(record);
    }

    public UserLanguage selectByPrimaryKey(Integer commentId) {
        return userLanguageMapper.selectByPrimaryKey(commentId);
    }

    public int updateByPrimaryKeySelective(UserLanguage record) {
        return userLanguageMapper.updateByPrimaryKeySelective(record);
    }
    public int updateByPrimaryKey(UserLanguage record) {
        return userLanguageMapper.updateByPrimaryKey(record);
    }

}
