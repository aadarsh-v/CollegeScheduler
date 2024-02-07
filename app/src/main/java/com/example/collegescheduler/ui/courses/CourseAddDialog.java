package com.example.collegescheduler.ui.courses;

import static com.example.collegescheduler.ui.courses.CoursesFragment.items;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.Fragment;

import com.example.collegescheduler.R;
import com.example.collegescheduler.ui.MinMaxFilter;
import com.example.collegescheduler.ui.todo.Todo;
import com.example.collegescheduler.ui.todo.TodoAddDialog;
import com.example.collegescheduler.ui.todo.TodoFragment;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CourseAddDialog extends AppCompatDialogFragment {
    private Fragment targetFragment;

    public interface ButtonDialogListener {
        public void onFinishEditDialog(String inputText);
    }

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.courses_add, null);
        EditText name = view.findViewById(R.id.nameInputDialog);
        EditText section = view.findViewById(R.id.sectionInputDialog);
        EditText professor = view.findViewById(R.id.professorInputDialog);
        EditText location = view.findViewById(R.id.locationInputDialog);
        EditText room = view.findViewById(R.id.roomNumberInputDialog);

        CheckBox m = view.findViewById(R.id.monday);
        CheckBox t = view.findViewById(R.id.tuesday);
        CheckBox w = view.findViewById(R.id.wednesday);
        CheckBox r = view.findViewById(R.id.thursday);
        CheckBox f = view.findViewById(R.id.friday);

        EditText startHour = view.findViewById(R.id.startHourInput);
        startHour.setFilters(new InputFilter[]{ new MinMaxFilter(1, 24)});
        EditText startMin = view.findViewById(R.id.startMinuteInput);
        startMin.setFilters(new InputFilter[]{ new MinMaxFilter(0, 60)});

        EditText endHour = view.findViewById(R.id.endHourInput);
        startHour.setFilters(new InputFilter[]{ new MinMaxFilter(1, 24)});
        EditText endMin = view.findViewById(R.id.endMinuteInput);
        endMin.setFilters(new InputFilter[]{ new MinMaxFilter(0, 60)});

        builder.setView(view).setTitle("Add Course").setNegativeButton("Back",
                (dialog, which) -> {

                }).setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                items.add(new Course(name.getText().toString(),
                        section.getText().toString(),
                        professor.getText().toString(),
                        location.getText().toString(),
                        room.getText().toString(),
                        m.isChecked(),
                        t.isChecked(),
                        w.isChecked(),
                        r.isChecked(),
                        f.isChecked(),
                        Integer.parseInt(startHour.getText().toString()),
                        Integer.parseInt(startMin.getText().toString()),
                        Integer.parseInt(endHour.getText().toString()),
                        Integer.parseInt(endMin.getText().toString())
                ));

                CourseAddDialog.ButtonDialogListener listener = (CourseAddDialog.ButtonDialogListener) targetFragment;
                listener.onFinishEditDialog("test");
            }
        });
        return builder.create();
    }

    public void setTargetFragment(Fragment targetFragment) {
        this.targetFragment = targetFragment;
    }


}
