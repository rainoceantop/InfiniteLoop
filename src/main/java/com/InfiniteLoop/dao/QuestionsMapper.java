package com.InfiniteLoop.dao;

import com.InfiniteLoop.pojo.Questions;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface QuestionsMapper {
    int deleteByPrimaryKey(Integer questionId);

    int insert(Questions record);

    int insertSelective(Questions record);

    int recordsCount();

    Questions selectByPrimaryKey(Integer questionId);

    List<Questions> selectAllWithoutBlobs(Map<String,Integer> map);

    List<Questions> selectByLanguageTag(String tag);

    List<String> selectQuestionLanguage();

    List<Questions> selectByQuestionTitle(String queryString);

    String selectQuestionUpId(Integer questionId);

    String selectQuestionDownId(Integer questionId);

    int updateByPrimaryKeySelective(Questions record);

    int updateQuestionLikesByQuestionId(Map m);

    int updateByPrimaryKeyWithBLOBs(Questions record);

    int updateByPrimaryKey(Questions record);

    int updateQuestionUpId(Map m);

    int updateQuestionDownId(Map m);
}
