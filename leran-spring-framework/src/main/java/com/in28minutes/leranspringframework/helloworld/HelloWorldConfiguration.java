package com.in28minutes.leranspringframework.helloworld;

// 스프링 설정 클래스 //

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


// spring 이 사용자 지정 클래스의 객체를 관리하도록 할 수 있는지 확인
// record -> ??
// 자바 클래스를 만들 때는 수많은 게터세터 메서드 생성자를 만들게 된다.
// 자바 Bean을 만드는 번거로움을 없애기 위해 도입된 기능
// 게터 세터 생성자를 만들 필요가 없음 , 자동 생성된다.
record Person (String name,int age,Address address) { };
record Address (String firstLine,String City) { };
@Configuration
public class HelloWorldConfiguration {

    // Bean을 호출하는 추가과정
    // (중요)
    @Bean
    public String name() {
        return "Ranga";
    }
    @Bean
    public int age() {
        return 26;
    }

    @Bean
    public Person person() {
        return new Person("Ravi", 20,new Address("main","new york"));
    }
    @Bean
    public Person person2MethodCall() {
        return new Person(name(),age(),address());
    }
    @Bean
    public Person person3Parameters(String name, int age, Address address3) {
        return new Person(name,age,address3);
    }


    @Bean
    @Primary    // Bean의 우선순위 (가장 중요하게 만듬)
    public Person person4Parameters(String name, int age,Address address) {
        return new Person(name,age,address);
    }

    @Bean
    public Person person5Qualifier(String name, int age,@Qualifier("address3Qualifier") Address address) {
        return new Person(name,age,address);
    }



    // 다음과 같이 Bean의 이름을 변경할 수 있다.
    @Bean(name = "address2")
    @Primary
    public Address address() {
        return new Address("city","Suwon");
    }

    @Bean(name = "address3")
    @Qualifier("address3Qualifier") // 한정자 : Bean간의 자동 연결
    public Address address3() {
        return new Address("new", "Seoul");
    }

}
