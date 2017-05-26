package com.InfinitelyLoop.dao;

import com.InfinitelyLoop.pojo.UserLanguage;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLanguageMapper {
    int deleteByPrimaryKey(Integer languageId);

    int insert(UserLanguage record);

    int insertSelective(UserLanguage record);

    UserLanguage selectByPrimaryKey(Integer languageId);

    int updateByPrimaryKeySelective(UserLanguage record);

    int updateByPrimaryKey(UserLanguage record);
}
