package com.todoApi.todoTask.repository;

import com.todoApi.todoTask.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer> {

    Todo findByTodoId(int id);
}
