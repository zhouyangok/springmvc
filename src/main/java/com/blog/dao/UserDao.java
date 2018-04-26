package com.blog.dao;

import com.blog.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by zhouyang
 * Date 2018/4/25.
 */
@Repository
public interface UserDao {

    User selectUser(long id);

    int login(User user);

}
