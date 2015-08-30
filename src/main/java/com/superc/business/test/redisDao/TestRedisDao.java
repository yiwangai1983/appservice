package com.superc.business.test.redisDao;

import com.alibaba.fastjson.JSON;
import com.superc.mybatis.model.Test;
import com.superc.redis.BaseRedisDao;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chao on 15/8/30.
 */
@Repository
public class TestRedisDao extends BaseRedisDao {

    public void insertRedisTestList(final List<Test> testList) {
        final String hkey = "testJson";
        SessionCallback sessionCallback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                //开启事物
                redisOperations.multi();
                HashOperations<String, String, String> hashOperations = redisOperations.opsForHash();

//                hashOperations.put(hkey, "1232132", JSON.toJSONString(testList));
                for(Test detail : testList){
                    hashOperations.put(hkey,String.valueOf(detail.hashCode()),JSON.toJSONString(detail));
                }
                redisOperations.exec();
                return null;
            }
        };
        super.redisTemplate.execute(sessionCallback);
        logger.info("save hash redis with json : {}",JSON.toJSONString(testList));
    }
}
