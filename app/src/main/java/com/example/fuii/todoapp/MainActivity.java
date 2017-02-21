package com.example.fuii.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView todoListView;
    private ArrayList<String> todos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todos = new ArrayList<>();
        todos.add("Kjøpe mat");
        todos.add("Kjøpe pils");
        todos.add("Lære Android utvikling");

        todoListView = (ListView) findViewById(R.id.todoList);
        ArrayAdapter<String> todoListAdapter = new ArrayAdapter<>(this, R.layout.todo_element, todos);
        todoListView.setAdapter(todoListAdapter);

    }
}
