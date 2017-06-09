package com.InfinitelyLoop.service;

public interface CommonService<T> {
    int deleteByPrimaryKey(Integer primaryKey);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer primaryKey);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

}
