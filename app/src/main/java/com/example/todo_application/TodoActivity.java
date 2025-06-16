package com.example.todo_application;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;


public class TodoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
   // private TodoAdapter adapter;
    private List<String> todoItems;
    private String projectTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        recyclerView = findViewById(R.id.recyclerViewTodos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        todoItems = new ArrayList<>();
        //adapter = new TodoAdapter(todoItems);
       // recyclerView.setAdapter(adapter);

        projectTitle = getIntent().getStringExtra("projectTitle");
        setTitle(projectTitle);

        findViewById(R.id.btnAddTodo).setOnClickListener(v -> showAddTodoDialog());
    }

    private void showAddTodoDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter To-Do Item");

        final EditText input = new EditText(this);
        builder.setView(input);

        builder.setPositiveButton("Add", (dialog, which) -> {
            String item = input.getText().toString();
            if (!item.isEmpty()) {
                todoItems.add(item);
               // adapter.notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("Cancel", null);
        builder.show();
    }
}