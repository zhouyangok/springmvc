package com.blog.service;

import com.blog.entity.Image;

import java.util.List;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
public interface IImageService {
    public List<Image> getAllImage();

    public Integer updateiht(Image image);

    public Image getImagebyId(Integer imageid);
}
