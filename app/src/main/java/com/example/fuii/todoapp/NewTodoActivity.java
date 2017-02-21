package com.example.fuii.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewTodoActivity extends AppCompatActivity {

    /* The input field for the new to do */
    private EditText inputField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_todo);
        setTitle(R.string.create_new_todo);
        inputField = (EditText) findViewById(R.id.newTodoInput);
    }

    /**
     * Fetches the text from the 'new to do' input field, and sends it back to MainActivity.
     * If the text in the input field is empty, an error message is shown.
     * @param view The view of the clicked button
     */
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
