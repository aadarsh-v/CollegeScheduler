package com.example.collegescheduler.ui.courses;

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

import com.example.collegescheduler.R;
import com.example.collegescheduler.databinding.FragmentCoursesBinding;
import com.example.collegescheduler.databinding.FragmentExamsBinding;
import com.example.collegescheduler.ui.ItemAdapter;
import com.example.collegescheduler.ui.exams.ExamsViewModel;
import com.example.collegescheduler.ui.todo.TodoAddDialog;

import java.util.ArrayList;

public class CoursesFragment extends Fragment {

    private FragmentCoursesBinding binding;
    public static ArrayList<Object> courses = new ArrayList<Object>();
    public ItemAdapter layoutAdapter = new ItemAdapter(getContext(), getActivity(), courses);

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CoursesViewModel coursesViewModel =
                new ViewModelProvider(this).get(CoursesViewModel.class);

        binding = FragmentCoursesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView rV = root.findViewById(R.id.recycleViewCourses);

        rV.setLayoutManager(new LinearLayoutManager(rV.getContext()));
        rV.setAdapter(layoutAdapter);
        Button addCourseButton = (Button) root.findViewById(R.id.add_course_button);
        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        return root;
    }

    public void openDialog() {
        TodoAddDialog addCourseDialog = new TodoAddDialog();
        addCourseDialog.show(getParentFragmentManager(), "Add New Task Dialog");
    }
//    public void onClickListener()

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}