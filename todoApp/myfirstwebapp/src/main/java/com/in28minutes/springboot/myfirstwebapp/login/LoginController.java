package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // login => com.in28minutes.springboot.myfirstwebapp.login.LoginContoller => login.jsp


    // http://localhost:8080/login?name=kyungmin
    @RequestMapping("login")
    public String gotoLoginPage(@RequestParam String name, ModelMap model) {
        model.put("name",name);
        System.out.println("Requset param is " + name);
        return "login";
    }
}
