package com.example.collegescheduler.ui.courses;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Course {
    private String name;
    private Calendar start_time, end_time;
    private String professor;
    private String section;
    private String location;
    private String room;
    private boolean m, t, w, r, f;

    private int start_hour, start_min;
    private int end_hour, end_min;

    public Course(String name, String section, String professor, String location, String room, boolean m, boolean t, boolean w, boolean r, boolean f, int start_hour, int start_min, int end_hour, int end_min) {
        this.name = name;
        this.section = section;
        this.professor = professor;
        this.location = location;
        this.room = room;

        this.m = m;
        this.t = t;
        this.w = w;
        this.r = r;
        this.f = f;

        this.start_time = new GregorianCalendar();
        this.start_time.set(Calendar.HOUR_OF_DAY, start_hour);
        this.start_time.set(Calendar.MINUTE, start_min);

        this.start_hour = start_hour;
        this.start_min = start_min;

        this.end_time = new GregorianCalendar();
        this.end_time.set(Calendar.HOUR_OF_DAY, end_hour);
        this.end_time.set(Calendar.MINUTE, end_min);

        this.end_hour = end_hour;
        this.end_min = end_min;
    }

    public String getName() { return this.name; }
    public String getProfessor() { return this.professor; }
    public String getSection() { return this.section; }
    public String getLocation() { return this.location; }
    public String getRoom() { return this.room; }

    public String getRoomLoc() {
        return getLocation() + " " + getRoom();
    }

    public void setName(String name) { this.name = name; }
    public void setProfessor(String professor) { this.professor = professor; }
    public void setSection(String section) { this.section = section; }
    public void setLocation(String location) { this.location = location; }
    public void setRoom(String room) { this.room = room; }

    public boolean isM() {
        return m;
    }
    public boolean isT() {
        return t;
    }
    public boolean isW() {
        return w;
    }
    public boolean isR() {
        return r;
    }
    public boolean isF() {
        return f;
    }

    public void setM(boolean m) {
        this.m = m;
    }
    public void setT(boolean t) {
        this.t = t;
    }
    public void setW(boolean w) {
        this.w = w;
    }
    public void setR(boolean r) {
        this.r = r;
    }
    public void setF(boolean f) {
        this.f = f;
    }

    public String getReadableTime() {
        SimpleDateFormat df = new SimpleDateFormat("hh:mm a");
        String dateTime = df.format(this.start_time.getTime()).toString();
        String endTime = df.format(this.end_time.getTime()).toString();

        String days = "";
        if (m) { days = days + "M"; }
        if (t) { days = days + "T"; }
        if (w) { days = days + "W"; }
        if (r) { days = days + "R"; }
        if (f) { days = days + "F"; }

        dateTime = days + " " + dateTime + " - " + endTime;
        return dateTime;
    }

    public String getDetailedTime() {
        SimpleDateFormat df = new SimpleDateFormat("hh:mm a");
        String dateTime = df.format(this.start_time.getTime()).toString();
        String endTime = df.format(this.end_time.getTime()).toString();

        return "Time: " + dateTime + " - " + endTime;
    }

    public String getStartHour() {
        return String.valueOf(start_hour);
    }

    public String getStartMinute() {
        return String.valueOf(start_min);
    }

    public String getEndHour() {
        return String.valueOf(end_hour);
    }

    public String getEndMin() {
        return String.valueOf(end_min);
    }
}
