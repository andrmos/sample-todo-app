package com.example.fuii.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewTodoActivity extends AppCompatActivity {

    private EditText inputField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_todo);
        inputField = (EditText) findViewById(R.id.newTodoInput);
    }

    public void createNewTodo(View view) {
        String text = inputField.getText().toString();

        if (text.isEmpty()) {
            Toast.makeText(this, R.string.error_empty_todo, Toast.LENGTH_SHORT).show();

        } else {
            Intent intent = new Intent();
            intent.putExtra(MainActivity.NEW_TODO_KEY, text);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
