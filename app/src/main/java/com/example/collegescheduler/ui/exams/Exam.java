package com.example.collegescheduler.ui.exams;

import com.example.collegescheduler.ui.Item;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Exam extends Item {
    private String name;
    private String course;
    private Calendar calendar;
    private SimpleDateFormat examFormat;
    private String location;
    private boolean complete;

    private int day, month, year, hours, min;

    public Exam(String name, String course, String location, int year, int month, int day_of_month, int hours, int minutes) {
        this.name = name;
        this.course = course;
        this.location = location;
        super.dueDate = new GregorianCalendar();
        super.dueDate.set(Calendar.YEAR, year);
        super.dueDate.set(Calendar.MONTH, month - 1);
        super.dueDate.set(Calendar.DAY_OF_MONTH, day_of_month);
        super.dueDate.set(Calendar.HOUR_OF_DAY, hours);
        super.dueDate.set(Calendar.MINUTE, minutes);

        this.day = day_of_month;
        this.month = month;
        this.year = year;
        this.hours = hours;
        this.min = minutes;
    }

    public String getName() { return this.name; }
    public String getCourse() { return this.course; }
    // public Calendar getCalendar() { return super.dueDate; }
    public String getReadableDate() {
        examFormat = new SimpleDateFormat("dd/MM, yyyy");
        String dateTime = examFormat.format(super.dueDate.getTime()).toString();
        return dateTime;
    }
    public String getReadableTime() {
        examFormat = new SimpleDateFormat("hh:mm a");
        String dateTime = examFormat.format(super.dueDate.getTime()).toString();
        return dateTime;
    }

    public String getDetailedDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, YYYY", Locale.US);
        String dateTime = dateFormat.format(super.dueDate.getTime()).toString();
        return "Date: " + dateTime;
    }
    public String getDetailedTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a", Locale.US);
        String dateTime = dateFormat.format(super.dueDate.getTime()).toString();
        return "Time: " + dateTime;
    }

    public String getLocation() { return this.location; }

    public void setName(String name) { this.name = name; }
    public void setCourse(String course) { this.course = course; }
    public void setLocation(String location) {this.location = location; }
    public void setCalendar(Calendar calendar) { super.dueDate = calendar; }
    public boolean isComplete() { return this.complete; }
    public void setComplete(Boolean complete) { this.complete = complete; }

    public String getYear() {
        return String.valueOf(year);
    }
    public String getMonth() {
        return String.valueOf(month);
    }
    public String getDay() {
        return String.valueOf(day);
    }
    public String getHours() {
        return String.valueOf(hours);
    }
    public String getMin() {
        return String.valueOf(min);
    }
}
