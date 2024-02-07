package com.example.collegescheduler.ui.courses;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Course {
    private String name;
    private Calendar time;
    private String professor;
    private String section;
    private String location;
    private String room;
    private boolean m, t, w, r, f;

    private int hour, min;

    public Course(String name, String section, String professor, String location, String room, boolean m, boolean t, boolean w, boolean r, boolean f, int hour, int min) {
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

        this.time = new GregorianCalendar();
        this.time.set(Calendar.HOUR_OF_DAY, hour);
        this.time.set(Calendar.MINUTE, min);

        this.hour = hour;
        this.min = min;
    }

    public String getName() { return this.name; }
    public String getProfessor() { return this.professor; }
    public String getSection() { return this.section; }
    public String getLocation() { return this.location; }
    public String getRoom() { return this.room; }

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
        String dateTime = df.format(this.time.getTime()).toString();

        String days = "";
        if (m) { days = days + "M"; }
        if (t) { days = days + "T"; }
        if (w) { days = days + "W"; }
        if (r) { days = days + "R"; }
        if (f) { days = days + "F"; }

        dateTime = days + " " + dateTime;
        return dateTime;
    }

    public String getDetailedTime() {
        SimpleDateFormat df = new SimpleDateFormat("hh:mm a");
        String dateTime = df.format(this.time.getTime()).toString();

        return "Time: " + dateTime;
    }

    public String getHour() {
        return String.valueOf(hour);
    }

    public String getMinute() {
        return String.valueOf(min);
    }
}
