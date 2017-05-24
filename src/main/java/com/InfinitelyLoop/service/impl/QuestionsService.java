package com.InfinitelyLoop.service.impl;

import com.InfinitelyLoop.dao.QuestionLanguageMapper;
import com.InfinitelyLoop.dao.QuestionsMapper;
import com.InfinitelyLoop.pojo.QuestionLanguage;
import com.InfinitelyLoop.pojo.Questions;
import com.InfinitelyLoop.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionsService implements CommonService<Questions> {

    @Autowired
    private QuestionsMapper questionsMapper;

    public int deleteByPrimaryKey(Integer primaryKey) {
        return questionsMapper.deleteByPrimaryKey(primaryKey);
    }

    public int insert(Questions record) {
        return questionsMapper.insert(record);
    }

    public int insertSelective(Questions record) {
        return questionsMapper.insertSelective(record);
    }

    public Questions selectByPrimaryKey(Integer commentId) {
        return questionsMapper.selectByPrimaryKey(commentId);
    }

    public int updateByPrimaryKeySelective(Questions record) {
        return questionsMapper.updateByPrimaryKeySelective(record);
    }
    public int updateByPrimaryKey(Questions record) {
        return questionsMapper.updateByPrimaryKey(record);
    }

    public int updateByPrimaryKeyWithBLOBs(Questions record){
        return questionsMapper.updateByPrimaryKeyWithBLOBs(record);
    }
}
