package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
                values(?,?,?);
             """;

    private static String DELETE_QUERY =
            """
                delete from course
                where id= ?
             """;

    private static String SELECT_QUERY =
            """
                select * from course
                where id= ?
             """;

    public void insert(Course course) {
        // update 메서드로 쿼리를 실행
        springJdbcTemplate.update(INSERT_QUERY,
                course.getId(),course.getName(),course.getAuthor());
    }


    public void deleteById(long id) {
        // update 메서드로 쿼리를 실행
        springJdbcTemplate.update(DELETE_QUERY,id);
    }

    // SELECT_QUERY 를 실행 하여 결과를 돌려 받아야 함 - update() 는 사용 불가 -> query() 사용
    public Course findById(long id) {
        // queryForObject() : 특정 객체를 생성 한다.

        // ResultSet 를 -> Bean 으로 맵핑 => Row Mappers(결과 세트의 각 행을 특정 Bean 에 연결)
        // id

        // BeanPropertyRowMapper 를 사용 해서 결과를 Course 클래스로 맵핑 -> return
        return springJdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class),id);

    }
}
