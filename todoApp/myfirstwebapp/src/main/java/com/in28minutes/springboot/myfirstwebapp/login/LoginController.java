package com.in28minutes.springboot.myfirstwebapp.login;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//@SessionAttributes("") : model 에 넣은 값의 범위(적용범위)를 넓히기 위한 어노테이션
// ("") 안의 속성을 사용할 "모든 클래스" 에 해당 어노테이션을 추가해야됨을 유의 해야한다.
@SessionAttributes("name")
public class LoginController {

    private AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        super();
        this.authenticationService = authenticationService;
    }

    // login => com.in28minutes.springboot.myfirstwebapp.login.LoginContoller => login.jsp
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String gotoLoginPage() {
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {

        if (authenticationService.authenticate(name,password)) {
            model.put("name", name);
            // 입력이 유효한 경우 리턴할 값
            return "welcome";
        }

        model.put("error","error message");
        // 입력이 유효하지 않는 경우 리턴할 값
        return "login";
    }
}
