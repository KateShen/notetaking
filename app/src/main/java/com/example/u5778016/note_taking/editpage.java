package com.example.u5778016.note_taking;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class editpage extends AppCompatActivity {
    EditText edittitle;
    EditText editcontent;
    EditText editimportant;
    TextView showdate;
    Button changebutton;
    Button cancelbutton;
    DatabaseHelper mydb;
    static int NUMINPUT;
    Date today = new Date(System.currentTimeMillis());
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editpage);


        edittitle = (EditText) findViewById(R.id.editText_titleE);
        editcontent = (EditText) findViewById(R.id.editText_contentE);
        editimportant = (EditText) findViewById(R.id.editText_importantE);
        showdate = (TextView) findViewById(R.id.textView_dateE);
        changebutton = (Button) findViewById(R.id.button_changeE);
        //cancelbutton = (Button) findViewById(R.id.button_cancelE);
        changeandshow();
    }

    public void changeandshow() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int idn = bundle.getInt("EDITPAGEJUMP");
            mydb = new DatabaseHelper(this);

            NUMINPUT = idn;
            Cursor cursor = mydb.getspecificdata();
            if (cursor.getCount() != 1) {
                Toast.makeText(this, "Nothing click", Toast.LENGTH_LONG).show();
            } else {
                // StringBuffer buffer = new StringBuffer();
                String s1 = cursor.getString(1).toString();
                String s2 = cursor.getString(2).toString();
                String s3 = cursor.getString(3).toString();
                String s4 = cursor.getString(4).toString();
                edittitle.setText(s1, TextView.BufferType.EDITABLE);
                editcontent.setText(s2, TextView.BufferType.EDITABLE);
                editimportant.setText(s3, TextView.BufferType.EDITABLE);
                showdate.setText(s4, TextView.BufferType.EDITABLE);
            }
        }

        changebutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isupdate = mydb.updatedata(Integer.toString(NUMINPUT),
                                edittitle.getText().toString(),
                                editcontent.getText().toString(),
                                editimportant.getText().toString(),
                                simpleDateFormat.format(today).toString());
                        if (isupdate == true) {
                            Toast.makeText(editpage.this, "Data update", Toast.LENGTH_LONG).show();
                        } else
                            Toast.makeText(editpage.this, "Data not updated", Toast.LENGTH_LONG).show();
                    }
                }
        );

    }


}