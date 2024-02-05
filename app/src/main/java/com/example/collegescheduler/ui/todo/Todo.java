package com.example.collegescheduler.ui.todo;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Todo {
    Calendar dueDate;
    String task;
    private boolean complete;
    public Todo(String task, int year, int month, int day) {
        this.dueDate = new GregorianCalendar();
        this.dueDate.set(Calendar.YEAR, year);
        this.dueDate.set(Calendar.MONTH, month);
        this.dueDate.set(Calendar.DAY_OF_MONTH, day);
        this.task = task;
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public String getReadableDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM, YYYY");
        String dateTime = dateFormat.format(this.dueDate.getTime()).toString();
        System.out.println(dateTime);
        return dateTime;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setComplete(Boolean complete) { this.complete = complete; }
    public Boolean isComplete() { return complete; }
}
