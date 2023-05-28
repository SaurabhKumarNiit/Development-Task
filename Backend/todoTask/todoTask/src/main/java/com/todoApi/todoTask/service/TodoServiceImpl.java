package com.todoApi.todoTask.service;

import com.todoApi.todoTask.domain.Todo;
import com.todoApi.todoTask.exception.TodoTaskNotFoundException;
import com.todoApi.todoTask.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo addTask(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> getAllTasks() throws TodoTaskNotFoundException {
        return todoRepository.findAll();
    }

    @Override
    public Todo getTaskById(int id) throws TodoTaskNotFoundException {
        return todoRepository.findByTodoId(id);
    }

    @Override
    public Todo updateTask(Todo todo, int id) {

        Optional<Todo> optionalItem = (todoRepository.findById(id));

        if(optionalItem.isEmpty()){
            return null;
        }
        Todo existingItem = optionalItem.get();
        if (todo.getTitle()!=null){
            existingItem.setTitle(todo.getTitle());
        }
        if (todo.getDescription()!=null){
            existingItem.setDescription(todo.getDescription());
        }

        return todoRepository.save(existingItem);
    }

    @Override
    public boolean deleteTask(int id) throws TodoTaskNotFoundException {
        boolean result = false;
        if (todoRepository.findById(id).isEmpty()){
            throw new TodoTaskNotFoundException();
        }else{
            todoRepository.deleteById(id);
            result = true;
        }
        return result;
    }

}
