package com.example.collegescheduler.ui.courses;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegescheduler.R;
import com.example.collegescheduler.ui.assignments.Assignment;
import com.example.collegescheduler.ui.assignments.AssignmentHolder;
import com.example.collegescheduler.ui.exams.Exam;
import com.example.collegescheduler.ui.exams.ExamHolder;
import com.example.collegescheduler.ui.todo.Todo;
import com.example.collegescheduler.ui.todo.TodoFragment;
import com.example.collegescheduler.ui.todo.TodoHolder;

import java.util.List;

public class CourseItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    FragmentActivity activity;
    List<Object> items;
    public CourseItemAdapter(Context context, FragmentActivity activity, List<Object> items) {
        this.context = context;
        this.activity = activity;
        this.items = items;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // return new TodoHolder(LayoutInflater.from(context).inflate(R.layout.todo_item_recycle_view,parent,false));
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View c = inflater.inflate(R.layout.courses_cell, parent, false);
        // View v = new CourseHolder(c);
        return new TodoHolder(LayoutInflater.from(context).inflate(R.layout.courses_cell,parent,false));
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

    }
}