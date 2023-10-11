package com.in28minutes.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

//@Controller
@SessionAttributes("name")
public class TodoController {
    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    private TodoService todoService;

    @RequestMapping("list-todo")
    public String listAllTodos(ModelMap model) {
        String username = (String)model.get("name");
        List<Todo> todos = todoService.findByUsername(username);
        model.addAttribute("todos",todos);
        return "listTodos";
    }

    @RequestMapping(value = "add-todo",method= RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String username = (String)model.get("name");
        Todo todo = new Todo(0,username,"",
                LocalDate.now().plusYears(0),false);
        model.put("todo",todo);
        return "todo";
    }
    @RequestMapping(value = "add-todo",method= RequestMethod.POST)
    public String addNewTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {

        if(result.hasErrors()) {
            return "todo";
        }
        String username = (String)model.get("name");
        todoService.addTodo(username,todo.getDescription(),
                todo.getTargetDate(),false);
        return "redirect:list-todo";
    }
    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteById(id);
        return "redirect:list-todo";
    }


    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id,ModelMap model) {
        Todo todo = todoService.findById(id);
        model.addAttribute("todo",todo);
        return "todo";
    }

    @RequestMapping(value = "update-todo",method= RequestMethod.POST)
    public String updateTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {

        if(result.hasErrors()) {
            return "todo";
        }
        String username = (String)model.get("name");
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-todo";
    }

    private String getLoggedinUsername(ModelMap model) {

        // 현재 인증된 주체를 제공
        // 인증된 사용자가 있다면 밑의 메소드를 통해 받을 수 있음
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        return authentication.getName();
    }

}

















