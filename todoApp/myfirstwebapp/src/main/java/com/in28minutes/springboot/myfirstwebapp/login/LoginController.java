package com.in28minutes.springboot.myfirstwebapp.login;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    // login => com.in28minutes.springboot.myfirstwebapp.login.LoginContoller => login.jsp

    // http://localhost:8080/login?name=kyungmin
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String gotoLoginPage() {
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
        model.put("name",name);
        model.put("password",password);

        return "welcome";
    }
}
