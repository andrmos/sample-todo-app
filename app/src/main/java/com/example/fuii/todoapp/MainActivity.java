package com.example.fuii.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String NEW_TODO_KEY = "todoText";
    public static final int NEW_TODO_REQUEST_CODE = 1;
    private ArrayList<String> todos;
    private ArrayAdapter<String> todoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.app_name);

        todos = new ArrayList<>();
        todos.add("Kjøpe mat");
        todos.add("Kjøpe pils");
        todos.add("Lære Android utvikling");

        ListView todoListView = (ListView) findViewById(R.id.todoList);
        todoListAdapter = new ArrayAdapter<>(this, R.layout.todo_element, todos);
        todoListView.setAdapter(todoListAdapter);

    }


    public void startNewTodoActivity(View view) {
        Intent intent = new Intent(this, NewTodoActivity.class);
        startActivityForResult(intent, NEW_TODO_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == NEW_TODO_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                String newTodo = bundle.getString(NEW_TODO_KEY);
                todos.add(newTodo);
                todoListAdapter.notifyDataSetChanged();
            }
        }
    }
}
