package com.blog.service;

import com.blog.entity.User;

/**
 * Created by zhouyang
 * Date 2018/4/25.
 */
public interface IUserService {

     User selectUser(long userId);

     Boolean login(User user);

}
