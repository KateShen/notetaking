package com.example.yushen.comp6442_assignment_1_2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button myButton=(Button)findViewById(R.id.button1);
        myButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.i("Create","You create a new note");
                        Intent i=new Intent(MainActivity.this,create.class);
                        startActivity(i);
                    }
                }
        );
    }

}
