package com.InfiniteLoop.service.impl;

import com.InfiniteLoop.dao.LanguagesCountMapper;
import com.InfiniteLoop.pojo.LanguagesCount;
import com.InfiniteLoop.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguagesCountService implements CommonService<LanguagesCount>{
    @Autowired
    private LanguagesCountMapper languagesCountMapper;

    public int deleteByPrimaryKey(Integer primaryKey) {
        return languagesCountMapper.deleteByPrimaryKey(primaryKey);
    }

    public int insert(LanguagesCount record) {
        return languagesCountMapper.insert(record);
    }

    public LanguagesCount selectByLanguageName(String languageName){
        return languagesCountMapper.selectByLanguageName(languageName);
    }

    public int updateByLanguageName(LanguagesCount record){
        return languagesCountMapper.updateByLanguageName(record);
    }

    public int insertSelective(LanguagesCount record) {
        return languagesCountMapper.insertSelective(record);
    }

    public LanguagesCount selectByPrimaryKey(Integer primaryKey) {
        return languagesCountMapper.selectByPrimaryKey(primaryKey);
    }

    public int updateByPrimaryKeySelective(LanguagesCount record) {
        return languagesCountMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(LanguagesCount record) {
        return languagesCountMapper.updateByPrimaryKey(record);
    }
}
