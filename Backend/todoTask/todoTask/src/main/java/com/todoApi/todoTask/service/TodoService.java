package com.todoApi.todoTask.service;

import com.todoApi.todoTask.domain.Todo;
import com.todoApi.todoTask.exception.TodoTaskNotFoundException;

import java.util.List;

public interface TodoService {

    public Todo addTask(Todo todo);
    List<Todo> getAllTasks() throws TodoTaskNotFoundException;

    public Todo getTaskById(int id) throws TodoTaskNotFoundException;

    Todo updateTask(Todo todo,int id);
    boolean deleteTask(int itemId) throws TodoTaskNotFoundException;
}
