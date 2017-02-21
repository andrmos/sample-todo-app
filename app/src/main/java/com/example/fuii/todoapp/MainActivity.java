package com.example.fuii.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView todoListView;
    private ArrayList<String> todos;
    private ArrayAdapter<String> todoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todos = new ArrayList<>();
        todos.add("Kjøpe mat");
        todos.add("Kjøpe pils");
        todos.add("Lære Android utvikling");

        todoListView = (ListView) findViewById(R.id.todoList);
        todoListAdapter = new ArrayAdapter<>(this, R.layout.todo_element, todos);
        todoListView.setAdapter(todoListAdapter);

    }

    public void startNewTodoActivity(View view) {
        Intent intent = new Intent(this, NewTodoActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            Bundle bundle = data.getExtras();
            String newTodo = bundle.getString("todoText");
            todos.add(newTodo);
            todoListAdapter.notifyDataSetChanged();
        }
    }
}
