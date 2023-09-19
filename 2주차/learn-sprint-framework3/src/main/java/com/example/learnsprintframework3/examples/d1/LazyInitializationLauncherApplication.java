package com.example.learnsprintframework3.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component
class ClassA {

}
@Component
// ClassB의 bean 이 시작할 때 초기화 되는것을 허용하지 않는다는 어노테이션 - @Lazy
// 그렇다면 classB는 언제 초기화 ? -> ClassB의 bean 을 사용할 때!
@Lazy
class ClassB {
    private ClassA classA;

    public ClassB(ClassA classA) {
        System.out.println("Some Initialization Logic");
        this.classA = classA;
    }

    public void doSomething() {
        System.out.println("play method doSomething");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {


    public static void main(String[] args) {

        try (var context =
                     new AnnotationConfigApplicationContext
                             (LazyInitializationLauncherApplication.class)) {

           // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println("초기화 완료");
            context.getBean(ClassB.class).doSomething();
        }
    }
}
