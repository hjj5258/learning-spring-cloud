package com.shopping.feign.consumer.controller;

import com.shopping.api.RefactorHelloApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/refactor")
public class RefactorHelloContorller {
    @Autowired
    private RefactorHelloApi refactorHelloApi;

    @RequestMapping(value = "hello4", method = RequestMethod.GET)
    public String hello4(@RequestParam("name") String name) {
        return refactorHelloApi.hello1(name);
    }
}
