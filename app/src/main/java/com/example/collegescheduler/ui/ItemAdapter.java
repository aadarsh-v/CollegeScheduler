package com.example.collegescheduler.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegescheduler.R;
import com.example.collegescheduler.ui.assignments.Assignment;
import com.example.collegescheduler.ui.assignments.AssignmentHolder;
import com.example.collegescheduler.ui.exams.Exam;
import com.example.collegescheduler.ui.exams.ExamHolder;
import com.example.collegescheduler.ui.todo.Todo;
import com.example.collegescheduler.ui.todo.TodoHolder;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Object> items;

    private final int ASSIGNMENT = 0, EXAM = 1, TODO = 2;

    public ItemAdapter(Context context, List<Object> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // return new TodoHolder(LayoutInflater.from(context).inflate(R.layout.todo_item_recycle_view,parent,false));
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case EXAM:
                View v4 = inflater.inflate(R.layout.exams_cell, parent, false);
                viewHolder = new ExamHolder(v4);
                break;
            case TODO:
                View v1 = inflater.inflate(R.layout.todo_cell, parent, false);
                viewHolder = new TodoHolder(v1);
                break;
            case ASSIGNMENT:
                View v2 = inflater.inflate(R.layout.assignment_cell, parent, false);
                viewHolder = new AssignmentHolder(v2);
                break;
            default:
                View v3 = inflater.inflate(R.layout.todo_cell, parent, false);
                viewHolder = new TodoHolder(v3);
                break;
        }
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        Object item = items.get(position);
        if (item instanceof Assignment) {
            return ASSIGNMENT;
        } else if (item instanceof Exam) {
            return EXAM;
        } else if (item instanceof Todo) {
            return TODO;
        }
        return -1;
    }

//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        holder.getCourse().setText(((Item) items.get(position)).getCourse());
//        holder.getDate().setText(items.get(position).getDueDate());
//        holder.getTask().setText(items.get(position).getTask());
//    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case EXAM:
                ExamHolder vh4 = (ExamHolder) viewHolder;
                configureExamHolder(vh4, position);
                break;
            case ASSIGNMENT:
                AssignmentHolder vh1 = (AssignmentHolder) viewHolder;
                configureAssignmentHolder(vh1, position);
                break;
            case TODO:
                TodoHolder vh2 = (TodoHolder) viewHolder;
                configureTodoHolder(vh2, position);
                break;
            default:
                TodoHolder vh3 = (TodoHolder) viewHolder;
                configureTodoHolder(vh3, position);
                break;
        }
    }

    private void configureAssignmentHolder(AssignmentHolder vh, int position) {
        Assignment assignment = (Assignment) items.get(position);
        if (assignment != null) {
            vh.getCourse().setText(assignment.getCourse());
            vh.getDate().setText(assignment.getReadableDate());
            vh.getCheckBox().setChecked(assignment.isComplete());
            vh.getName().setText(assignment.getName());
        }
    }

    private void configureExamHolder(ExamHolder vh, int position) {
        Exam exam = (Exam) items.get(position);
        if (exam != null) {
            vh.getCourse().setText(exam.getCourse());
            vh.getDate().setText(exam.getReadableDate());
            vh.getCheckBox().setChecked(exam.isComplete());
            vh.getName().setText(exam.getName());
        }
    }

    private void configureTodoHolder(TodoHolder vh, int position) {
        Todo todo = (Todo) items.get(position);
        if (todo != null) {
            vh.getDate().setText(todo.getReadableDate());
            vh.getCheckBox().setChecked(todo.isComplete());
            vh.getTask().setText(todo.getTask());
        }
    }

}
