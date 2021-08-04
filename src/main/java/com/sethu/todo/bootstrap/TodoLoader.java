package com.sethu.todo.bootstrap;


import com.sethu.todo.model.Todo;
import com.sethu.todo.model.TodoStatus;
import com.sethu.todo.repositories.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class TodoLoader implements CommandLineRunner {

    private final TodoRepository todoRepository;

    public TodoLoader(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        loadTodos();
    }

    private void loadTodos() {
        if (todoRepository.count() == 0) {
           Todo todo1 = new Todo();
           todo1.setTitle("Go to market");
           todo1.setDescription("Buy eggs from market");
           todo1.setTodoStatus(TodoStatus.NOT_COMPLETED);
           todoRepository.save(todo1);

            Todo todo2 = new Todo();
            todo2.setTitle("Go to school");
            todo2.setDescription("Complete assignments");
            todo2.setTodoStatus(TodoStatus.NOT_COMPLETED);
            todoRepository.save(todo2);
        }
    }
}
