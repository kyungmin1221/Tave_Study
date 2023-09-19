package com.example.learnsprintframework3.examples.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
class SomeClass {
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("모든 의존성 준비 완료");
    }

    @PostConstruct
    // 의존성을 연결하는 대로 초기화 논리를 실행하려는 경우 사용
    // 예를 들어 데이터베이스 등에서 데이터를 가져오려는 경우 사용 가능
    public void initialize() {
        someDependency.getReady();
    }

    @PreDestroy
    // @PreDestroy
    // 컨테이너에서 인스턴스를 삭제하는 과정중에 있음을 알려주는 콜백 알림
    // PreDestroy 를 어노테이션한 메서드는 보유하고 있던 리소스를 해제하는데 일반적으로 사용
    // 컨테이너에서 Bean이 삭제되기 전에, 애플리케이션 컨텍스트에서 삭제되기 전에 clean up 을 수행하려는 경우는 @PreDestroy 사용 가능
    public void cleanup() {
        System.out.println("Clean Up!!");
    }
}

@Component
class SomeDependency {
    public void getReady() {
        System.out.println("some logic using SomeDependency ! ");
    }
}




@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {


    public static void main(String[] args) {

        try (var context =
                     new AnnotationConfigApplicationContext
                             (PrePostAnnotationsContextLauncherApplication.class)) {

             Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        }
    }
}
