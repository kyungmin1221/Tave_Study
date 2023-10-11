package com.in28minutes.springboot.myfirstwebapp.todo;


import org.springframework.data.jpa.repository.JpaRepository;

//import java.util.List;
//
//// Repository 는 인터페이스이다
//// Repository를 사용하면 엔터티에 액션을 수행할 수 있다.
//public interface TodoRepository extends JpaRepository<Todo,Integer> {
//    //JpaRepository<1,2> : 1은 관리하는 Bean , 2는 형식
//
//    public List<Todo> findByUsername(String username);
//
//}

import java.util.List;

        import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
    public List<Todo> findByUsername(String username);
}