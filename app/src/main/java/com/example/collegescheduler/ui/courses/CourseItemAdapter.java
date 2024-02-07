package com.example.collegescheduler.ui.courses;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.InputFilter;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegescheduler.R;
import com.example.collegescheduler.ui.MinMaxFilter;
import com.example.collegescheduler.ui.assignments.Assignment;
import com.example.collegescheduler.ui.assignments.AssignmentHolder;
import com.example.collegescheduler.ui.exams.Exam;
import com.example.collegescheduler.ui.exams.ExamHolder;
import com.example.collegescheduler.ui.items.Item;
import com.example.collegescheduler.ui.todo.Todo;
import com.example.collegescheduler.ui.todo.TodoFragment;
import com.example.collegescheduler.ui.todo.TodoHolder;

import java.util.List;

public class CourseItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    FragmentActivity activity;
    List<Course> items;
    public CourseItemAdapter(Context context, FragmentActivity activity, List<Course> items) {
        this.context = context;
        this.activity = activity;
        this.items = items;
    }
    private int currentListItemIndex;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View v = inflater.inflate(R.layout.courses_cell, parent, false);
        viewHolder = new CoursesHolder(v);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        CoursesHolder vh = (CoursesHolder) viewHolder;
        configureCourseHolder(vh, position);

        viewHolder.itemView.setOnLongClickListener(v -> {
            int pos = viewHolder.getBindingAdapterPosition();
            currentListItemIndex = pos;
            showItemMenu(v);
            v.setSelected(true);
            return true;
        });
    }

    private void configureCourseHolder(CoursesHolder vh, int position) {
        Course course = (Course) items.get(position);
        if (course != null) {
            vh.getName().setText(course.getName());
            vh.getTime().setText(course.getReadableTime());
            vh.getLocation().setText(course.getLocation());
        }
    }

    private void showItemMenu(View v) {
        PopupMenu popup = new PopupMenu(this.activity, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.item_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.view_details) {
                Course cell = items.get(currentListItemIndex);
                courseDetailsDialog();
                return true;
            } else if (item.getItemId() == R.id.edit_details) {
                Course cell = items.get(currentListItemIndex);
                courseEditButtonDialog();
                return true;
            } else if (item.getItemId() == R.id.remove) {
                confirmRemovalDialog();
                return true;
            } else {
                return false;
            }
        });
        popup.show();
    }

    private void confirmRemovalDialog() {
        AlertDialog.Builder confirm_removal = new AlertDialog.Builder(context);
        confirm_removal.setTitle("Confirm Removal");
        confirm_removal.setPositiveButton("Confirm", (dialog, item) -> {
            items.remove(currentListItemIndex);
            notifyDataSetChanged();
        });
        confirm_removal.setNegativeButton("Back", (dialog, item) -> { });

        confirm_removal.show();
    }

    private void courseEditButtonDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = activity.getLayoutInflater();

        Course item = items.get(currentListItemIndex);

        View view = inflater.inflate(R.layout.courses_add, null);
        EditText name = view.findViewById(R.id.nameInputDialog);
        name.setText(item.getName());
        EditText section = view.findViewById(R.id.sectionInputDialog);
        section.setText(item.getSection());
        EditText professor = view.findViewById(R.id.professorInputDialog);
        professor.setText(item.getProfessor());
        EditText location = view.findViewById(R.id.locationInputDialog);
        location.setText(item.getLocation());
        EditText room = view.findViewById(R.id.roomNumberInputDialog);
        room.setText(item.getRoom());

        CheckBox m = view.findViewById(R.id.monday);
        m.setChecked(item.isM());
        CheckBox t = view.findViewById(R.id.tuesday);
        t.setChecked(item.isT());
        CheckBox w = view.findViewById(R.id.wednesday);
        w.setChecked(item.isW());
        CheckBox r = view.findViewById(R.id.thursday);
        r.setChecked(item.isR());
        CheckBox f = view.findViewById(R.id.friday);
        f.setChecked(item.isF());

        EditText startHour = view.findViewById(R.id.startHourInput);
        startHour.setText(item.getStartHour());
        startHour.setFilters(new InputFilter[]{ new MinMaxFilter(1, 24)});
        EditText startMin = view.findViewById(R.id.startMinuteInput);
        startMin.setText(item.getStartMinute());
        startMin.setFilters(new InputFilter[]{ new MinMaxFilter(0, 60)});

        EditText endHour = view.findViewById(R.id.endHourInput);
        endHour.setText(item.getEndHour());
        startHour.setFilters(new InputFilter[]{ new MinMaxFilter(1, 24)});
        EditText endMin = view.findViewById(R.id.endMinuteInput);
        endMin.setText(item.getStartMinute());
        endMin.setFilters(new InputFilter[]{ new MinMaxFilter(0, 60)});

        builder.setView(view).setTitle("Edit Course").setNegativeButton("Back",
                (dialog, which) -> {

                }).setPositiveButton("Done", (dialog, which) -> confirmCourseEditDialogue(name, section, professor, location, room, m, t, w, r, f, startHour, startMin, endHour, endMin));

        builder.show();
    }

    private void confirmCourseEditDialogue(EditText name, EditText section, EditText professor, EditText location, EditText room, CheckBox m, CheckBox t, CheckBox w, CheckBox r, CheckBox f, EditText startHour, EditText startMin, EditText endHour, EditText endMin) {
        AlertDialog.Builder confirm_removal = new AlertDialog.Builder(context);
        confirm_removal.setTitle("Confirm Edit");
        confirm_removal.setPositiveButton("Confirm", (dialog, item) -> {
            items.set(currentListItemIndex, new Course(name.getText().toString(),
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
            notifyDataSetChanged();
        });
        confirm_removal.setNegativeButton("Back", (dialog, item) -> { });

        confirm_removal.show();
    }

    private void courseDetailsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = activity.getLayoutInflater();

        Course item = items.get(currentListItemIndex);

        View view = inflater.inflate(R.layout.courses_details, null);
        TextView name = view.findViewById(R.id.name);
        name.setText(item.getName());
        TextView section = view.findViewById(R.id.section);
        section.setText("Section: " + item.getSection());
        TextView professor = view.findViewById(R.id.professor);
        professor.setText("Professor: " + item.getProfessor());
        TextView location = view.findViewById(R.id.location);
        location.setText("Location: " + item.getLocation());
        TextView room = view.findViewById(R.id.room);
        room.setText("Room: " + item.getRoom());

        TextView time = view.findViewById(R.id.time);
        time.setText(item.getDetailedTime());

        CheckBox m = view.findViewById(R.id.monday);
        m.setChecked(item.isM());
        CheckBox t = view.findViewById(R.id.tuesday);
        t.setChecked(item.isT());
        CheckBox w = view.findViewById(R.id.wednesday);
        w.setChecked(item.isW());
        CheckBox r = view.findViewById(R.id.thursday);
        r.setChecked(item.isR());
        CheckBox f = view.findViewById(R.id.friday);
        f.setChecked(item.isF());


        builder.setView(view).setTitle("Course Details").setNegativeButton("Back",
                (dialog, which) -> {

                });

        builder.show();
    }
}