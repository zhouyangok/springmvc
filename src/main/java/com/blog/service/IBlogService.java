package com.blog.service;

import com.blog.entity.Blog;
import com.blog.entity.Tag;

import java.util.List;
import java.util.Set;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
public interface IBlogService {
    public List<Blog> getAllBlog();

    public List<Blog> getByCategoryId(int categoryid);

    public Blog getBlogDetail(Integer blogid);

    public Tag getTagByTid(Integer t_id);

    public List<Blog> getBlogByTagId(Integer tId);

    public List<Blog> getBanner();

    public List<Blog> getByHits();

    public List<Blog> getLife();

    public List<Blog> getAllTechBlog();

    public List<Blog> getLuceneBlog(Integer pageStart, String keyword, Integer pagehits);

    public void ajaxbuild();

    public Set<String> ajaxsearch(String keyword);

    public List<Blog> getAllBlogWithContent();

    public Blog preBlog(Integer blogId);

    public Blog nextBlog(Integer blogId);
}
