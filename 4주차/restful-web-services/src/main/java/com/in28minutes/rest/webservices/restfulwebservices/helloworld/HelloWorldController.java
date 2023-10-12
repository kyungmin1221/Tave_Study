package com.in28minutes.rest.webservices.restfulwebservices.helloworld;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Rest API
// 특정 컨트롤러를 Rest API 컨트롤러로 지정하는 어노테이션 : @RestController
@RestController
public class HelloWorldController {

   // @RequestMapping(method = RequestMethod.GET,path = "/hello-world")
   // @GetMapping 은 @RequestMapping 와 쓰임은 같지만 method = "" 부분을 작성하지 않아도 됌
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {

        // 클래스의 인스턴스를 반환
        return new HelloWorldBean("Hello World");
    }

}
