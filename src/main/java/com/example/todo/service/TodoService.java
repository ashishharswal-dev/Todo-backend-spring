package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService{

    @Autowired
    private TodoRepository repository;

    public List<Todo> getAllTodos(){
        return repository.findAll();
    }

    public Todo getTodoById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Todo createOrUpdateTodo(Todo todo){
        return repository.save(todo);
    }

    public void deleteTodoById(Long id){
        repository.deleteById(id);
    }
}
