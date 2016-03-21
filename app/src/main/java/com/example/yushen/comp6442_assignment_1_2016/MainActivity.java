package com.example.yushen.comp6442_assignment_1_2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button createButton;
    Button viewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createButton=(Button)findViewById(R.id.button_create);
        viewButton=(Button)findViewById(R.id.button_check);

        createButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("Create","You create a new note");
                        Intent i=new Intent(MainActivity.this,create.class);
                        startActivity(i);
                    }
                }
        );
        viewButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("View", "You view all the notes");
                        Intent j=new Intent(MainActivity.this,view1.class);
                        startActivity(j);
                    }
                }

        );
    }
}
