package com.example;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {
    @Resource
    HelloService helloService;

    @RequestMapping
    public String hello() {
        log.info("Hello world!");
        return helloService.hello("world!");
    }
}

@Slf4j
@Service
class HelloService {
    public String hello(String str) {
        log.info("str:{}", str);
        return "Hello " + str;
    }
}
