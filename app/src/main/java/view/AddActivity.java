package view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import ViewModel.TaskAdapter;
import model.Task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo.R;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    private  EditText inputBox;
    private TaskAdapter taskAdapter;
    private ArrayList<Task> tasks;
     private Button addButton;
     private RecyclerView recyclerView;
     private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_additems);

        inputBox = findViewById(R.id.editText);
         addButton = findViewById(R.id.addButton);
         recyclerView = findViewById(R.id.recyclerView);

        tasks = new ArrayList<>();

    }

    protected void onStart(){
        super.onStart();
        addButton.setOnClickListener(v ->{
            String items = inputBox.getText().toString().trim();
            if(!items.isEmpty()){
                tasks.add(new Task(items));
                taskAdapter.notifyDataSetChanged();
                inputBox.setText("");
            }
        });
    }

    @Override
    protected void onResume() {
       super.onResume();
        taskAdapter = new TaskAdapter(tasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       recyclerView.setAdapter(taskAdapter);
   }
}