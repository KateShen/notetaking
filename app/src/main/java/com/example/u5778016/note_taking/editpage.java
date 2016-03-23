package com.example.u5778016.note_taking;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class editpage extends AppCompatActivity {
    EditText edittitle;
    EditText editcontent;
    EditText editimportant;
    TextView showdate;
    Button changebutton;
    DatabaseHelper mydb;
    static int NUMINPUT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editpage);


        edittitle=(EditText)findViewById(R.id.editText_titleE);
        editcontent=(EditText)findViewById(R.id.editText_contentE);
        editimportant=(EditText)findViewById(R.id.editText_importantE);
        showdate=(TextView)findViewById(R.id.textView_dateE);
        changebutton=(Button)findViewById(R.id.button_changeE);
        changeandshow();
    }

    public void changeandshow(){
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            int idn=bundle.getInt("EDITPAGEJUMP");
        mydb=new DatabaseHelper(this);

            NUMINPUT=idn;
        Cursor cursor=mydb.getspecificdata();
        StringBuffer buffer=new StringBuffer();
        edittitle.setText(buffer.append(cursor.getString(1)).toString());
        editcontent.setText(buffer.append(cursor.getString(2)).toString());
        editimportant.setText(buffer.append(cursor.getString(3)).toString());
        showdate.setText(buffer.append(cursor.getString(4)).toString());
    }
    }


}
