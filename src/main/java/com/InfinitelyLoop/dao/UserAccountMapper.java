package com.InfinitelyLoop.dao;

import com.InfinitelyLoop.pojo.UserAccount;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserAccount record);

    int insertSelective(UserAccount record);

    UserAccount selectByPrimaryKey(Integer userId);

    UserAccount selectByUsername(String username);


    int updateByPrimaryKeySelective(UserAccount record);

    int updateByPrimaryKey(UserAccount record);

}
