package com.InfiniteLoop.dao;

import com.InfiniteLoop.pojo.UserDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailMapper {
    int deleteByPrimaryKey(Integer userDetailId);

    int insert(UserDetail record);

    int insertSelective(UserDetail record);

    UserDetail selectByPrimaryKey(Integer userDetailId);
    UserDetail selectByUserId(Integer userId);

    int updateByUserIdSelective(UserDetail record);
    int updateByPrimaryKeySelective(UserDetail record);

    int updateByPrimaryKey(UserDetail record);
    int updateUserAvatarByUserId(UserDetail record);
}
