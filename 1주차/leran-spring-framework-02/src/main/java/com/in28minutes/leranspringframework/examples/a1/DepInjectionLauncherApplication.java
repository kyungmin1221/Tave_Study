package com.in28minutes.leranspringframework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;


// 각 클래스에 대한 Bean 을 생성하기위해 @Component 입력
@Component
class YourBusinessClass {

    // 의존성 주입
    Dependency1 dependency1;
    Dependency2 dependency2;

    // 생성자 의존성 주입
    @Autowired
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        super();
        System.out.println("생성자 의존성 주입 확인");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    // setter 의존성 주입
    //    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        System.out.println("setter dependecy1 의존성 주입");
//        this.dependency1 = dependency1;
//    }
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        System.out.println("setter dependecy2 의존성 주입");
//        this.dependency2 = dependency2;
//    }



    @Override
    public String toString() {
        return "Using " + dependency1 + " and " + dependency2 ;
    }
}
@Component
class Dependency1 { }
@Component
class Dependency2{ }


@Configuration
// @ComponentScan("") : 자동으로 현재 패키지를 스캔해주는 역할을 한다. (뒤에 패키지를 지정하지 않으면 스캔되는 대상은 현재 이 패키지이다.)
@ComponentScan
public class DepInjectionLauncherApplication {


    public static void main(String[] args) {

        try (var context =
                     new AnnotationConfigApplicationContext
                             (DepInjectionLauncherApplication.class)) {

            // spring context에 어떤 bean이 쓰였는지 확인하는 메서
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(YourBusinessClass.class));
        }
    }
}
