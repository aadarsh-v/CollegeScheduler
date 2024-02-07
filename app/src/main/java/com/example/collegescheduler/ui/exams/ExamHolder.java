package com.example.collegescheduler.ui.exams;

import static com.example.collegescheduler.ui.todo.TodoFragment.items;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegescheduler.R;
import com.example.collegescheduler.ui.todo.Todo;

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
        box.setOnClickListener(v -> {
            Exam item = (Exam) items.get(getBindingAdapterPosition());
            item.complete = !item.complete;
        });
    }
    public CheckBox getCheckBox() { return box; }
    public TextView getDate() { return date; }
    public TextView getName() { return name; }
    public TextView getCourse() { return course; }
}
