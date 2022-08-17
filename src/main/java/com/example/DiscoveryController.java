package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/discovery")
public class DiscoveryController {
    @Resource
    RestTemplate restTemplate;

    @RequestMapping("/get")
    public Map<String, String> get() {
        log.info("demo-server/get");
        return restTemplate.getForObject("http://demo-server/demo/get", Map.class);
    }

    @RequestMapping("/post")
    public Map<String, String> post() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        // 提交参数设置
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("param", "haha post");

        // 组装请求体
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        log.info("demo-server/post:{}", map);
        return restTemplate.postForObject("http://demo-server/demo/post", request, Map.class);
    }

    @RequestMapping("/json")
    public Map<String, String> json() {
        Map<String, String> req = new HashMap<>();
        req.put("haha", "haha json");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(req, headers);

        log.info("demo-server/json:{}", req);
        return restTemplate.postForObject("http://demo-server/demo/json", request, Map.class);
    }

    @GetMapping("/test/{string}")
    public String echo(@PathVariable String string) {
        return "Hello " + string;
    }
}
