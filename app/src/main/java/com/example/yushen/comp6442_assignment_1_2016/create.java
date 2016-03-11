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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        final EditText editTextcontent=(EditText)findViewById(R.id.editText1);
        Button buttonsave=(Button)findViewById(R.id.button4);
        Button buttoncancel=(Button)findViewById(R.id.button3);


        buttonsave.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String inputText=editTextcontent.getText().toString();
                        Toast.makeText(create.this,"You want to save: "+inputText,Toast.LENGTH_LONG).show();
                    }
                }
        );

//        buttoncancel.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Log.i("Create", "You create a new note");
//                        Intent i = new Intent(MainActivity.this, create.class);
//                        startActivity(i);
//                    }
//                }
//        );



    }


    }