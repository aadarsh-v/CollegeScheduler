package com.example.collegescheduler.ui.courses;

import java.time.LocalDateTime;

public class Course {
    private String name;
    private int time;
    private String repeatDays;
    private String professor;
    private String section;
    private String location;
    private String room;

    public Course(String name, int time, String repeatDays, String professor, String section, String location, String room) {
        this.name = name;
        this.time = time;
        this.repeatDays = repeatDays;
        this.professor = professor;
        this.section = section;
        this.location = location;
        this.room = room;
    }

    public String getName() { return this.name; }
    public int getTime() { return this.time; }
    public String getRepeatDays() { return this.repeatDays; }
    public String getProfessor() { return this.professor; }
    public String getSection() { return this.section; }
    public String getLocation() { return this.location; }
    public String getRoom() { return this.room; }

    public void setName(String name) { this.name = name; }
    public void setTime(int time) { this.time = time; }
    public void setRepeatDays(String repeatDays) { this.repeatDays = repeatDays; }
    public void setProfessor(String professor) { this.professor = professor; }
    public void setSection(String section) { this.section = section; }
    public void setLocation(String location) { this.location = location; }
    public void setRoom(String room) { this.room = room; }
}
