package com.in28minutes.leranspringframework.examples.c1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class RealWorldSpringContextLauncherApplication {
    public static void main(String[] args) {

      try( var context =
                    new AnnotationConfigApplicationContext
                            (RealWorldSpringContextLauncherApplication.class)) {

          // 모든 Bean 을 출력
          Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

          System.out.println( context.getBean(BusinessCalculationService.class).findMax());


      }
    }
}
