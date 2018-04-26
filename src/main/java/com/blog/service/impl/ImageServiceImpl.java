package com.blog.service.impl;

import com.blog.entity.Image;
import com.blog.service.IImageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
@Service("iImageService")
public class ImageServiceImpl implements IImageService {
    @Override
    public List<Image> getAllImage() {
        return null;
    }

    @Override
    public Integer updateiht(Image image) {
        return null;
    }

    @Override
    public Image getImagebyId(Integer imageid) {
        return null;
    }
}
