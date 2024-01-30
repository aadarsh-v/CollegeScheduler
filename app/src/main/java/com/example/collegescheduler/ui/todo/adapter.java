package com.example.collegescheduler.ui.todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegescheduler.R;

import java.util.List;

public class adapter extends RecyclerView.Adapter<ViewHolder> {


    Context context;
    List<Item> items;

    public adapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.todo_item_recycle_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.course.setText(items.get(position).getCourse());
        holder.date.setText(items.get(position).getDueDate());
        holder.task.setText(items.get(position).getTask());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
