package com.example.demo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/get")
    public Map<String, String> get() {
        log.info("demo get");
        HashMap<String, String> map = new HashMap<>();
        map.put("state", "ok");
        return map;
    }

    @RequestMapping("/post")
    public Map<String, Object> post(String param) {
        Map<String, Object> map = new HashMap<>();
        map.put("state", "ok");
        map.put("body", param);
        log.info("demo post:{}", map);
        return map;
    }

    @PostMapping("/json")
    public Map<String, String> json(@RequestBody Map<String, String> body) {
        body.put("state", "ok");
        log.info("demo json:{}", body);
        return body;
    }
}
