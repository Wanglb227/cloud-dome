package com.wanglb.ribbonconsumer;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.wanglb.ribbonconsumer.service.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 处理类
 *
 * @author
 * @create 2018-08-15 14:20
 **/
@RestController
public class ConsumerController {

    Logger logger  = LoggerFactory.getLogger(ConsumerController.class);
    @Autowired
    ConsumerService consumerService;

    @RequestMapping(value = "ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer(){
        long start = System.currentTimeMillis();
        String result = consumerService.helloService();
        long end = System.currentTimeMillis();
        logger.info("处理时间：【{}】",end-start);
        return result.toString();
    }
}
