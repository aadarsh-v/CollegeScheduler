package com.example.collegescheduler.ui.assignments;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegescheduler.R;

import org.w3c.dom.Text;

public class AssignmentHolder extends RecyclerView.ViewHolder {
    CheckBox box;
    TextView name, course, date;

    public AssignmentHolder(@NonNull View itemView) {
        super(itemView);
        box = itemView.findViewById(R.id.checkBox);
        name = itemView.findViewById(R.id.assignmentName);
        course = itemView.findViewById(R.id.courseName);
        date = itemView.findViewById(R.id.dueDate);
    }

    public CheckBox getCheckBox() { return box; }
    public TextView getName() { return name; }
    public TextView getCourse() { return course; }
    public TextView getDate() { return date; }

    public void setName(TextView name) { this.name = name; }
    public void setBox(CheckBox box) { this.box = box; }
    public void setCourse(TextView course) { this.course = course; }
    public void setDate(TextView date) { this.date = date; }
}
