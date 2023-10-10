package com.in28minutes.springboot.myfirstwebapp.login;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    // login => com.in28minutes.springboot.myfirstwebapp.login.LoginContoller => login.jsp

    // http://localhost:8080/login?name=kyungmin
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String gotoLoginPage() {
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String gotoWelcomePage() {
        return "welcome";
    }
}
