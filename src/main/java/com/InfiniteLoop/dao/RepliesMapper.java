package com.InfiniteLoop.dao;

import com.InfiniteLoop.pojo.Replies;
import org.springframework.stereotype.Repository;

@Repository
public interface RepliesMapper {
    int deleteByPrimaryKey(Integer replyId);

    int insert(Replies record);

    int insertSelective(Replies record);

    Replies selectByPrimaryKey(Integer replyId);

    int updateByPrimaryKeySelective(Replies record);

    int updateByPrimaryKey(Replies record);
}
