package com.example.collegescheduler.ui.assignments;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Assignment {
    private String name;
    private String course;
    private Calendar dueDate;
    private boolean complete;

    public Assignment(String name, String course, int year, int month, int day) {
        this.name = name;
        this.course = course;
        this.dueDate = new GregorianCalendar();
        this.dueDate.set(Calendar.YEAR, year);
        this.dueDate.set(Calendar.MONTH, month);
        this.dueDate.set(Calendar.DAY_OF_MONTH, day);
    }

    public String getName() { return name; }
    public String getCourse() { return course; }
    public Calendar getDate() { return dueDate; }
    public String getReadableDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM, YYYY");
        String dateTime = dateFormat.format(this.dueDate.getTime()).toString();
        System.out.println(dateTime);
        return dateTime;
    }
    public boolean isComplete() { return complete; }
    public void setName(String name) {
        this.name = name;
    }
    public void setCourse(String course) { this.course = course; }
    public void setDate(Calendar date) { this.dueDate = date; }
    public void setComplete(boolean complete) { this.complete = complete; }
}
