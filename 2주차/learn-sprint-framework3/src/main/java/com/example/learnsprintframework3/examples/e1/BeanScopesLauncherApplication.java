package com.example.learnsprintframework3.examples.e1;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
// 반환되는 인스턴스 값이 같다
class NormalClass {


}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
// 반횐되는 인스턴스 값이 다름
// bean을 요청할 때 마다 bean 인스턴스가 새로 생성
@Component
class PrototypeClass {

}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {


    public static void main(String[] args) {

        try (var context =
                     new AnnotationConfigApplicationContext
                             (BeanScopesLauncherApplication.class)) {

        //    Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
         //   System.out.println("초기화 완료");

            System.out.println(context.getBean(NormalClass.class));
            System.out.println(context.getBean(NormalClass.class));

            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));

        }
    }
}
