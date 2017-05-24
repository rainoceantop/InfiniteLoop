package com.InfinitelyLoop.service.impl;

import com.InfinitelyLoop.dao.QuestionLanguageMapper;
import com.InfinitelyLoop.pojo.Comments;
import com.InfinitelyLoop.pojo.QuestionLanguage;
import com.InfinitelyLoop.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionLanguageService implements CommonService<QuestionLanguage>{
    @Autowired
    private QuestionLanguageMapper questionLanguageMapper;

    public int deleteByPrimaryKey(Integer primaryKey) {
        return questionLanguageMapper.deleteByPrimaryKey(primaryKey);
    }

    public int insert(QuestionLanguage record) {
        return questionLanguageMapper.insert(record);
    }

    public int insertSelective(QuestionLanguage record) {
        return questionLanguageMapper.insertSelective(record);
    }

    public QuestionLanguage selectByPrimaryKey(Integer commentId) {
        return questionLanguageMapper.selectByPrimaryKey(commentId);
    }

    public int updateByPrimaryKeySelective(QuestionLanguage record) {
        return questionLanguageMapper.updateByPrimaryKeySelective(record);
    }
    public int updateByPrimaryKey(QuestionLanguage record) {
        return questionLanguageMapper.updateByPrimaryKey(record);
    }

}
