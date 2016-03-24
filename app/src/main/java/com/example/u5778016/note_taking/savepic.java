package com.example.u5778016.note_taking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;

public class savepic extends AppCompatActivity {
    ImageView imageView;
    Button save;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savepic);
        imageView=(ImageView)this.findViewById(R.id.imageView_pic);
        db=this.openOrCreateDatabase("pic.db", Context.MODE_PRIVATE,null);
        db.execSQL("create table if not exists tb (a blob)");
    }
    public void saveImage(View view) throws IOException {
        FileInputStream fileInputStream=new FileInputStream();
        byte[] image=new byte[fileInputStream.available()];
        fileInputStream.read(image);
        ContentValues values=new ContentValues();
        values.put("a", image);
        db.insert("tb", null, values);
        fileInputStream.close();
        Toast.makeText(this,"Insert success", Toast.LENGTH_LONG).show();


    }
    public void getImage(View view){
        Cursor cursor=db.rawQuery("select * from tb", null);
        if (cursor.moveToNext()){
            byte[] image=cursor.getBlob(0);
            Bitmap bitmap= BitmapFactory.decodeByteArray(image,0,image.length);
            imageView.setImageBitmap(bitmap);
            Toast.makeText(this,"select success", Toast.LENGTH_LONG).show();
        }


    }
}
