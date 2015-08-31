package com.superc.commons.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chao on 15/8/28.
 */
@Controller
public class BaseController {
    public Logger logger = LoggerFactory.getLogger(getClass());
    private final ObjectMapper mapper = new ObjectMapper();
    public static ThreadLocal<String> currentPostBody = new ThreadLocal<String>();

    /**
     * SpringMvc下获取request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /**
     * 将 json 转换为 clazz 对象
     *
     * @param clazz class 对象
     * @return 泛型类
     * @throws IOException
     */
    protected <T> T parseBeanFromJson(Class<T> clazz) throws IOException {
        T bean = null;
        currentPostBody.set(null);
        //	ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        InputStream in = getRequest().getInputStream();
        String jsonStr = this.inputStreamToJsonStr(in);
        currentPostBody.set(jsonStr);
        if (jsonStr.length() > 0) {
            bean = mapper.readValue(jsonStr.toString().getBytes("UTF-8"), clazz);
        }
        return bean;
    }

    /**
     * 将 object 转换为 json
     *
     * @param object
     * @return json String
     */
    protected String beanToJson(Object object) {

        return JSON.toJSONString(object);

    }

    /**
     * 转换为 json 对象
     *
     * @param inputStream 输入流
     * @return json object
     * @throws IOException
     */
    protected String inputStreamToJsonStr(InputStream inputStream) {
        StringBuilder json = new StringBuilder(1000);
        byte[] buffer = new byte[2048];
        int l = 0;
        try {
            while ((l = inputStream.read(buffer)) > 0) {
                json.append(new String(buffer, 0, l));
            }
        } catch (IOException e) {
            logger.error("转换 json 出错 ", e);
        }
        logger.debug("接收到的JSON数据 : \n {}", json.toString());
        return buffer.toString();
    }

}
