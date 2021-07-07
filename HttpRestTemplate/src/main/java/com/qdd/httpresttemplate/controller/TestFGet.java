package com.qdd.httpresttemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;

@Controller
public class TestFGet {
    /**
     * 接收传递的json参数解析*/
    @RequestMapping("/getJson")
    public String getJson(HttpServletRequest request,
                          HttpServletResponse response) {
        StringBuffer json = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                System.out.println("line:" + line);
                json.append(line);
            }
        } catch (Exception e) {
            System.out.println(e.toString());

        }
        System.out.println(json.toString());
        return json.toString();
    }
}
