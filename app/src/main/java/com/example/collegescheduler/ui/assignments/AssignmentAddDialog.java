package com.example.collegescheduler.ui.assignments;

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
import com.example.collegescheduler.ui.todo.TodoFragment;

public class AssignmentAddDialog extends AppCompatDialogFragment {
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
        View view = inflater.inflate(R.layout.assignment_add, null);
        EditText name = view.findViewById(R.id.nameInputDialog);
        EditText course = view.findViewById(R.id.courseInputDialog);
        EditText year = view.findViewById(R.id.yearInput);
        year.setFilters(new InputFilter[]{ new MinMaxFilter(0, 9999)});
        EditText month = view.findViewById(R.id.monthInput);
        month.setFilters(new InputFilter[]{ new MinMaxFilter(1, 12)});
        EditText day = view.findViewById(R.id.dayInput);
        day.setFilters(new InputFilter[]{ new MinMaxFilter(1, 31)});

        builder.setView(view).setTitle("Add Assignment").setNegativeButton("Back",
                (dialog, which) -> {

                }).setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TodoFragment.items.add(new Assignment(name.getText().toString(),
                        course.getText().toString(),
                        Integer.parseInt(year.getText().toString()),
                        Integer.parseInt(month.getText().toString()),
                        Integer.parseInt(day.getText().toString())
                ));
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
