package com.in28minutes.leranspringframework.practice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


// record //
// 자바 클래스를 만들 때는 수많은 게터세터 메서드 생성자를 만들게 된다.
// 자바 Bean을 만드는 번거로움을 없애기 위해 도입된 기능
// 게터 세터 생성자를 만들 필요가 없음 , 자동 생성된다.
record Person (String name,int age,Hobby hobby) { };
record Hobby (String hobby) { };
@Configuration
public class HelloSpring {

    @Bean
    public String name() {
        return "kynugmin";
    }
    @Bean
    public int age() {
        return 26;
    }

    @Bean
    public Person person() {
        return new Person("Ravi", 20,new Hobby("soccer"));
    }
    @Bean
    public Person person2MethodCall() {
        return new Person(name(),age(),hobby());
    }

    @Bean
    public Person person3Parameters(String name, int age, Hobby hobby2) {
        return new Person(name,age,hobby2);
    }
    @Bean
    public Person person4Parameters(String name, int age,  @Qualifier("hobby3Qualifier") Hobby hobby3) {
        return new Person(name,age,hobby3);
    }

    // 다음과 같이 Bean의 이름을 변경할 수 있다.
    @Bean(name = "hobby2")
    @Primary
    public Hobby hobby() {
        return new Hobby("baseball");
    }

    @Bean(name = "hobby3")
    @Qualifier("hobby3Qualifier") // 한정자 : Bean간의 자동 연결
    public Hobby hobby3() {
        return new Hobby("game");
    }
}
