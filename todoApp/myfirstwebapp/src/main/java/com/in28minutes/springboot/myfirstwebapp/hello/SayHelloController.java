package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// @Controller
// 웹 요청을 spring 이 관리 / 처리
public class SayHelloController {

    // http://localhost:8080/say-hello
    @RequestMapping("say-hello")
    //  @RequestMapping :
    //  메서드를 위해 URL 을 설정
    //  @RequestMapping 으로 원하는 요청 URL을 이 메서드에 매핑 가능
    @ResponseBody
    //  @ResponseBody
    // 반환받을 메시지가 리턴한 것 그대로 브라우저에 리턴하게 해줌
    public String sayHello() {

        // "say-hello" 라는 URL을 건들이면 밑의 문자열을 반환한다.
        return "Hello! What r u doing today?";
    }
}
