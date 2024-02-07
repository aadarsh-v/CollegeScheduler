//package com.example.collegescheduler.ui.courses;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//import androidx.lifecycle.ViewModelProvider;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.collegescheduler.R;
//import com.example.collegescheduler.databinding.FragmentCoursesBinding;
//import com.example.collegescheduler.ui.items.Item;
//import com.example.collegescheduler.ui.ItemAdapter;
//
//import java.util.ArrayList;
//
//public class CoursesFragment extends Fragment {
//
//    private FragmentCoursesBinding binding;
//    public static ArrayList<Course> items = new ArrayList<Course>();
//    // public ItemAdapter layoutAdapter = new ItemAdapter(getContext(), getActivity(), items);
//
////    public View onCreateView(@NonNull LayoutInflater inflater,
////                             ViewGroup container, Bundle savedInstanceState) {
////        CoursesViewModel coursesViewModel =
////                new ViewModelProvider(this).get(CoursesViewModel.class);
////
////        binding = FragmentCoursesBinding.inflate(inflater, container, false);
////        View root = binding.getRoot();
////
////        RecyclerView rV = root.findViewById(R.id.recycleViewCourses);
////
////        rV.setLayoutManager(new LinearLayoutManager(rV.getContext()));
////        rV.setAdapter(layoutAdapter);
////        Button addCourseButton = (Button) root.findViewById(R.id.add_course_button);
////        addCourseButton.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                openDialog();
////            }
////        });
////
////        return root;
////    }
////
////    public void openDialog() {
////        TodoAddDialog addCourseDialog = new TodoAddDialog();
////        addCourseDialog.show(getParentFragmentManager(), "Add New Task Dialog");
////    }
////    public void onClickListener()
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
//
//}

package com.example.collegescheduler.ui.courses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collegescheduler.R;
import com.example.collegescheduler.databinding.FragmentCoursesBinding;
import com.example.collegescheduler.ui.items.Item;
import com.example.collegescheduler.ui.ItemAdapter;
import com.example.collegescheduler.ui.assignments.AssignmentAddDialog;
import com.example.collegescheduler.ui.exams.ExamAddDialog;

import java.util.ArrayList;
import java.util.Comparator;

public class CoursesFragment extends Fragment implements CourseAddDialog.ButtonDialogListener {

    private FragmentCoursesBinding binding;
    public static ArrayList<Course> items = new ArrayList<Course>();
    public CourseItemAdapter layoutAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CoursesViewModel coursesViewModel =
                new ViewModelProvider(this).get(CoursesViewModel.class);

        binding = FragmentCoursesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView rV = root.findViewById(R.id.recycleView);

        rV.setLayoutManager(new LinearLayoutManager(rV.getContext()));
        rV.setAdapter(layoutAdapter);
        Button addButtonCourseFrag = (Button) root.findViewById(R.id.addButtonCourse);
        addButtonCourseFrag.setOnClickListener(v -> {
            openCoursesDialog();
            v.setSelected(true);
        });

        return root;
    }

    public void openCoursesDialog() {
        CourseAddDialog dia = new CourseAddDialog();
        dia.setTargetFragment(CoursesFragment.this);
        dia.show(getParentFragmentManager(), "Add New Task Dialog");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onCreate(Bundle savedBundleInstance) {
        super.onCreate(savedBundleInstance);
        layoutAdapter = new CourseItemAdapter(getContext(), getActivity(), items);
    }

    @Override
    public void onFinishEditDialog(String inputText) {
        layoutAdapter.notifyDataSetChanged();
    }
}