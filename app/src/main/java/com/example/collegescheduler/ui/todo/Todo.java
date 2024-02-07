package com.example.collegescheduler.ui.todo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import com.example.collegescheduler.ui.items.Item;
public class Todo extends Item {

    String task;
    private int year, month, day;
    public Todo(String task, int year, int month, int day) {
        super.dueDate = new GregorianCalendar();
        super.dueDate.set(Calendar.YEAR, year);
        super.dueDate.set(Calendar.MONTH, month - 1);
        super.dueDate.set(Calendar.DAY_OF_MONTH, day);
        this.task = task;

        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Calendar getDueDate() {
        return super.dueDate;
    }

    public String getReadableDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM, YYYY");
        String dateTime = dateFormat.format(super.dueDate.getTime()).toString();
        System.out.println(dateTime);
        return dateTime;
    }

    public String getDetailedDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, YYYY", Locale.US);
        String dateTime = dateFormat.format(super.dueDate.getTime()).toString();
        return "Date: " + dateTime;
    }

    public void setDueDate(Calendar dueDate) {
        super.dueDate = dueDate;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setComplete(Boolean complete) { super.complete = complete; }
    public Boolean isComplete() { return super.complete; }

    public String getYear() { return String.valueOf(this.year); }
    public String getMonth() { return String.valueOf(this.month); }
    public String getDay() { return String.valueOf(this.day); }
}
