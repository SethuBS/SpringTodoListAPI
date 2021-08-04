package com.sethu.todo.repositories;

import com.sethu.todo.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoRepository extends CrudRepository<Todo,Long> {
}
