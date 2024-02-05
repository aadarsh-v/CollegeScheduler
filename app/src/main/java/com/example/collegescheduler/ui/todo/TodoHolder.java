package com.example.collegescheduler.ui.todo;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegescheduler.R;

import org.w3c.dom.Text;

public class TodoHolder extends RecyclerView.ViewHolder {
    CheckBox box;
    TextView date;
    TextView task;

    public TodoHolder(@NonNull View itemView) {
        super(itemView);
        box = itemView.findViewById(R.id.checkBox);
        date = itemView.findViewById(R.id.dueDate);
        task = itemView.findViewById(R.id.todoName);
    }

    public CheckBox getCheckBox() { return box; }
    public TextView getDate() { return date; }
    public TextView getTask() { return task; }

}
