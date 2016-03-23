package com.example.u5778016.note_taking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by u5778016 on 22/03/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "note.db";
    public static final String TABLE_NAME = "note_table";
    public static final String _ID = "_id";
    public static final String TITLE = "Title";
    public static final String CONTENT = "Content";
    public static final String IMPORTANT = "Important";
    public static final String DATE = "Date";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( _id Integer primary key autoincrement, Title text, Content text,Important text,Date text ) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String title, String content, String important, String date) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TITLE, title);
        contentValues.put(CONTENT, content);
        contentValues.put(IMPORTANT, important);
        contentValues.put(DATE, date);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else
            return true;

    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);
        return cursor;
    }

    public Cursor getspecificdata(){
        SQLiteDatabase db=this.getWritableDatabase();

        int num=editpage.NUMINPUT;
        Cursor cursor=db.rawQuery("select * from "+ TABLE_NAME+"where _id="+num,null);
        return cursor;
    }

    public boolean updatedata(String id,String title, String content, String important, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(_ID,id);
        contentValues.put(TITLE, title);
        contentValues.put(CONTENT, content);
        contentValues.put(IMPORTANT, important);
        contentValues.put(DATE, date);
        db.update(TABLE_NAME,contentValues, "_ID = ?",new String[]{ id } );
        return true;

    }
    public Integer deletedata(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"_ID = ? ",new String[]{id});
    }
}

