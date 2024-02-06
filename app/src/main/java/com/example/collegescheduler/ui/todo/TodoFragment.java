package com.example.collegescheduler.ui.todo;

import android.content.Context;
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

import java.util.ArrayList;

public class TodoFragment extends Fragment implements TodoAddDialog.ButtonDialogListener {

    private FragmentTodoBinding binding;
    public Context context = getActivity();
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
        TodoAddDialog addButtonDia = new TodoAddDialog();
        addButtonDia.setTargetFragment(TodoFragment.this);
        addButtonDia.show(getParentFragmentManager(), "Add New Task Dialog");
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

//    @Override
//    public void onViewCreated(View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        layoutAdapter = new ItemAdapter(getContext().getApplicationContext(), items);
//    }

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