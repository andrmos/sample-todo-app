package com.example.fuii.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /* The bundle key for the new to do text */
    public static final String NEW_TODO_KEY = "todoText";
    /* The request code of NewTodoActivity */
    public static final int NEW_TODO_REQUEST_CODE = 1;
    /* The list containing all todos */
    private ArrayList<String> todos;
    /* The adapter of the to do list */
    private ArrayAdapter<String> todoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.app_name);

        todos = new ArrayList<>();
        // Sample todos
        todos.add("Kjøpe mat");
        todos.add("Kjøpe pils");
        todos.add("Lære Android utvikling");

        ListView todoListView = (ListView) findViewById(R.id.todoList);
        // Create an adapter with all the todos, and link it to the list view
        todoListAdapter = new ArrayAdapter<>(this, R.layout.todo_element, todos);
        todoListView.setAdapter(todoListAdapter);
    }

    /**
     * Starts NewTodoActivity when the 'New to do' button is clicked
     * @param view The view of the clicked button
     */
    public void startNewTodoActivity(View view) {
        Intent intent = new Intent(this, NewTodoActivity.class);
        startActivityForResult(intent, NEW_TODO_REQUEST_CODE);
    }

    /**
     * Runs when an Activity started with the startActivityForResult() method is finished.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == NEW_TODO_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Get the entered to do text from NewTodoActivity intent
                Bundle bundle = data.getExtras();
                String newTodo = bundle.getString(NEW_TODO_KEY);
                todos.add(newTodo);
                // Notify the to do adapter that its content is updated
                todoListAdapter.notifyDataSetChanged();
            }
        }
    }
}
