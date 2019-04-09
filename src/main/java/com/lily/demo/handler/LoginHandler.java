package com.lily.demo.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@Controller
public class LoginHandler {
    /**
     * 本地访问内容地址 ：http://localhost:8080/lmycc/hello
     * @param map
     * @return
     */
    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String helloHtml(HashMap<String, Object> map) {
        map.put("hello", "欢迎进入HTML页面");
        return "login";
    }

}
