package com.InfinitelyLoop.dao;

import com.InfinitelyLoop.pojo.Questions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsMapper {
    int deleteByPrimaryKey(Integer questionId);

    int insert(Questions record);

    int insertSelective(Questions record);

    Questions selectByPrimaryKey(Integer questionId);

    List<Questions> selectAllWithoutBlobs();

    List<Questions> selectByLanguageTag(String tag);
    List<String> selectQuestionLanguage();
    List<Questions> selectByQuestionTitle(String queryString);

    int updateByPrimaryKeySelective(Questions record);

    int updateByPrimaryKeyWithBLOBs(Questions record);

    int updateByPrimaryKey(Questions record);
}
