package com.in28minutes.leranspringframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        // 1. Launch a spring Context
        // spring 콘텍스트 생성을 위함
        // try : 프라이빗 리소스 - 코드 내에서 예외가 발생하면 상활별 단서가 자동 호
        try (var context =
                     new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {


            // 관리하고자 하는 항목을 설정
            // 2. Configure the things that we want Spring to manage
            // ->  HelloWorldConfiguration 클래스 -> @Configuration - 스프링 컨텍스트를 시작할 수 있다.
            // name - @Bean

            // 3. spring이 관리하는 Bean을 검색하고 있다.
            // bean은 context.getBean 을 사용하고 Bean에 이름을 부여하여 검색할 수 있다.
            // spring 이 bean을 관리
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameters"));
            System.out.println(context.getBean("address2"));
            System.out.println(context.getBean(Address.class));

            System.out.println(context.getBean("person5Qualifier"));


            // spring이 관리하는 Bean 프레임워를 모두 나열할 수 있다.
            // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
