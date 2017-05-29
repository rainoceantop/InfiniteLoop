package com.InfinitelyLoop.dao;

import com.InfinitelyLoop.pojo.UserDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailMapper {
    int deleteByPrimaryKey(Integer userDetailId);

    int insert(UserDetail record);

    int insertSelective(UserDetail record);

    UserDetail selectByPrimaryKey(Integer userDetailId);
    UserDetail selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(UserDetail record);

    int updateByPrimaryKey(UserDetail record);
}
