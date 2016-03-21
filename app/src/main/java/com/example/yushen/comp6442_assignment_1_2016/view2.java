package com.example.yushen.comp6442_assignment_1_2016;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class view2 extends AppCompatActivity {
    TextView title;
    TextView content;
    TextView time;
    DBHandler db=new DBHandler(this);
    Intent nn=getIntent();
    int idnumber=nn.getIntExtra("idnumber",0);
    Newnote note=new Newnote();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view2);
        title=(TextView)findViewById(R.id.textView_title);
        content=(TextView)findViewById(R.id.textView_show);
        time=(TextView)findViewById(R.id.textView_time);
    }

    public void show(View view){

        title.setText(db.getNewnote(idnumber).getName());
        content.setText(db.getNewnote(idnumber).getContent());
        time.setText((int) db.getNewnote(idnumber).getTime());
    }
    public void deleteActivity(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(view2.this);
        builder.setIcon(R.mipmap.alertshow);
        builder.setTitle("Delete operation!");
        builder.setMessage("Do you want to delete this note?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                db.deletenote(note);
                Toast.makeText(view2.this,"Delete content",Toast.LENGTH_LONG).show();
            }
        });


            builder.setNegativeButton("No", (DialogInterface.OnClickListener) Toast.makeText(view2.this, "Return to content", Toast.LENGTH_LONG)).show();
    }
}
