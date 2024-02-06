package com.example.collegescheduler.ui.assignments;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Assignment {
    private String name;
    private String course;
    private Calendar dueDate;
    private boolean complete;

    private int year, month, day;

    public Assignment(String name, String course, int year, int month, int day) {
        this.name = name;
        this.course = course;
        this.dueDate = new GregorianCalendar();
        this.dueDate.set(Calendar.YEAR, year);
        this.dueDate.set(Calendar.MONTH, month - 1);
        this.dueDate.set(Calendar.DAY_OF_MONTH, day);

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getName() { return name; }
    public String getCourse() { return course; }
    public Calendar getDate() { return dueDate; }
    public String getReadableDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM, YYYY");
        String dateTime = dateFormat.format(this.dueDate.getTime()).toString();
        return dateTime;
    }

    public String getDetailedDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, YYYY", Locale.US);
        String dateTime = dateFormat.format(this.dueDate.getTime()).toString();
        return "Date: " + dateTime;
    }

    public boolean isComplete() { return complete; }
    public void setName(String name) {
        this.name = name;
    }
    public void setCourse(String course) { this.course = course; }
    public void setDate(Calendar date) { this.dueDate = date; }
    public void setComplete(boolean complete) { this.complete = complete; }

    public String getDay() { return String.valueOf(this.day); }
    public String getMonth() { return String.valueOf(this.month); }
    public String getYear() { return String.valueOf(this.year); }
}
