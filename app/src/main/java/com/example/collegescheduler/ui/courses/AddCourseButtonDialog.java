package com.example.collegescheduler.ui.courses;

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
import com.example.collegescheduler.ui.todo.TodoAddDialog;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddCourseButtonDialog extends AppCompatDialogFragment {
    private EditText course;
    private Calendar date;
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_course_button_on_click_menu, null);
        course = view.findViewById(R.id.courseInputDialog);
        EditText time = view.findViewById(R.id.time);
        EditText repeatday = view.findViewById(R.id.repeatedDays);
        EditText professor = view.findViewById(R.id.Professor);
        EditText section = view.findViewById(R.id.Section);
        EditText location = view.findViewById(R.id.location);
        EditText room = view.findViewById(R.id.room_number);
        date = new GregorianCalendar();

        builder.setView(view).setTitle("Add Course").setNegativeButton("Back",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CoursesFragment.courses.add(new Course(course.getText().toString(), Integer.parseInt(time.getText().toString()), repeatday.getText().toString(),
                        professor.getText().toString(), section.getText().toString(), location.getText().toString(),
                        room.getText().toString())
                );

            }
        });
        return builder.create();


    }
}
