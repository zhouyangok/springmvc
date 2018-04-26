package com.blog.dao;

import com.blog.entity.IpLog;
import org.springframework.stereotype.Repository;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
@Repository
public interface IpLogDao {
    int deleteByPrimaryKey(Integer id);

    int insert(IpLog record);

    int insertSelective(IpLog record);

    IpLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IpLog record);

    int updateByPrimaryKey(IpLog record);
}
