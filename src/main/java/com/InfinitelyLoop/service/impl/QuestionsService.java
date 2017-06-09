package com.InfinitelyLoop.service.impl;

import com.InfinitelyLoop.dao.QuestionsMapper;
import com.InfinitelyLoop.pojo.Questions;
import com.InfinitelyLoop.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Questions selectByPrimaryKey(Integer primaryKey) {
        return questionsMapper.selectByPrimaryKey(primaryKey);
    }
    public List<Questions> selectAllWithoutBlobs(){
        return questionsMapper.selectAllWithoutBlobs();
    }

    public List<String> selectQuestionLanguage(){
        return questionsMapper.selectQuestionLanguage();
    }

    public List<Questions> selectByLanguageTag(String tag){
        return questionsMapper.selectByLanguageTag(tag);
    }
    public List<Questions> selectByQuestionTitle(String queryString){
        return questionsMapper.selectByQuestionTitle(queryString);
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
