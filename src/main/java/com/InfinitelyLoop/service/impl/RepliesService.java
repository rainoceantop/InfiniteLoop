package com.InfinitelyLoop.service.impl;

import com.InfinitelyLoop.dao.RepliesMapper;
import com.InfinitelyLoop.pojo.Replies;
import com.InfinitelyLoop.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepliesService implements CommonService<Replies> {
    @Autowired
    private RepliesMapper repliesMapper;

    public int deleteByPrimaryKey(Integer primaryKey) {
        return repliesMapper.deleteByPrimaryKey(primaryKey);
    }

    public int insert(Replies record) {
        return repliesMapper.insert(record);
    }

    public int insertSelective(Replies record) {
        return repliesMapper.insertSelective(record);
    }

    public Replies selectByPrimaryKey(Integer primaryKey) {
        return repliesMapper.selectByPrimaryKey(primaryKey);
    }

    public int updateByPrimaryKeySelective(Replies record) {
        return repliesMapper.updateByPrimaryKeySelective(record);
    }
    public int updateByPrimaryKey(Replies record) {
        return repliesMapper.updateByPrimaryKey(record);
    }

}
