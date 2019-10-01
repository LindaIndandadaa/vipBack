package com.leilin.vip.web.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginHandler {
    @RequestMapping("/index.do")
    public String login(String name, String pw) {
        System.out.println("handler");
        return "login";
    }
}
