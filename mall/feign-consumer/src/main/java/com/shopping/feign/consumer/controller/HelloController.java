package com.shopping.feign.consumer.controller;

import com.shopping.api.HelloApi;
import com.shopping.api.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/hello")
public class HelloController {
    private final Logger logger = Logger.getLogger(HelloController.class.getName());
    @Autowired
    private HelloApi helloApi;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "fegin-consumer", method = RequestMethod.GET)
    public String hello() {
        return helloApi.hello();
    }

    @RequestMapping(value = "hello1", method = RequestMethod.GET)
    public String hello1(@RequestParam("name") String name) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return helloApi.hello1(name);
    }

    @RequestMapping(value = "hello2", method = RequestMethod.GET)
    public User hello2(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        return helloApi.hello2(name, age);
    }

    @RequestMapping(value = "hello3", method = RequestMethod.POST)
    public String hello3(@RequestBody User user) {
        return helloApi.hello3(user);
    }

}
