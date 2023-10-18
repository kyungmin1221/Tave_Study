package com.in28minutes.rest.webservices.restfulwebservices.user;

import com.in28minutes.rest.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {

    private UserDaoService service;
    private UserRepository repository;


    public UserJpaResource(UserDaoService service,UserRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    // 여려명 유저의 정보를 반한해주는 메소드
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return repository.findAll();
    }

    // 단 한명만의 유저 정보를 반환해주는 메소드
    // EntitiyModel //
    // WebMvcLickBuilder //
    // HATEOAS 를 사용하여 링크를 추가 ->EntityModel 사용하여 사용자를 래핑 / EntityModel<User> 이 응답유형
    // 소비자가 이 응답을 받으면 모든 사용자의 세부사항을 받을 수 있게 해줌 , 링크도 추가
    @GetMapping ("/jpa/users/{id}")
    public EntityModel<User> retrieveUsers(@PathVariable int id) {
        Optional<User> user = repository.findById(id);

        if(user.isEmpty()) {    // isEmpty() 를 써서 특정 id에 해당하는 사용자가 없는지 확인
            throw new UserNotFoundException("id : " + id);
        }

        EntityModel<User> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }


    // 작업이 성공적으로 완료되면 200 반환
    @DeleteMapping ("/jpa/users/{id}")
    public void deleteUsers(@PathVariable int id) {

        repository.deleteById(id);
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUsers(@Valid @RequestBody User user) {
       // @Valid : 바인딩이 수행될 때 객체에 정의된 "유효성 검증"이 "자동" 으로 수행
        User savedUser = repository.save(user);

        URI location =
                        ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedUser.getId())
                        .toUri();
        // 201(post 생성) 반환하기 - 사용자가 생성되면 201 요청을 반환한다
        return ResponseEntity.created(location).build();
    }


}
