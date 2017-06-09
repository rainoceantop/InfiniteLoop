package com.InfinitelyLoop.service.impl;

import com.InfinitelyLoop.dao.LanguagesCountMapper;
import com.InfinitelyLoop.pojo.LanguagesCount;
import com.InfinitelyLoop.service.CommonService;
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
