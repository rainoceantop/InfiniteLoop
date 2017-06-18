package com.InfiniteLoop.dao;

import com.InfiniteLoop.pojo.UserAccount;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserAccount record);

    int insertSelective(UserAccount record);

    UserAccount selectByPrimaryKey(Integer userId);

    UserAccount selectByUsername(String username);

    UserAccount selectByKeyword(UserAccount record);

    int updateByPrimaryKeySelective(UserAccount record);

    int updateByPrimaryKey(UserAccount record);

}
