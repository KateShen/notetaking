package com.example.yushen.comp6442_assignment_1_2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class create extends AppCompatActivity {
    EditText title;
    EditText content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        title=(EditText)findViewById(R.id.editText_title);
        content=(EditText)findViewById(R.id.editText_content);

    }

    public void saveActivity(View view){
        String titlestore=title.getText().toString();
        String contentstore=content.getText().toString();


    }

    public void cancelActivity(View view){



    }
    public void addPicActivity(View view){



    }
}