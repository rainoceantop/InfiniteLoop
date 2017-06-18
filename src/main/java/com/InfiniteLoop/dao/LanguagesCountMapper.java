package com.InfiniteLoop.dao;

import com.InfiniteLoop.pojo.LanguagesCount;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguagesCountMapper {
    int insert(LanguagesCount record);

    int insertSelective(LanguagesCount record);

    LanguagesCount selectByLanguageName(String languageName);

    int updateByLanguageName(LanguagesCount record);

    int deleteByPrimaryKey(Integer languageId);

    LanguagesCount selectByPrimaryKey(Integer languageId);

    int updateByPrimaryKeySelective(LanguagesCount record);

    int updateByPrimaryKey(LanguagesCount record);
}
