package view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import ViewModel.ProjectAdapter;
import ViewModel.TaskAdapter;
import model.Task;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    private  EditText inputBox;
    private TaskAdapter taskAdapter;
    private ArrayList<Task> tasks;
     private Button addButton;
    private RecyclerView recyclerView;
     private RecyclerView projectRecyclerView;
     private Button addProject;
     private ArrayList<String> projectList;
     private EditText textProject;
     private ProjectAdapter projectAdapter;
     private DrawerLayout drawerLayout;
     private Button menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_additems);

        inputBox = findViewById(R.id.editText);
         addButton = findViewById(R.id.addButton);
         recyclerView = findViewById(R.id.recyclerView);


        tasks = new ArrayList<>();
        drawerLayout = findViewById(R.id.drawerLayout);
        menuButton = findViewById(R.id.menu_button);
        addProject = findViewById(R.id.addProjectBtn);
        textProject = findViewById(R.id.projectInput);
        projectRecyclerView = findViewById(R.id.projectRecyclerView);
        projectList = new ArrayList<>();
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

        menuButton.setOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        addProject.setOnClickListener(v -> {
            String project = textProject.getText().toString().trim();
            if (!project.isEmpty()) {
                projectList.add(project);
                projectAdapter.notifyItemInserted(projectList.size() - 1);
                textProject.setText("");
            }
        });
    }

    @Override
    protected void onResume() {
       super.onResume();
        taskAdapter = new TaskAdapter(tasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       recyclerView.setAdapter(taskAdapter);

        projectAdapter = new ProjectAdapter(projectList);
        projectRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        projectRecyclerView.setAdapter(projectAdapter);
   }
}