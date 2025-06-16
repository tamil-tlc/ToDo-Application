package com.example.todo_application;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String title;
    private List<String> todoItems;

    public Project(String title) {
        this.title = title;
        this.todoItems = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getTodoItems() {
        return todoItems;
    }

    public void addTodoItem(String item) {
        this.todoItems.add(item);
    }
}