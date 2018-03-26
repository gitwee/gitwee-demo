package com.gitwee.demo.login.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        Subject subject = SecurityUtils.getSubject();
        try {
//            subject.login(new UsernamePasswordToken());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return  "redirect:/static/html/login.html";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin() {
        return  "/";
    }

    @RequestMapping("/")
    public String main() {
        return "redirect:/static/html/main.html";
    }
}
