package com.example.collegescheduler.ui.todo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;

import com.example.collegescheduler.R;
import com.example.collegescheduler.ui.MinMaxFilter;

public class TodoAddDialog extends AppCompatDialogFragment {
    private EditText task;
    private Fragment targetFragment;

    // 1. Defines the listener interface with a method passing back data result.
    public interface ButtonDialogListener {
        public void onFinishEditDialog(String inputText);
    }

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.todo_add, null);
        task = view.findViewById(R.id.taskInputDialog);
        EditText year = view.findViewById(R.id.yearInput);
        year.setFilters(new InputFilter[]{ new MinMaxFilter(0, 9999)});
        EditText month = view.findViewById(R.id.monthInput);
        month.setFilters(new InputFilter[]{ new MinMaxFilter(1, 12)});
        EditText day = view.findViewById(R.id.dayInput);
        day.setFilters(new InputFilter[]{ new MinMaxFilter(1, 31)});

        builder.setView(view).setTitle("Add Task").setNegativeButton("Back",
                (dialog, which) -> {

                }).setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Todo newTodo = new Todo(task.getText().toString(),
                        Integer.parseInt(year.getText().toString()),
                        Integer.parseInt(month.getText().toString()),
                        Integer.parseInt(day.getText().toString())
                );
                TodoFragment.items.add(newTodo);
//                if (TodoFragment.items != TodoFragment.allItems) {
//                    TodoFragment.allItems.add(newTodo);
//                }


                ButtonDialogListener listener = (ButtonDialogListener) targetFragment;
                listener.onFinishEditDialog("test");
            }
        });
        return builder.create();
    }

    public void setTargetFragment(Fragment targetFragment) {
        this.targetFragment = targetFragment;
    }
}
