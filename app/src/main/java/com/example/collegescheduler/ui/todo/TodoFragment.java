package com.example.collegescheduler.ui.todo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.collegescheduler.MainActivity;
import com.example.collegescheduler.R;
import com.example.collegescheduler.databinding.FragmentTodoBinding;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class TodoFragment extends Fragment {

    private FragmentTodoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TodoViewModel todoViewModel =
                new ViewModelProvider(this).get(TodoViewModel.class);

        binding = FragmentTodoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView rV = root.findViewById(R.id.recycleView);

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item("sdaf","sadf","sadf"));
        items.add(new Item("sdafadsf","sadfafds","sadfasdf"));
        rV.setLayoutManager(new LinearLayoutManager(rV.getContext()));
        rV.setAdapter(new adapter(getContext(),items));

        return root;


    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}