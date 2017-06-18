package com.InfiniteLoop.service.impl;

import com.InfiniteLoop.dao.RepliesMapper;
import com.InfiniteLoop.pojo.Replies;
import com.InfiniteLoop.service.CommonService;
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
