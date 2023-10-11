package com.in28minutes.springboot.myfirstwebapp.login;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//@SessionAttributes("") : model 에 넣은 값의 범위(적용범위)를 넓히기 위한 어노테이션
// ("") 안의 속성을 사용할 "모든 클래스" 에 해당 어노테이션을 추가해야됨을 유의 해야한다.
@SessionAttributes("name")
public class WelcomeController {
    // login => com.in28minutes.springboot.myfirstwebapp.login.LoginContoller => login.jsp
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String gotoWelcomePage(ModelMap model) {
        model.put("name", getLoggedinUsername());
        return "welcome";
    }

    private String getLoggedinUsername() {

        // 현재 인증된 주체를 제공
        // 인증된 사용자가 있다면 밑의 메소드를 통해 받을 수 있음
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();
    }
}


