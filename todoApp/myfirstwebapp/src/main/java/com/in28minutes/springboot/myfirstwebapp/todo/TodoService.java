package com.in28minutes.springboot.myfirstwebapp.todo;

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
        return todos;
    }

    public void addTodo(String username, String description,
                        LocalDate targetDate,boolean done) {

        Todo todo = new Todo(++todosCount,username,description,targetDate,done);
        todos.add(todo);
    }

    public void deleteById(int id) {
        Predicate<? super Todo> predicate
                = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }
}
