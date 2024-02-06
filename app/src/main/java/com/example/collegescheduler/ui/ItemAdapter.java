package com.example.collegescheduler.ui;

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

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    FragmentActivity activity;
    List<Object> items;

    private final int ASSIGNMENT = 0, EXAM = 1, TODO = 2;

    public ItemAdapter(Context context, FragmentActivity activity, List<Object> items) {
        this.context = context;
        this.activity = activity;
        this.items = items;
    }

    private int currentListItemIndex;
    private ActionMode currentActionMode;
    private ActionMode.Callback modeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.setTitle("Options");
            mode.getMenuInflater().inflate(R.menu.item_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if (item.getItemId() == R.id.view_details) {
                mode.finish();
                return true;
            } else if (item.getItemId() == R.id.edit_details) {
                Object cell = TodoFragment.items.get(currentListItemIndex);
                if (cell instanceof Todo) {
                    todoEditButtonDialog();
                    mode.finish();
                } else if (cell instanceof Assignment) {
                    assignmentEditButtonDialog();
                    mode.finish();
                } else if (cell instanceof Exam) {
                    examEditButtonDialog();
                    mode.finish();
                } else {
                    mode.finish();
                    return false;
                }
                return true;
            } else if (item.getItemId() == R.id.remove) {
                confirmRemovalDialog();
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

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // return new TodoHolder(LayoutInflater.from(context).inflate(R.layout.todo_item_recycle_view,parent,false));
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case EXAM:
                View v4 = inflater.inflate(R.layout.exams_cell, parent, false);
                viewHolder = new ExamHolder(v4);
                break;
            case TODO:
                View v1 = inflater.inflate(R.layout.todo_cell, parent, false);
                viewHolder = new TodoHolder(v1);
                break;
            case ASSIGNMENT:
                View v2 = inflater.inflate(R.layout.assignment_cell, parent, false);
                viewHolder = new AssignmentHolder(v2);
                break;
            default:
                View v3 = inflater.inflate(R.layout.todo_cell, parent, false);
                viewHolder = new TodoHolder(v3);
                break;
        }
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        Object item = items.get(position);
        if (item instanceof Assignment) {
            return ASSIGNMENT;
        } else if (item instanceof Exam) {
            return EXAM;
        } else if (item instanceof Todo) {
            return TODO;
        }
        return -1;
    }

//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        holder.getCourse().setText(((Item) items.get(position)).getCourse());
//        holder.getDate().setText(items.get(position).getDueDate());
//        holder.getTask().setText(items.get(position).getTask());
//    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case EXAM:
                ExamHolder vh4 = (ExamHolder) viewHolder;
                configureExamHolder(vh4, position);
                break;
            case ASSIGNMENT:
                AssignmentHolder vh1 = (AssignmentHolder) viewHolder;
                configureAssignmentHolder(vh1, position);
                break;
            case TODO:
                TodoHolder vh2 = (TodoHolder) viewHolder;
                configureTodoHolder(vh2, position);
                break;
            default:
                TodoHolder vh3 = (TodoHolder) viewHolder;
                configureTodoHolder(vh3, position);
                break;
        }

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = viewHolder.getBindingAdapterPosition();
                currentListItemIndex = position;
                if (currentActionMode != null) { return false; }
                currentActionMode = v.startActionMode(modeCallback);
                v.setSelected(true);
                return true;
            }

        });
    }

    private void configureAssignmentHolder(AssignmentHolder vh, int position) {
        Assignment assignment = (Assignment) items.get(position);
        if (assignment != null) {
            vh.getCourse().setText(assignment.getCourse());
            vh.getDate().setText(assignment.getReadableDate());
            vh.getCheckBox().setChecked(assignment.isComplete());
            vh.getName().setText(assignment.getName());
        }
    }

    private void configureExamHolder(ExamHolder vh, int position) {
        Exam exam = (Exam) items.get(position);
        if (exam != null) {
            vh.getCourse().setText(exam.getCourse());
            vh.getDate().setText(exam.getReadableDate());
            vh.getCheckBox().setChecked(exam.isComplete());
            vh.getName().setText(exam.getName());
        }
    }

    private void configureTodoHolder(TodoHolder vh, int position) {
        Todo todo = (Todo) items.get(position);
        if (todo != null) {
            vh.getDate().setText(todo.getReadableDate());
            vh.getCheckBox().setChecked(todo.isComplete());
            vh.getTask().setText(todo.getTask());
        }
    }

    private void confirmRemovalDialog() {
        AlertDialog.Builder confirm_removal = new AlertDialog.Builder(context);
        confirm_removal.setTitle("Confirm Removal");
        confirm_removal.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                items.remove(currentListItemIndex);
                notifyDataSetChanged();
            }
        });
        confirm_removal.setNegativeButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) { }
        });

        confirm_removal.show();
    }
    private void confirmTodoEditDialog(EditText task, EditText year, EditText month, EditText day) {
        AlertDialog.Builder confirm_removal = new AlertDialog.Builder(context);
        confirm_removal.setTitle("Confirm Edit");
        confirm_removal.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                TodoFragment.items.set(currentListItemIndex, new Todo(task.getText().toString(),
                        Integer.parseInt(year.getText().toString()),
                        Integer.parseInt(month.getText().toString()),
                        Integer.parseInt(day.getText().toString())
                ));
                notifyDataSetChanged();
            }
        });
        confirm_removal.setNegativeButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) { }
        });

        confirm_removal.show();
    }

    public void todoEditButtonDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = activity.getLayoutInflater();

        Todo item = (Todo) TodoFragment.items.get(currentListItemIndex);

        View view = inflater.inflate(R.layout.todo_add, null);
        EditText task = view.findViewById(R.id.taskInputDialog);
        task.setText(item.getTask());
        EditText year = view.findViewById(R.id.yearInput);
        year.setText(item.getYear());
        EditText month = view.findViewById(R.id.monthInput);
        month.setText(item.getMonth());
        EditText day = view.findViewById(R.id.dayInput);
        day.setText(item.getDay());

        builder.setView(view).setTitle("Edit Task").setNegativeButton("Back",
                (dialog, which) -> {

                }).setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                confirmTodoEditDialog(task, year, month, day);
            }
        });

        builder.show();
    }

    public void assignmentEditButtonDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = activity.getLayoutInflater();

        Todo item = (Todo) TodoFragment.items.get(currentListItemIndex);

        View view = inflater.inflate(R.layout.todo_add, null);
        EditText task = view.findViewById(R.id.taskInputDialog);
        task.setText(item.getTask());
        EditText year = view.findViewById(R.id.yearInput);
        year.setText(item.getYear());
        EditText month = view.findViewById(R.id.monthInput);
        month.setText(item.getMonth());
        EditText day = view.findViewById(R.id.dayInput);
        day.setText(item.getDay());

        builder.setView(view).setTitle("Edit Task").setNegativeButton("Back",
                (dialog, which) -> {

                }).setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TodoFragment.items.set(currentListItemIndex, new Todo(task.getText().toString(),
                        Integer.parseInt(year.getText().toString()),
                        Integer.parseInt(month.getText().toString()),
                        Integer.parseInt(day.getText().toString())
                ));
                notifyDataSetChanged();
            }
        });

        builder.show();
    }

    public void examEditButtonDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = activity.getLayoutInflater();

        Todo item = (Todo) TodoFragment.items.get(currentListItemIndex);

        View view = inflater.inflate(R.layout.todo_add, null);
        EditText task = view.findViewById(R.id.taskInputDialog);
        task.setText(item.getTask());
        EditText year = view.findViewById(R.id.yearInput);
        year.setText(item.getYear());
        EditText month = view.findViewById(R.id.monthInput);
        month.setText(item.getMonth());
        EditText day = view.findViewById(R.id.dayInput);
        day.setText(item.getDay());

        builder.setView(view).setTitle("Edit Task").setNegativeButton("Back",
                (dialog, which) -> {

                }).setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TodoFragment.items.set(currentListItemIndex, new Todo(task.getText().toString(),
                        Integer.parseInt(year.getText().toString()),
                        Integer.parseInt(month.getText().toString()),
                        Integer.parseInt(day.getText().toString())
                ));
                notifyDataSetChanged();
            }
        });

        builder.show();
    }

}
