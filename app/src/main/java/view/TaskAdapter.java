package view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.todo.R;

import model.Task;
import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private ArrayList<Task> tasks;

    public TaskAdapter(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent,false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        Task task = tasks.get(position);
        holder.taskText.setText(task.getTaskText());
        holder.checkBox.setChecked(task.isChecked());

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            task.setChecked(isChecked);
            holder.taskText.setText(isChecked ? task.getTaskText() + " (Completed)" : task.getTaskText());
            holder.taskText.setEnabled(!isChecked);
        });


        holder.closeIcon.setOnClickListener(v -> {
            tasks.remove(position);
            notifyItemRemoved(position);
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {

        TextView taskText;
        CheckBox checkBox;
        ImageView closeIcon;

        public TaskViewHolder(View itemView) {
            super(itemView);
            taskText = itemView.findViewById(R.id.taskText);
            checkBox = itemView.findViewById(R.id.checkBox);
            closeIcon = itemView.findViewById(R.id.closeIcon);
        }
    }
}