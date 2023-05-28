package com.todoApi.todoTask.domain;

import javax.persistence.*;

@Entity
@Table(name = "todolist")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int todoId;
    String title;
    String description;


    public Todo(int todoId, String title, String description) {
        this.todoId = todoId;
        this.title = title;
        this.description = description;
    }

    public Todo() {
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + todoId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
