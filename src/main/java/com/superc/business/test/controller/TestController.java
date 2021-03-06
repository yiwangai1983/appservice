package com.superc.business.test.controller;

import com.superc.business.test.service.ITestRedisService;
import com.superc.commons.controller.BaseController;
import com.superc.mybatis.model.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by chao on 15/8/30.
 */
@Controller
public class TestController extends BaseController {

    @Resource
    ITestRedisService testRedisService;

    @ResponseBody
    @RequestMapping(value = "/testredis")
    public ModelAndView testView(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView("/test/test");

        List<Test> list = new ArrayList<Test>();
        for (int i = 0; i < 10; i++) {
            Test t = new Test();
            t.setName(i+UUID.randomUUID().toString());
            t.setId(Long.parseLong(String.valueOf(i)));
            t.setDate(new Date());
            t.setText("asdfwefwegergergergergwef");
            list.add(t);
        }
        testRedisService.insertRedisTestList(list);
        return modelAndView;
    }

}
