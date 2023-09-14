package com.in28minutes.leranspringframework.practice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppSpringPractice {
    public static void main(String[] args) {

        var context=  new AnnotationConfigApplicationContext(HelloSpring.class);


        System.out.println(context.getBean("name"));
        // person3Parameters bean 출력
        System.out.println(context.getBean("person3Parameters"));
        // @Qualifier 사용
        System.out.println(context.getBean("person4Parameters"));
        System.out.println(context.getBean(HelloSpring.class));



    }
}
