package com.InfiniteLoop.dao;


import com.InfiniteLoop.pojo.Language;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageMapper {
    int deleteByPrimaryKey(Integer languageId);

    int insert(Language record);

    int insertSelective(Language record);

    Language selectByPrimaryKey(Integer languageId);
    List<String> selectColumnName();

    int updateByPrimaryKeySelective(Language record);

    int updateByPrimaryKey(Language record);
}
