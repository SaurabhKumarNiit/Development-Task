package com.todoApi.todoTask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Task Not Found Exits")
public class TodoTaskNotFoundException extends Exception{

}
