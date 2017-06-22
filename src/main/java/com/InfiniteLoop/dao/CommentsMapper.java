package com.InfiniteLoop.dao;

import com.InfiniteLoop.pojo.Comments;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comments record);

    int insertSelective(Comments record);

    Comments selectByPrimaryKey(Integer commentId);
    List<Comments> selectByQuestionId(Integer questionId);

    int updateByPrimaryKeySelective(Comments record);

    int updateByPrimaryKeyWithBLOBs(Comments record);

    int updateByPrimaryKey(Comments record);
}
