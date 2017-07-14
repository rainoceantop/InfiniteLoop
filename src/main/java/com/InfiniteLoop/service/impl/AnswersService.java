package com.InfiniteLoop.service.impl;

import com.InfiniteLoop.dao.AnswersMapper;
import com.InfiniteLoop.pojo.Answers;
import com.InfiniteLoop.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnswersService implements CommonService<Answers> {

    @Autowired
    private AnswersMapper answersMapper;

    public int deleteByPrimaryKey(Integer primaryKey) {
        return answersMapper.deleteByPrimaryKey(primaryKey);
    }

    public int insert(Answers record) {
        return answersMapper.insert(record);
    }

    public int insertSelective(Answers record) {
        return answersMapper.insertSelective(record);
    }

    public Answers selectByPrimaryKey(Integer primaryKey) {
        return answersMapper.selectByPrimaryKey(primaryKey);
    }
    public List<Answers> selectByQuestionId(Integer questionId){
        return answersMapper.selectByQuestionId(questionId);
    }

    public int updateByPrimaryKeySelective(Answers record) {
        return answersMapper.updateByPrimaryKeySelective(record);
    }
    public int updateByPrimaryKey(Answers record) {
        return answersMapper.updateByPrimaryKey(record);
    }
    public int updateByPrimaryKeyWithBLOBs(Answers record){
        return answersMapper.updateByPrimaryKeyWithBLOBs(record);
    }

}
