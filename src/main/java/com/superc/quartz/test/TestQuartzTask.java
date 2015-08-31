package com.superc.quartz.test;

import org.springframework.stereotype.Component;

/**
 * Created by super on 2015/8/31.
 */
@Component("testQuartzTask")
public class TestQuartzTask {

    public void testTask() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

    }
}
