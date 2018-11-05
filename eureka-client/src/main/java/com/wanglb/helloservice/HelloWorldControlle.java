package com.wanglb.helloservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;


/**
 * rest ful
 *
 * @author
 * @create 2018-08-12 10:46
 **/
@RestController
public class HelloWorldControlle {

    static final Logger logger = LoggerFactory.getLogger(HelloWorldControlle.class);
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHelloWorld() throws InterruptedException {
       List sName =  client.getServices();
       int sleepTime =  new Random().nextInt(3000);
       Thread.sleep(sleepTime);
        logger.info("服务名称：【{}】,睡眠时间：【{}】,to string【{}】", sName, sleepTime, this.toString());
        return "hello world!";
    }
}
