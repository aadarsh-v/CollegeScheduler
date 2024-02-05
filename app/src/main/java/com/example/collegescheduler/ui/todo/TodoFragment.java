package com.example.collegescheduler.ui.todo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegescheduler.R;
import com.example.collegescheduler.databinding.FragmentTodoBinding;
import com.example.collegescheduler.ui.ItemAdapter;
import com.example.collegescheduler.ui.assignments.Assignment;
import com.example.collegescheduler.ui.exams.Exam;

import java.util.ArrayList;

public class TodoFragment extends Fragment {

    private FragmentTodoBinding binding;
    public static ArrayList<Object> items = new ArrayList<Object>();
    public ItemAdapter layoutAdapter = new ItemAdapter(getContext(), items);
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TodoViewModel todoViewModel =
                new ViewModelProvider(this).get(TodoViewModel.class);

        binding = FragmentTodoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView rV = root.findViewById(R.id.recycleView);

        rV.setLayoutManager(new LinearLayoutManager(rV.getContext()));
        rV.setAdapter( layoutAdapter);
        items.add(new Todo("sadf",2023, 15, 11));
        items.add(new Todo("sadfafds",2023, 02, 28));
        items.add(new Assignment("Assignment 2", "MATH 4803", 2023, 03, 07));
        items.add(new Exam("Test 1", "MATH 4108", "Skiles 169", 2023, 02, 16, 11, 30));
        Button addButtonToDoFrag = (Button) root.findViewById(R.id.addButtonToDo);
        addButtonToDoFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
        Button refreshButtonToDoFrag = (Button) root.findViewById(R.id.refreshButtonToDo);
        refreshButtonToDoFrag.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                rV.setAdapter(layoutAdapter);
            }
        });

        return root;
    }

    public void openDialog() {
        AddButtonDialog addButtonDia = new AddButtonDialog();
        addButtonDia.show(getParentFragmentManager(), "Add New Task Dialog");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}