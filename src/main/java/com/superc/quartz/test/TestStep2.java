package com.superc.quartz.test;

import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

/**
 * Created by super on 2015/8/31.
 */
@Component("testStep2")
public class TestStep2 implements Tasklet {
    Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        logger.info("spring batch : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   2");
        return null;
    }
}
