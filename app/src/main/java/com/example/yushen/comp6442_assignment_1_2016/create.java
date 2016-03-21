package com.example.yushen.comp6442_assignment_1_2016;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Time;

public class create extends AppCompatActivity {
    EditText title;
    EditText content;
    DBHandler db=new DBHandler(this);



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
        long time=System.currentTimeMillis();
        int i=db.getNoteCount();
        db.addnote(new Newnote(i + 1, titlestore, contentstore,time));
    }

    public void cancelActivity(final View view){
        AlertDialog.Builder builder= new AlertDialog.Builder(create.this);
        //Dialog builder = new AlertDialog.Builder(create.this);

                builder.setTitle("Cancel operation!");
                builder.setMessage("Are you sure you want to cancel this note?");
                builder.setIcon(R.mipmap.alertshow);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(create.this, "You click the yes button", Toast.LENGTH_LONG).show();

                        dialog.cancel();
                        Intent jump = new Intent(create.this, MainActivity.class);
                        startActivity(jump);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(create.this, "You click the no button", Toast.LENGTH_LONG).show();
                        dialog.cancel();

                    }
                });

    AlertDialog alert1=builder.create();
    alert1.show();
    }
    public void addPicActivity(View view){



    }
}