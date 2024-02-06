package com.example.collegescheduler.ui.exams;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegescheduler.databinding.FragmentAssignmentsBinding;
import com.example.collegescheduler.databinding.FragmentExamsBinding;
import com.example.collegescheduler.databinding.FragmentTodoBinding;
import com.example.collegescheduler.ui.ItemAdapter;
import com.example.collegescheduler.R;
import com.example.collegescheduler.ui.assignments.Assignment;
//import com.example.collegescheduler.ui.todo.Exams;
//import com.example.collegescheduler.ui.todo.ExamsViewModel;
import com.example.collegescheduler.ui.todo.TodoViewModel;

import java.util.ArrayList;
public class ExamsFragment extends Fragment {

    private FragmentExamsBinding binding;
    public static ArrayList<Object> exams = new ArrayList<Object>();
    public ItemAdapter layoutAdapter = new ItemAdapter(getContext(), exams);

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ExamsViewModel examViewModel =
                new ViewModelProvider(this).get(ExamsViewModel.class);

        binding = FragmentExamsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView rV = root.findViewById(R.id.recycleViewExams);

        rV.setLayoutManager(new LinearLayoutManager(rV.getContext()));
        rV.setAdapter(layoutAdapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}