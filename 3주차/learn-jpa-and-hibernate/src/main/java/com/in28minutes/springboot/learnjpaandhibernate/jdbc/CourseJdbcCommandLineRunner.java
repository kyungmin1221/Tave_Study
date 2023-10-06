package com.in28minutes.springboot.learnjpaandhibernate.jdbc;

import course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// 어플리케이션이 시작할 때 insert 쿼리를 시작하게 해주는 클래스

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    // 시작할때 실행하게 하려면 'implements CommandLineRunner' 가 필요
    // spring 시작 시에 실행될 로직이 있을때 'implements CommandLineRunner' 를 활용


    @Autowired
    private CourseJdbcRepository repository;


    // run() 메서드 :  시작할 때 실행
    // 쿼리 , 즉 insert 쿼리를 실행
    @Override
    public void run(String... args) throws Exception {
        // 쿼리 실행(데이터 삽입)
        repository.insert(new Course(1,"Learn AWS NOW","in28minutes"));
        repository.insert(new Course(2,"Learn JAVA NOW","in28minutes"));
        repository.insert(new Course(3,"Learn IOS NOW","in28minutes"));

        // 쿼리 실행(데이터 삭제)
        repository.deleteById(1);

    }
}
