package com.in28minutes.springboot.learnjpaandhibernate.course.jpa;


import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

// JPA 를 활용 //
@Repository
@Transactional  // JPA 로 쿼리를 실행하려고 할 때마다 트랜잭션을 허용하기 위해 필요한 어노테이션
public class CourseJpaRepository {
    // EntityManager : 엔터티를 관리해줌

    // @PersistenceContext :
    // JPA 스펙에서 제공하는 기능인데, 영속성 컨텍스트를 주입하는 표준 애노테이션
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course);
    }
    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }
    public void deleteById(long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}
