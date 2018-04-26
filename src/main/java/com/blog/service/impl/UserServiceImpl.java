package com.blog.service.impl;

import com.blog.dao.UserDao;
import com.blog.entity.User;
import com.blog.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhouyang
 * Date 2018/4/25.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

    @Override
    public Boolean login(User user) {

        int result = userDao.login(user);
        if(result>0){
            return true;
        }
        return false;
    }
}
