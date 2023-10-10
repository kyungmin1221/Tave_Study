package com.in28minutes.springboot.myfirstwebapp.login;


// 특정 사용자를 인증하려는 클래스 //
// 맞으면 로그인이 되고 틀리면 다시 로그인창으로 복귀 -> boolean 을 리턴하여 생성

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {

        boolean isValidUserName = username.equalsIgnoreCase("kyungmin");
        boolean isValidPassword = password.equalsIgnoreCase("sun");

        return isValidUserName && isValidPassword;
    }
}
