package com.example.fuii.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

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
        Intent intent = new Intent();
        intent.putExtra("todoText", text);
        setResult(RESULT_OK, intent);
        finish();
    }
}
