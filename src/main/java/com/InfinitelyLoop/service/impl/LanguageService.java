package com.InfinitelyLoop.service.impl;

import com.InfinitelyLoop.dao.LanguageMapper;
import com.InfinitelyLoop.pojo.Language;
import com.InfinitelyLoop.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService implements CommonService<Language> {
    @Autowired
    private LanguageMapper languageMapper;

    public int deleteByPrimaryKey(Integer primaryKey) {
        return languageMapper.deleteByPrimaryKey(primaryKey);
    }

    public int insert(Language record) {
        return languageMapper.insert(record);
    }

    public int insertSelective(Language record) {
        return languageMapper.insertSelective(record);
    }

    public Language selectByPrimaryKey(Integer primaryKey) {
        return languageMapper.selectByPrimaryKey(primaryKey);
    }
    public List<String> selectColumnName(){
        return languageMapper.selectColumnName();
    }

    public int updateByPrimaryKeySelective(Language record) {
        return languageMapper.updateByPrimaryKeySelective(record);
    }
    public int updateByPrimaryKey(Language record) {
        return languageMapper.updateByPrimaryKey(record);
    }

}
