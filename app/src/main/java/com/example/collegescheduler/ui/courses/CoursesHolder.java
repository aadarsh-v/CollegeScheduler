package com.example.collegescheduler.ui.courses;

import static com.example.collegescheduler.ui.courses.CoursesFragment.items;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegescheduler.R;
import com.example.collegescheduler.ui.todo.Todo;

public class CoursesHolder extends RecyclerView.ViewHolder {
    TextView name, time, location;

    public CoursesHolder(@NonNull View itemView) {
        super(itemView);

        time = itemView.findViewById(R.id.courseTime);
        name = itemView.findViewById(R.id.courseName);
        location = itemView.findViewById(R.id.location);

    }
    public TextView getTime() { return time; }
    public TextView getLocation() { return location; }
    public TextView getName() { return name; }
}

