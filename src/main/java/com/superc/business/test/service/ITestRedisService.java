package com.superc.business.test.service;

import com.superc.mybatis.model.Test;

import java.util.List;

/**
 * Created by chao on 15/8/30.
 */
public interface ITestRedisService {
    void insertRedisTestList(List<Test> testList);
}
