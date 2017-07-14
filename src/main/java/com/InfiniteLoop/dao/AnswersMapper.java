package com.InfiniteLoop.dao;

import com.InfiniteLoop.pojo.Answers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswersMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Answers record);

    int insertSelective(Answers record);

    Answers selectByPrimaryKey(Integer answerId);
    List<Answers> selectByQuestionId(Integer questionId);

    int updateByPrimaryKeySelective(Answers record);

    int updateByPrimaryKeyWithBLOBs(Answers record);

    int updateByPrimaryKey(Answers record);
}
