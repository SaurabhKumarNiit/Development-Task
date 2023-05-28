package com.todoApi.todoTask.controller;

import com.todoApi.todoTask.domain.Todo;
import com.todoApi.todoTask.exception.TodoTaskNotFoundException;
import com.todoApi.todoTask.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/todo")
public class TodoController
{
    ResponseEntity responseEntity ;

    @Autowired
    private TodoServiceImpl todoService;

    //  http://localhost:8084/todo/addTodo
    @PostMapping("/addTodo")
    public ResponseEntity<?> addTodo(@RequestBody Todo todo){
        Todo todoAdded = todoService.addTask(todo);

        return new ResponseEntity<>(todoAdded, HttpStatus.CREATED);
    }

    //  http://localhost:8084/todo/getAllTodoTask
    @GetMapping("/getAllTodoTask")
    public ResponseEntity<?> getAllItem() throws TodoTaskNotFoundException {
        return new ResponseEntity<>(todoService.getAllTasks(),HttpStatus.OK);
    }


    // http://localhost:8084/todo/items/itemId
    @GetMapping("/singleTask/{todoId}")
    public ResponseEntity<?> getTodoTaskById(@PathVariable int todoId ) throws TodoTaskNotFoundException {
        Todo todo = todoService.getTaskById(todoId);
        responseEntity=new ResponseEntity<>(todo,HttpStatus.OK);
        return responseEntity;
    }

    //  http://localhost:8084/todo/updateTask/{todoId}
    @PutMapping("/updateTask/{todoId}")
    public ResponseEntity<?> updateItem(@RequestBody Todo todo,@PathVariable int todoId) {
        return new ResponseEntity<>(todoService.updateTask(todo,todoId),HttpStatus.CREATED);
    }

//    http://localhost:8084/todo/deleteTask/{itemId}
    @DeleteMapping("/deleteTask/{todoId}")
    public ResponseEntity<?> deleteItem(@PathVariable("todoId") int todoId) throws TodoTaskNotFoundException {
        try {
            todoService.deleteTask(todoId);
            responseEntity = new ResponseEntity<>("Successfully Deleted 1 Record",HttpStatus.OK);
        } catch (TodoTaskNotFoundException e) {
            throw new TodoTaskNotFoundException();
        }
        return responseEntity;
    }

}
