package com.sethu.todo.services;

import com.sethu.todo.model.Todo;
import com.sethu.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepository todoRepository;

    @Override
    public List<Todo> getTodos() {
        List<Todo> todos = new ArrayList<>();

        todoRepository.findAll().forEach(todos::add);
        return todos;
    }

    @Override
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).get();
    }

    @Override
    public Todo insert(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void updateTodo(Long id, Todo todo) {
        Todo toBeUpdated = todoRepository.findById(id).get();
        System.out.println(toBeUpdated.toString());
        toBeUpdated.setTodoStatus(todo.getTodoStatus());
        toBeUpdated.setDescription(todo.getDescription());
        toBeUpdated.setTitle(todo.getTitle());
        todoRepository.save(toBeUpdated);
    }

    @Override
    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }
}
