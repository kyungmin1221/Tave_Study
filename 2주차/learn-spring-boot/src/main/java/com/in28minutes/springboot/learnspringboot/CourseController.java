package com.in28minutes.springboot.learnspringboot;

// http://localhost:8080/courses/
//[
//        {
//        "id" : 1,
//        "name" : "Learn AWS",
//        "author" : "in28minutes"
//        }
//]

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1,"Learn AWS","in28minutes"),
                new Course(2,"Learn DepOps","in28minutes")

        );
    }
}
