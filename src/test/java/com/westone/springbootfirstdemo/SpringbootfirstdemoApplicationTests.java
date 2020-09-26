package com.westone.springbootfirstdemo;

import com.westone.springbootfirstdemo.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootfirstdemoApplicationTests {

    @Autowired
    HelloController helloController;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {
        System.out.println(helloController.sayHello()+" everything is good");

        logger.trace("这是trace日志。。。。。。");
        logger.debug("这是debug日志。。。。。。");
        logger.info("这是info日志。。。。。。。");
        logger.warn("这是warn日志。。。。。。。。");
        logger.error("这是error日志。。。。。。。");

    }

}
