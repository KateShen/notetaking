package com.example.yushen.comp6442_assignment_1_2016;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class view1 extends AppCompatActivity {
    ListView titleli;
    DBHandler db=new DBHandler(this);
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view1);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, (List<String>) titleli);
        int j=db.getNoteCount();
        for (int i=1;i<=j;i++){
            adapter.add(db.getNewnote(i).getName());
        }
        titleli.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    public void addlistActivity(View view){
        titleli=(ListView)findViewById(R.id.titlelist);
        titleli.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int idnow=position;
                Intent nn=new Intent(view1.this,view2.class);
                nn.putExtra("idnumber",idnow);
                startActivity(nn);

            }

        });


    }
}
