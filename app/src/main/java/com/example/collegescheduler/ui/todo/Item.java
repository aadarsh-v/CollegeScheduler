package com.example.collegescheduler.ui.todo;

public class Item {
    String course;
    String dueDate;
    String task;
    public Item(String course, String dueDate, String task) {
        this.course = course;
        this.dueDate = dueDate;
        this.task = task;
    }
    public Item(String dueDate, String task) {
        this.dueDate = dueDate;
        this.task = task;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
