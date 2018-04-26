package com.blog.service.impl;

import com.blog.core.utils.StringUtil;
import com.blog.dao.TagDao;
import com.blog.entity.Blog;
import com.blog.entity.KeyAndValue;
import com.blog.entity.Tag;
import com.blog.service.ITagService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
@Service("tagService")
//@Transactional(rollbackFor = Exception.class)
public class TagServiceImpl implements ITagService {
    @Resource
    private TagDao tagDao;
   /* @Resource
    private RedisTemplate<String, String> redisTemplate;*/

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public Integer updatetag(Integer tId) {
        //标签
        List<Tag> tags = tagDao.getAllTags();
        JsonArray jsonArray = new JsonArray();
        for (Tag tag : tags) {
            List<Blog> blogs = tagDao.getblogbytagid(tag.gettId());
            String str = tag.gettName() + " " + "(" + String.valueOf(blogs.size()) + ")";
            KeyAndValue keyAndValue = new KeyAndValue();
            keyAndValue.setKey(tag.gettName());
            keyAndValue.setValue(str);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("key", tag.gettId());
            jsonObject.addProperty("value", str);
            jsonArray.add(jsonObject);
        }
        Iterator iterator = jsonArray.iterator();
        List<KeyAndValue> biaoqian = new ArrayList<>();
        while (iterator.hasNext()) {
            Gson gson = new Gson();
            KeyAndValue keyAndValue = gson.fromJson((JsonObject) iterator.next(), KeyAndValue.class);
            biaoqian.add(keyAndValue);
        }
        biaoqian.sort((o1, o2) -> {
            Integer a = StringUtil.stringgetint(o1.getValue());
            Integer b = StringUtil.stringgetint(o2.getValue());
            return b.compareTo(a);
        });
        Gson gson = new Gson();
        String temp = gson.toJson(biaoqian.size() > 16 ? biaoqian.subList(0, 16) : biaoqian);
//        redisTemplate.opsForValue().set("biaoqian", temp);
        return tId;
    }

    @Override
//    @Cacheable(value = "myCache", keyGenerator = "customKeyGenerator")
    public List<Tag> getAllTags() {
        return tagDao.getAllTags();
    }

    @Override
    public void deleteTag(Integer tId) throws RuntimeException {
        tagDao.deleteByPrimaryKey(tId);
    }

    @Override
    public String getBiaoqian() throws Exception {
//        if (redisTemplate.opsForValue().get("biaoqian") == null) {
//            updatetag(1);
//        }
//        return redisTemplate.opsForValue().get("biaoqian");
        return null;
    }


}