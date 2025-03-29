package service;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import model.Task;
import view.TaskAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo.R;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    private EditText inputBox;
    private Button addButton;
    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;
    private ArrayList<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additems);

        inputBox = findViewById(R.id.inputBox);
        addButton = findViewById(R.id.addButton);
        recyclerView = findViewById(R.id.recyclerView);

        tasks = new ArrayList<>();
        taskAdapter = new TaskAdapter(tasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(taskAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskText = inputBox.getText().toString().trim();
                if (!taskText.isEmpty()) {
                    tasks.add(new Task(taskText));
                    taskAdapter.notifyDataSetChanged();
                    inputBox.setText("");
                } else {
                    Toast.makeText(AddActivity.this, "Please enter a task", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
