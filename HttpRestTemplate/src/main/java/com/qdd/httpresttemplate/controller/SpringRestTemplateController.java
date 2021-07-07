package com.qdd.httpresttemplate.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
 
@RestController
public class SpringRestTemplateController {
    @Autowired
    private RestTemplate restTemplate;
    /***********HTTP GET method*************/
    @GetMapping("/testGetApi")
    public String getJson(){
        String url="http://api.joloservice.cn/real-name/check?uid=104471097&gamecode=game10001&timestamp=2021-05-31 16:04:45&sign=3fe2a0f484f10875378ff7fda1c18ee2";
//        uid=104471097&gamecode=game10001&timestamp=2021-05-31%2016:04:45&sign=3fe2a0f484f10875378ff7fda1c18ee2
        //String json =restTemplate.getForObject(url,Object.class);
        ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        String json = results.getBody();
        return json;
    }
 
    /**********HTTP POST method**************/
    @PostMapping(value = "/testPost")
    public Object postJson(@RequestBody JSONObject param) {
        System.out.println(param.toJSONString());
        param.put("action", "post");
        param.put("username", "tester");
        param.put("pwd", "123456748");
        return param;
    }
 
    @RequestMapping(value = "/testPostApi")
    public Object testPost() {
        String url = "http://api.joloservice.cn/real-name/check";
//        JSONObject postData = new JSONObject();
        MultiValueMap<String, Object> postData = new LinkedMultiValueMap<String, Object>();
//        HashMap<String, String> postData = new HashMap<String, String>;
        postData.add("uid", "104471097");
        postData.add("gamecode", "game10001");
        postData.add("timestamp", "2021-05-31 16:04:45");
        postData.add("sign", "3fe2a0f484f10875378ff7fda1c18ee2");
        String body = restTemplate.postForEntity(url, postData, String.class).getBody();
        return body;
    }

}