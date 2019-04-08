package com.lily.demo.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebChatHandler {

    @RequestMapping("webchat")
    public String webChat() {
        return "webchat";
    }
}
