package com.example.collegescheduler.ui;

import java.util.ArrayList;

public class Item {
    String course;
    String dueDate;
    String task;
    private int type;
    private static int itemId;
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

    public int getType() { return this.type; }

//    public static ArrayList<Item> createItemList(int numItems) {
//        ArrayList<Item> items = new ArrayList<Item>();
//        for (int i = 1; i < numItems; i++) {
//            items.add(new Item("Item" + ++itemId, i <= ))
//        }
//    }
}
