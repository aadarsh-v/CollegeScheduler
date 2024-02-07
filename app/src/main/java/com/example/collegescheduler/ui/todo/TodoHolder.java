package com.example.collegescheduler.ui.todo;

import static com.example.collegescheduler.ui.todo.TodoFragment.items;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegescheduler.R;

public class TodoHolder extends RecyclerView.ViewHolder {
    CheckBox box;
    TextView date;
    TextView task;

    public TodoHolder(@NonNull View itemView) {
        super(itemView);
        box = itemView.findViewById(R.id.checkBox);
        date = itemView.findViewById(R.id.dueDate);
        task = itemView.findViewById(R.id.todoName);

        box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Todo item = (Todo) items.get(getBindingAdapterPosition());
                item.complete = !item.complete;
            }
        });
    }

    public CheckBox getCheckBox() { return box; }
    public TextView getDate() { return date; }
    public TextView getTask() { return task; }

}
