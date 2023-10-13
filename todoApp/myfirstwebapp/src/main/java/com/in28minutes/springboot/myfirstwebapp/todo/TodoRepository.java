package com.in28minutes.springboot.myfirstwebapp.todo;


import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// Repository 는 인터페이스이다
// Repository를 사용하면 엔터티에 액션을 수행할 수 있다.


public interface TodoRepository extends JpaRepository<Todo, Integer>{
    //JpaRepository<1,2> : 1은 관리하는 Bean , 2는 형식

    //  Repository //
    // 레파지토리는 특정 타입의 엔티티 객체를 저장하고 조회하는데 사용되는 메커니즘
    // CRUD 작업을 수행하는 메서드를 포함하는 '인터페이스'로 정의
    public List<Todo> findByUsername(String username);
}