package com.shopping.api;

import com.shopping.api.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("shopping-provider-order")
public interface RefactorHelloApi extends HelloApi {
    @RequestMapping(value = "/hello4", method = RequestMethod.GET)
    String hello4();
}
