package com.blog.service.impl;

import com.blog.core.common.Config;
import com.blog.dao.WeiboDao;
import com.blog.entity.Weibo;
import com.blog.service.IWeiboService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhouyang
 * Date 2018/4/26.
 */
@Service("weiboService")
public class WeiboServiceImpl implements IWeiboService {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(WeiboServiceImpl.class);
    private static final Map<Integer, String> TYPE = new ConcurrentHashMap<>();
    private static final CloseableHttpClient httpClient = HttpClients
            .custom()
            .setDefaultRequestConfig(
                    RequestConfig.custom()
                            .build()).build();

    static {
        TYPE.put(1, "正向");
        TYPE.put(2, "负向");
        TYPE.put(3, "客观");
    }

    @Resource
    private WeiboDao weiboDao;
//    @Resource
//    private DubboService dubboService;

    @Override
//    @Cacheable(value = "myCache", keyGenerator = "customKeyGenerator")
    public List<Weibo> getAllWeiboToday() {
        List<Weibo> weibos = null;
        try {
//            weibos = dubboService.getAllWeiboToday();
        } catch (Exception e) {
            logger.error("服务出错", e);
            weibos = weiboDao.getAllWeiboToday();
        }
        for (Weibo weibo : weibos) {
            try {
                weibo.setTypename(TYPE.get(weibo.getType()));
            } catch (Exception e) {
                logger.error("分类类型错误", e);
            }
        }
        return weibos;
    }

    @Override
    public JsonObject getWeiboDetail(String sentence) {
        JsonObject object = null;
        CloseableHttpResponse response = null;
        try {
            HttpClientContext context = HttpClientContext.create();
            String weiboflaskurl = Config.getProperty("weiboflask.url");
            HttpGet httpGet = new HttpGet(weiboflaskurl + URLEncoder.encode(sentence.replaceAll("/", ""), "utf-8"));
            response = httpClient.execute(httpGet, context);
            HttpEntity entity = response.getEntity();
            JsonParser parser = new JsonParser();
            String str = EntityUtils.toString(entity);
            object = parser.parse(str).getAsJsonObject();
            if (StringUtils.isNotEmpty(object.get("type").toString())) {
                object.addProperty("type", TYPE.get(Integer.parseInt(object.get("type").toString())));
            }
            response.close();
        } catch (IOException e) {
            logger.error("", e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return object;
    }
}
