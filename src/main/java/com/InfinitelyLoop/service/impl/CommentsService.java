package com.InfinitelyLoop.service.impl;

import com.InfinitelyLoop.dao.CommentsMapper;
import com.InfinitelyLoop.pojo.Comments;
import com.InfinitelyLoop.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentsService implements CommonService<Comments> {

    @Autowired
    private CommentsMapper commentsMapper;

    public int deleteByPrimaryKey(Integer primaryKey) {
        return commentsMapper.deleteByPrimaryKey(primaryKey);
    }

    public int insert(Comments record) {
        return commentsMapper.insert(record);
    }

    public int insertSelective(Comments record) {
        return commentsMapper.insertSelective(record);
    }

    public Comments selectByPrimaryKey(Integer primaryKey) {
        return commentsMapper.selectByPrimaryKey(primaryKey);
    }

    public int updateByPrimaryKeySelective(Comments record) {
        return commentsMapper.updateByPrimaryKeySelective(record);
    }
    public int updateByPrimaryKey(Comments record) {
        return commentsMapper.updateByPrimaryKey(record);
    }
    public int updateByPrimaryKeyWithBLOBs(Comments record){
        return commentsMapper.updateByPrimaryKeyWithBLOBs(record);
    }

}
