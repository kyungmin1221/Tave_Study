package com.in28minutes.springboot.learnjpaandhibernate.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// spring jdbc 를 사용해 데이터베이스에 쿼리를 사용해 보려는 작업

@Repository     // 보통 Spring에서 클래스가 데이터베이스에 연결될 때 어노테이션은 @Repository 을 사용한다
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    // TEST BLOCK( """ ~ """) : 쿼리 형식을 그대로 유지 가능
    private static String INSERT_QUERY =
            """
                insert into course (id,name,author)
                values(1,'Learn AWS','in28minutes');
             """;

    public void insert() {
        // update 메서드로 쿼리를 실행
        springJdbcTemplate.update(INSERT_QUERY);
    }
}
