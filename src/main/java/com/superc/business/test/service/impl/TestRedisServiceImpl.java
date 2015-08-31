package com.superc.business.test.service.impl;

import com.superc.business.test.redisDao.TestRedisDao;
import com.superc.business.test.service.ITestRedisService;
import com.superc.mybatis.model.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by chao on 15/8/30.
 */
@Service("testRedisService")
public class TestRedisServiceImpl implements ITestRedisService{

    @Resource
    TestRedisDao testRedisDao;

    @Override
    public void insertRedisTestList(List<Test> testList) {
        testRedisDao.insertRedisTestList(testList);
    }
}
