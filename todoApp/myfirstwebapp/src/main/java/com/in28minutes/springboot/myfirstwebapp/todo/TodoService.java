package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;
    static {
        todos.add(new Todo(++todosCount,"kyungmin","Learn Spring",
        LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todosCount,"kyungmin","Learn Fullstack",
                LocalDate.now().plusYears(2),false));
        todos.add(new Todo(++todosCount,"kyungmin","Learn Soccer",
                LocalDate.now().plusYears(4),false));
    }

    public List<Todo> findByUsername(String username) {
        // 매칭 조건 설정(username이 일치하면 매칭)
        Predicate<? super Todo> predicate
                = todo -> todo.getUsername().equalsIgnoreCase(username);
        // 매칭이 된다면 그 매칭된 값을 스트림으로 변환
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description,
                        LocalDate targetDate,boolean done) {

        Todo todo = new Todo(++todosCount,username,description,targetDate,done);
        todos.add(todo);
    }

    public void deleteById(int id) {
        // 매칭 조건 설정(id가 일치하면 매칭)
        Predicate<? super Todo> predicate
                = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate
                = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();

        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);

    }
}
