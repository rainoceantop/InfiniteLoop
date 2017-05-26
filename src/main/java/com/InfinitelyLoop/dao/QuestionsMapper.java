package com.InfinitelyLoop.dao;

import com.InfinitelyLoop.pojo.Questions;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsMapper {
    int deleteByPrimaryKey(Integer questionId);

    int insert(Questions record);

    int insertSelective(Questions record);

    Questions selectByPrimaryKey(Integer questionId);

    int updateByPrimaryKeySelective(Questions record);

    int updateByPrimaryKeyWithBLOBs(Questions record);

    int updateByPrimaryKey(Questions record);
}
