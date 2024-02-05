package com.example.collegescheduler.ui.exams;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Exam {
    private String name;
    private String course;
    private Calendar calendar;
    private SimpleDateFormat examFormat;
    private String location;
    private boolean complete;

    public Exam(String name, String course, String location, int year, int month, int day_of_month, int hours, int minutes) {
        this.name = name;
        this.course = course;
        this.location = location;
        this.calendar = new GregorianCalendar();
        this.calendar.set(Calendar.YEAR, year);
        this.calendar.set(Calendar.MONTH, month);
        this.calendar.set(Calendar.DAY_OF_MONTH, day_of_month);
        this.calendar.set(Calendar.HOUR, hours);
        this.calendar.set(Calendar.MINUTE, minutes);
    }

    public String getName() { return this.name; }
    public String getCourse() { return this.course; }
    // public Calendar getCalendar() { return this.calendar; }
    public String getReadableDate() {
        examFormat = new SimpleDateFormat("dd/MM, YYYY");
        String dateTime = examFormat.format(this.calendar.getTime()).toString();
        return dateTime;
    }
    public String getReadableTime() {
        examFormat = new SimpleDateFormat("HH:mm");
        String dateTime = examFormat.format(this.calendar.getTime()).toString();
        return dateTime;
    }

    public String getLocation() { return this.location; }

    public void setName(String name) { this.name = name; }
    public void setCourse(String course) { this.course = course; }
    public void setLocation(String location) {this.location = location; }
    public void setCalendar(Calendar calendar) { this.calendar = calendar; }
    public boolean isComplete() { return this.complete; }
    public void setComplete(Boolean complete) { this.complete = complete; }


}
