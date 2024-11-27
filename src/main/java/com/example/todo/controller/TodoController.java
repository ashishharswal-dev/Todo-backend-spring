package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
//@CrossOrigin(origins = "http://localhost:5173") // Allow requests from the React app
@CrossOrigin(origins = "https://todo-list-silk-beta.vercel.app/") // Allow requests from the React app

public class TodoController{
    @Autowired
    private TodoService service;

    //get all todos
    @GetMapping
    public List<Todo> getAllTodos(){
        return service.getAllTodos();
    }

    //by id
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id){
        return service.getTodoById(id);
    }

    //create or update
    @PostMapping
    public Todo createOrUpdateTodo(@RequestBody Todo todo){
        return service.createOrUpdateTodo(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable Long id){
        service.deleteTodoById(id);
    }
}