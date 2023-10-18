package com.in28minutes.rest.webservices.restfulwebservices.jpa;

import com.in28minutes.rest.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

// UserResource 에서 UserRepository 를 통해 DB 와 소통 //
public interface UserRepository extends JpaRepository<User,Integer> {
}
