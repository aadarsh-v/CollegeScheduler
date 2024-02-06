package com.example.collegescheduler.ui.todo;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
import com.example.collegescheduler.databinding.FragmentTodoBinding;
import com.example.collegescheduler.ui.ItemAdapter;
import com.example.collegescheduler.ui.assignments.Assignment;
import com.example.collegescheduler.ui.assignments.AssignmentAddDialog;
import com.example.collegescheduler.ui.exams.Exam;

import java.util.ArrayList;

public class TodoFragment extends Fragment implements TodoAddDialog.ButtonDialogListener, AssignmentAddDialog.ButtonDialogListener {

    private FragmentTodoBinding binding;
    public static ArrayList<Object> items = new ArrayList<Object>();
    public ItemAdapter layoutAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TodoViewModel todoViewModel =
                new ViewModelProvider(this).get(TodoViewModel.class);

        binding = FragmentTodoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView rV = root.findViewById(R.id.recycleView);

        rV.setLayoutManager(new LinearLayoutManager(rV.getContext()));
        rV.setAdapter(layoutAdapter);
        Button addButtonToDoFrag = (Button) root.findViewById(R.id.addButtonToDo);
        addButtonToDoFrag.setOnClickListener(v -> {
            showAddItemMenu(v);
            v.setSelected(true);
        });

        return root;
    }

    public void openTodoDialog() {
        TodoAddDialog dia = new TodoAddDialog();
        dia.setTargetFragment(TodoFragment.this);
        dia.show(getParentFragmentManager(), "Add New Task Dialog");
    }

    public void openAssignmentDialog() {
        AssignmentAddDialog dia = new AssignmentAddDialog();
        dia.setTargetFragment(TodoFragment.this);
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
        layoutAdapter = new ItemAdapter(getContext(), getActivity(), items);
    }

    @Override
    public void onFinishEditDialog(String inputText) {
        layoutAdapter.notifyDataSetChanged();
    }

    private void showAddItemMenu(View v) {
        PopupMenu popup = new PopupMenu(getActivity(), v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.add_item_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.todo) {
                openTodoDialog();
                return true;
            } else if (item.getItemId() == R.id.assignment) {
                openAssignmentDialog();
                return true;
            } else if (item.getItemId() == R.id.exam) {
                return true;
            } else {
                return false;
            }
        });
        popup.show();
    }
}