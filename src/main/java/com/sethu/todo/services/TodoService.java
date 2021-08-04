package com.sethu.todo.services;

import com.sethu.todo.model.Todo;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface TodoService {
    List<Todo> getTodos();

    Todo getTodoById(Long id);

    Todo insert(Todo todo);

    void updateTodo(Long id, Todo todo);

    void deleteTodo(Long todoId);
}
