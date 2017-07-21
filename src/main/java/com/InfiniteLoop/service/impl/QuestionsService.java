package com.InfiniteLoop.service.impl;

import com.InfiniteLoop.dao.QuestionsMapper;
import com.InfiniteLoop.pojo.Questions;
import com.InfiniteLoop.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public int recordsCount(){
        return questionsMapper.recordsCount();
    }
    public int selectTagRecordsCount(String queryString){
        return questionsMapper.selectTagRecordsCount(queryString);
    }
    public List<Questions> selectAllWithoutBlobs(Map<String,Integer> map){
        return questionsMapper.selectAllWithoutBlobs(map);
    }

    public List<String> selectQuestionLanguage(){
        return questionsMapper.selectQuestionLanguage();
    }

    public List<Questions> selectByLanguageTag(Map map){
        return questionsMapper.selectByLanguageTag(map);
    }

    public int selectTitleRecordsCount(String queryString){
        return questionsMapper.selectTitleRecordsCount(queryString);
    }

    public List<Questions> selectByQuestionTitle(Map map){
        return questionsMapper.selectByQuestionTitle(map);
    }
    public String selectQuestionUpId(Integer questionId){
        return questionsMapper.selectQuestionUpId(questionId);
    }
    public String selectQuestionDownId(Integer questionId){
        return questionsMapper.selectQuestionDownId(questionId);
    }
    public int updateByPrimaryKeySelective(Questions record) {
        return questionsMapper.updateByPrimaryKeySelective(record);
    }
    public int updateQuestionLikesByQuestionId(Map m){
        return questionsMapper.updateQuestionLikesByQuestionId(m);
    }
    public int updateByPrimaryKey(Questions record) {
        return questionsMapper.updateByPrimaryKey(record);
    }

    public int updateByPrimaryKeyWithBLOBs(Questions record){
        return questionsMapper.updateByPrimaryKeyWithBLOBs(record);
    }
    public int updateQuestionUpId(Map m){
        return questionsMapper.updateQuestionUpId(m);
    }
    public int updateQuestionDownId(Map m){
        return questionsMapper.updateQuestionDownId(m);
    }
}
