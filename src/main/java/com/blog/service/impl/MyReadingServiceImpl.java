package com.blog.service.impl;

import com.blog.dao.MyreadingDao;
import com.blog.entity.Myreading;
import com.blog.service.IMyReadingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
@Service("iMyReadingService")
public class MyReadingServiceImpl implements IMyReadingService {
    private static final Logger logger = LoggerFactory.getLogger(MyReadingServiceImpl.class);
    @Resource
    private MyreadingDao myreadingDao;

    @Override
//    @Cacheable(value = "myCache", keyGenerator = "customKeyGenerator")
    public Set<Myreading> getAllReading() {
        List<Myreading> list = myreadingDao.getAllReading();
        Set<Myreading> set = new HashSet<>(list);
        try {
            for (Myreading myreading : list) {
                myreading.setRentdate(myreading.getRentdate() != null ? myreading.getRentdate() : "");
                myreading.setReturndate(myreading.getReturndate() != null ? myreading.getReturndate() : "");
            }
        } catch (Exception e) {
            logger.error("阅读记录", e);
        }
        return set;
    }
}
