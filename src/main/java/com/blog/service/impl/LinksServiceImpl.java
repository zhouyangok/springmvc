package com.blog.service.impl;

import com.blog.dao.LinksDao;
import com.blog.entity.Links;
import com.blog.service.ILinksService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
@Service("linksService")
public class LinksServiceImpl implements ILinksService {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(LinksServiceImpl.class);
    @Resource
    private LinksDao linksDao;

    @Override
//    @Cacheable(value = "myCache", keyGenerator = "customKeyGenerator")
    public List<Links> getAllLinks() {
        return linksDao.getAllLinks();
    }
}
