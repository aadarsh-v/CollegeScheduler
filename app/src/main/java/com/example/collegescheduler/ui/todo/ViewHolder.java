package com.example.collegescheduler.ui.todo;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegescheduler.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    CheckBox box;
    TextView course;
    TextView date;
    TextView task;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        box = itemView.findViewById(R.id.todoCheckBox);
        course = itemView.findViewById(R.id.course);
        date = itemView.findViewById(R.id.date);
        task = itemView.findViewById(R.id.task);
    }
}
