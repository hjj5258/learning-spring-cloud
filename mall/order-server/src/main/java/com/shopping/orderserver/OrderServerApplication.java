package com.shopping.orderserver;

import com.shopping.api.HelloApi;
import com.shopping.api.RefactorHelloApi;
import com.shopping.api.dto.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableEurekaClient
@RestController
public class OrderServerApplication implements HelloApi, RefactorHelloApi {
    public static void main(String[] args) {
        SpringApplication.run(OrderServerApplication.class, args);
    }

    @Value("${server.port}")
    private String serverPort;

    @Override
    public String hello() {
        return "Hello world port from:" + serverPort;
    }


    @Override
    public String hello1(@RequestParam("name") String name) {
        return name;
    }

    @Override
    public User hello2(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        return new User(name, age);
    }

    @Override
    public String hello3(@RequestBody User user) {
        return "hello name: " + user.getName() + ",age: " + user.getAge();
    }

    @Override
    public String hello4() {
        return "hello 4";
    }
}
