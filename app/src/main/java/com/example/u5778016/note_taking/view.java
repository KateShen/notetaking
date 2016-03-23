package com.example.u5778016.note_taking;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class view extends ListActivity {
    DatabaseHelper db=null;
    public final static String EDITPAGEJUMP="1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        db=new DatabaseHelper(this);
        //Cursor cursor=db.getAllData();
        //String[] eachline1=new String[]{"_ID","TITLE","DATE"};
        //int[] eachline2=new int[]{R.id.textView_id1,R.id.textView_title1,R.id.textView_time1};
        SimpleCursorAdapter simpleCursorAdapter=new SimpleCursorAdapter(this,
                //android.R.layout.simple_list_item_1,
                R.layout.listcell,
                db.getAllData(),
                new String[]{"Title","Date"},
                new int[]{R.id.textView_title1,R.id.textView_time1}
        );
        ListView listView=(ListView)findViewById(android.R.id.list);
        listView.setAdapter(simpleCursorAdapter);
        //setListAdapter(simpleCursorAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent edit=new Intent(this,editpage.class);
        edit.putExtra("EDITPAGEJUMP",(int) id);
        startActivity(edit);
    }
}
