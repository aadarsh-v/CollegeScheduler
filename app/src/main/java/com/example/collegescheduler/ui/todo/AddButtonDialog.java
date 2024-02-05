package com.example.collegescheduler.ui.todo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.collegescheduler.R;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddButtonDialog extends AppCompatDialogFragment {
    private EditText task;
    private Calendar date;


    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.addbutton_onclick_menu, null);
        task = view.findViewById(R.id.taskInputDialog);
        EditText year = view.findViewById(R.id.yearInput);
        EditText month = view.findViewById(R.id.monthInput);
        EditText day = view.findViewById(R.id.dayInput);
        date = new GregorianCalendar();

        builder.setView(view).setTitle("Add Task").setNegativeButton("Back",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TodoFragment.items.add(new Todo(task.getText().toString(),
                        Integer.parseInt(year.getText().toString()),
                        Integer.parseInt(month.getText().toString()),
                        Integer.parseInt(day.getText().toString())

                ));

            }
        });
        return builder.create();


    }
}
