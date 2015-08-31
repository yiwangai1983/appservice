package com.superc.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * Created by chao on 15/8/30.
 */
public class BaseRedisDao {
    public final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    protected RedisTemplate redisTemplate;
}
