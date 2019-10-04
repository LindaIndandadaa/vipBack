package com.leilin.vip.web.handler;

import com.leilin.vip.entity.UserEntity;
import com.leilin.vip.function.UserFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
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
        /*重定向跳转，因为login.do在webinf下面，不能直接访问*/
        return "redirect:/index.do";
    }

    @RequestMapping("/index.do")
    public String login() {
        return "index";
    }

    //访问welcome界面
    @RequestMapping("/welcome.do")
    public String welcome() {
        return "welcome";
    }

    //退出
    @RequestMapping("/logout.do")
    public String logout(HttpSession session) {
        //让session失效
        session.invalidate();
        return "redirect:/login.jsp";
    }

    /**
     * GET方法是获得视图
     * POST方法是发出请求
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,path = "/updatepassword.do")
    public String updatepasswordView(){

        return null;
    }
    @RequestMapping(method = RequestMethod.POST,path = "/updatepassword.do")
    public String updatepassword( String oldPassword, String newPassword, String newPasswordConfirm, HttpServletRequest request)throws Exception{
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity) session.getAttribute("currentUser");
        try {
            fun.updatepassword(user.getId(), oldPassword, newPassword, newPasswordConfirm);
        }catch (Exception e) {
            request.setAttribute("message",e.getMessage());
            return "updatepassword";
        }
        session.setAttribute("message", "修改成功，请重新登陆");
        return "redirect:/login.jsp";
    }
}
