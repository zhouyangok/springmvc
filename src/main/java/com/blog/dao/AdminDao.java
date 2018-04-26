package com.blog.dao;

import com.blog.entity.Admin;
import org.springframework.stereotype.Repository;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
@Repository
public interface AdminDao  {

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimayKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}
