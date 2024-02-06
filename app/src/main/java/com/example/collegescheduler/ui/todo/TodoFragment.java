package com.example.collegescheduler.ui.todo;

import android.content.Context;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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
import com.example.collegescheduler.ui.assignments.AssignmentAddDialog;
import com.example.collegescheduler.ui.exams.Exam;

import java.util.ArrayList;

public class TodoFragment extends Fragment implements TodoAddDialog.ButtonDialogListener, AssignmentAddDialog.ButtonDialogListener {

    private FragmentTodoBinding binding;
    public Context context = getActivity();
    public static ArrayList<Object> items = new ArrayList<Object>();
    public ItemAdapter layoutAdapter;

    private ActionMode currentActionMode;
    private ActionMode.Callback modeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.setTitle("Options");
            mode.getMenuInflater().inflate(R.menu.add_item_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if (item.getItemId() == R.id.todo) {
                openTodoDialog();
                mode.finish();
                return true;
            } else if (item.getItemId() == R.id.assignment) {
                openAssignmentDialog();
                mode.finish();
                return true;
            } else if (item.getItemId() == R.id.exam) {
                mode.finish();
                return true;
            } else {
                return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            currentActionMode = null;
        }
    };

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
        addButtonToDoFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentActionMode != null) { return; }
                currentActionMode = v.startActionMode(modeCallback);
                v.setSelected(true);
            }
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
}