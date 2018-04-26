package com.blog.controller;

import com.blog.entity.Image;
import com.blog.service.IImageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
@Controller
public class TripController {
    private final static Logger logger = LoggerFactory.getLogger(TripController.class);
    @Resource
    private IImageService imageService;


    @RequestMapping("/trip")
    public ModelAndView gettrip() {
        return new ModelAndView("trip");
    }

    @RequestMapping("/ajaxpic")
    public void ajaxpic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = request.getParameter("page");
        Integer pagenum;
        if (StringUtils.isEmpty(page)) {
            pagenum = 1;
        } else {
            pagenum = Integer.parseInt(page);
        }
        PageHelper.startPage(pagenum, 15);
        List<Image> lists = imageService.getAllImage();
        PageInfo<Image> images = new PageInfo<>(lists);
        Gson gson = new Gson();
        JsonArray jsonArray = new JsonArray();
        for (Image image : images.getList()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("photo_id", image.getImageid());
            jsonObject.addProperty("unm", image.getImagename());
            jsonObject.addProperty("uid", image.getImageid());
            jsonObject.addProperty("ava", image.getImagepath());
            jsonObject.addProperty("isrc", image.getImagepath());
            jsonObject.addProperty("id", image.getImageid());
            jsonObject.addProperty("msg", image.getContent());
            jsonObject.addProperty("iht", image.getIht());
            jsonArray.add(jsonObject);
        }
        long totalcount = images.getPages();
        String temp = ",\"totalcount\":" + String.valueOf(totalcount) + ",\"has_next\":" +
                String.valueOf(pagenum < totalcount) + "";
        String str = gson.toJson(jsonArray);
        String json = "{\"data\":{\"blogs\":" + str + ",\"hasrp\":true,\"pgsource\":" +
                "\"_\",\"nopth\":false" + temp + "},\"success\":true}";
        response.getWriter().write(json);
    }

    @RequestMapping("/tripbypage")
    public String tripbypage() {
        return "jofej";
    }

    @RequestMapping("/updateallpic")
    public void temppic() {
        try {
            List<Image> list = imageService.getAllImage();
            for (Image image : list) {
                URL url = new URL(image.getImagepath());
                BufferedImage bufferedImg = ImageIO.read(url.openStream());
                int imgWidth = bufferedImg.getWidth();
                int height = bufferedImg.getHeight();
                int iht = (height * 200) / imgWidth;
                image.setIht(iht);
                imageService.updateiht(image);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/imagedetail")
    public void imagedetail(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String str_imageid = request.getParameter("imageid");
        try {
            Integer imageid = Integer.parseInt(str_imageid);
            Image image = imageService.getImagebyId(imageid);
            Gson gson = new Gson();
            response.getWriter().write(gson.toJson(image));
        } catch (Exception e) {
            logger.error("imageid error", e);
            response.getWriter().write("imageid error");
        }
    }
}
