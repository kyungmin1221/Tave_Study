package com.in28minutes.rest.webservices.restfulwebservices.helloworld;


import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

// Rest API //

//  @RestController : 특정 컨트롤러를 Rest API 컨트롤러로 지정하는 어노테이션

@RestController
public class HelloWorldController {

   // @RequestMapping(method = RequestMethod.GET,path = "/hello-world")
   // @GetMapping 은 @RequestMapping 와 쓰임은 같지만 method = "" 부분을 작성하지 않아도 됌


    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;

    }
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {

        // 클래스의 인스턴스를 반환
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello %s",name));
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
       return messageSource.getMessage(
               "good.morning.message",null,"Default Mesage",locale);
       // return "Hello World Internationalized";
    }

}
