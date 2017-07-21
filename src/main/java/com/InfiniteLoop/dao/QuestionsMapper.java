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

    //总记录数
    int recordsCount();

    //搜索标签后的总记录数
    int selectTagRecordsCount(String queryString);

    //搜索标题后的总记录数
    int selectTitleRecordsCount(String queryString);

    Questions selectByPrimaryKey(Integer questionId);

    List<Questions> selectAllWithoutBlobs(Map<String,Integer> map);

    List<Questions> selectByLanguageTag(Map map);

    List<String> selectQuestionLanguage();

    List<Questions> selectByQuestionTitle(Map map);

    String selectQuestionUpId(Integer questionId);

    String selectQuestionDownId(Integer questionId);

    int updateByPrimaryKeySelective(Questions record);

    int updateQuestionLikesByQuestionId(Map m);

    int updateByPrimaryKeyWithBLOBs(Questions record);

    int updateByPrimaryKey(Questions record);

    int updateQuestionUpId(Map m);

    int updateQuestionDownId(Map m);
}
