package com.InfinitelyLoop.dao;

import com.InfinitelyLoop.pojo.QuestionLanguage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionLanguageMapper {
    int deleteByPrimaryKey(Integer languageId);

    int insert(QuestionLanguage record);

    int insertSelective(QuestionLanguage record);

    QuestionLanguage selectByPrimaryKey(Integer languageId);
    List<String> selectColumnName();

    int updateByPrimaryKeySelective(QuestionLanguage record);

    int updateByPrimaryKey(QuestionLanguage record);
}
