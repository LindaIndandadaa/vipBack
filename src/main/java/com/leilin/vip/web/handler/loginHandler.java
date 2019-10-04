package com.leilin.vip.web.handler;

import com.leilin.vip.entity.UserEntity;
import com.leilin.vip.function.UserFunction;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class loginHandler {
    @Autowired
    UserFunction fun;//注入业务层对象

    @RequestMapping("/login.do")
    public String login(String account, String password, HttpServletRequest request) {
        try{
            UserEntity u = fun.login(account,password);
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", u);
        }catch (Exception e) {
            //失败
            request.setAttribute("message", e.getMessage());
            return "forward:/login.jsp";
        }
        //重定向跳转，因为login.do在webinf下面，不能直接访问
        return "redirect:/index.do";
    }

    @RequestMapping("/index.do")//使用内部跳转
    public String login() {
        return "index";
    }
}
