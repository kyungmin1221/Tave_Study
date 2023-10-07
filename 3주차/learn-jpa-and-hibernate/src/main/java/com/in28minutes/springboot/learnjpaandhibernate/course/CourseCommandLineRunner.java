package com.in28minutes.springboot.learnjpaandhibernate.course;

import com.in28minutes.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// 어플리케이션이 시작할 때 insert 쿼리를 시작하게 해주는 클래스

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    // 시작할때 실행하게 하려면 'implements CommandLineRunner' 가 필요
    // spring 시작 시에 실행될 로직이 있을때 'implements CommandLineRunner' 를 활용


//       @Autowired
//       private CourseJdbcRepository repository;

//        @Autowired
//        private CourseJpaRepository repository;

      @Autowired
      private CourseSpringDataJpaRepository repository;


    // run() 메서드 :  시작할 때 실행
    // 쿼리 , 즉 insert 쿼리를 실행
    @Override
    public void run(String... args) throws Exception {
        // 쿼리 실행(데이터 삽입)

        // jdbd,jpa : 데이터 삽입시 insert() 메서드 사용
        // spring data jpa :  데이터를 업데이트 하거나 삽입시 save() 메서드 사용
        repository.save(new Course(1,"Learn AWS JPA","in28minutes"));
        repository.save(new Course(2,"Learn JAVA","in28minutes"));
        repository.save(new Course(3,"Learn IOS hello","in28minutes"));

        // 쿼리 실행(데이터 삭제)
        repository.deleteById(1l);

        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        // 커스텀 메서드 사용
        System.out.println(repository.findByAuthor("in28minutes"));
        System.out.println(repository.findByAuthor(""));

        System.out.println(repository.findByName("Learn JAVA"));
        System.out.println(repository.findByAuthor("Learn IOS hello"));


    }
}
