package com.example.u5778016.note_taking;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper mydb;
    EditText edittitle,editcontent,editimportant,editid;
    Button buttonadd,buttonviewall,buttonupdate,buttondelete;
    Date today=new Date(System.currentTimeMillis());
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
    //String daten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb =new DatabaseHelper(this);

        edittitle=(EditText)findViewById(R.id.editText_title);
        editcontent=(EditText)findViewById(R.id.editText_content);
        editimportant=(EditText)findViewById(R.id.editText_important);
        editid=(EditText)findViewById(R.id.editText_id);
        buttonadd=(Button)findViewById(R.id.button_add);
        buttonviewall=(Button)findViewById(R.id.button_viewall);
        buttonupdate=(Button)findViewById(R.id.button_update);
        buttondelete=(Button)findViewById(R.id.button_delete);


        adddata();
        viewall();
        updatedata();
        deletedata();

    }
    public void deletedata(){
        buttondelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deleterow=mydb.deletedata(editid.getText().toString());
                            if (deleterow>0){
                                Toast.makeText(MainActivity.this,"Data delete", Toast.LENGTH_LONG).show();
                            }else
                                Toast.makeText(MainActivity.this,"Data not delete",Toast.LENGTH_LONG).show();

                    }
                }
        );


    }
    public void updatedata(){
        buttonupdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isupdate=mydb.updatedata(editid.getText().toString(),
                                edittitle.getText().toString(),
                                editcontent.getText().toString(),
                                editimportant.getText().toString(),
                                simpleDateFormat.format(today).toString());
                        if(isupdate==true){
                            Toast.makeText(MainActivity.this,"Data update", Toast.LENGTH_LONG).show();
                        }else
                            Toast.makeText(MainActivity.this,"Data not updated",Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void adddata(){
        buttonadd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean ininserted = mydb.insertData(edittitle.getText().toString(),
                                editcontent.getText().toString(),
                                editimportant.getText().toString(),
                                simpleDateFormat.format(today).toString());
                        if (ininserted==true){
                            Toast.makeText(MainActivity.this,"Data inserted", Toast.LENGTH_LONG).show();
                        }else
                            Toast.makeText(MainActivity.this,"Data not inserte",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewall(){
        buttonviewall.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res=mydb.getAllData();
                            if (res.getCount()==0){
                                showmessage("Error", "Nothing found");
                                return;
                            }
                        StringBuffer buffer=new StringBuffer();
                        while (res.moveToNext()){
                            buffer.append("Id :"+res.getString(0)+"\n");
                            buffer.append("title :"+res.getString(1)+"\n");
                            buffer.append("content :"+res.getString(2)+"\n");
                            buffer.append("important :"+res.getString(3)+"\n");
                            buffer.append("date :"+res.getString(4)+"\n");
                        }
                        showmessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void showmessage(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void view2(View view){
        Intent i=new Intent(this,view.class);
        startActivity(i);
    }
}
