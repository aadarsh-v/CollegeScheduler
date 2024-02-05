package com.example.collegescheduler.ui.exams;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegescheduler.R;

import org.w3c.dom.Text;

public class ExamHolder extends RecyclerView.ViewHolder {
    CheckBox box;
    TextView date;
    TextView name, course;

    public ExamHolder(@NonNull View itemView) {
        super(itemView);
        box = itemView.findViewById(R.id.checkBox);
        date = itemView.findViewById(R.id.examDate);
        course = itemView.findViewById(R.id.courseName);
        name = itemView.findViewById(R.id.examName);
    }

    public CheckBox getCheckBox() { return box; }
    public TextView getDate() { return date; }
    public TextView getName() { return name; }
    public TextView getCourse() { return course; }

}
