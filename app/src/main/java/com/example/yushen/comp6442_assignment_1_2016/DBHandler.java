package com.example.yushen.comp6442_assignment_1_2016;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yushen on 18/03/2016.
 */
public class DBHandler extends SQLiteOpenHelper {
    private static final int DATA_VERSION=1;
    private static final String DATABASE_NAME="notebook";
    private static final String TABLE_NOTEBOOK="note";
    private static final String KEY_ID="id";
    private static final String Key_name="title";
    private static final String Key_content="content";
    private static final String Key_time="time";
    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHandler(Context context){
        super(context, DATABASE_NAME, null, DATA_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE="CREATE TABLE "+ TABLE_NOTEBOOK+"("+ KEY_ID + " INTEGER PRIMARY KEY,"+Key_name+"TEXT"+Key_content+"TEXT"+Key_time+"TEXT"+")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTEBOOK);
        onCreate(db);

    }
    // add new note
    public void addnote(Newnote newnote){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_ID,newnote.getId());
        values.put(Key_name,newnote.getName());
        values.put(Key_content, newnote.getContent());
        values.put(Key_time,newnote.getTime());

        db.insert(TABLE_NOTEBOOK, null, values);
        db.close();
    }
    //read new note

    public Newnote getNewnote(int id){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NOTEBOOK,new String[]{KEY_ID,Key_name,Key_content,Key_time },KEY_ID + "=?",new String[]{String.valueOf(id) },null,null,null,null);
        if (cursor!=null)
            cursor.moveToFirst();
            Newnote newno2=new Newnote(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2),cursor.getLong(3));
            return newno2;
    }



    public List<Newnote> getAllNote(int id){
        List<Newnote> newnoteList=new ArrayList<Newnote>();
        String selectQuery="SELECT * FROM "+TABLE_NOTEBOOK;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                Newnote newno1=new Newnote();
                newno1.setId(cursor.getInt(Integer.parseInt(cursor.getString(0))));
                newno1.setName(cursor.getString(1));
                newno1.setContent(cursor.getString(2));
                newno1.setTime(cursor.getLong(3));

                newnoteList.add(newno1);
            }while (cursor.moveToNext());
        }
        return newnoteList;
    }

    public int getNoteCount(){
        String countquery="SELECT * FROM "+TABLE_NOTEBOOK;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(countquery, null);

        if (cursor.moveToFirst()==true){
            cursor.close();
            return cursor.getCount();
        }
        else
            cursor.close();
        return 0;
    }

    //update reocrd

    public int updatenote(Newnote newnote){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Key_name,newnote.getName());
        values.put(Key_content,newnote.getContent());
        values.put(Key_time,newnote.getTime());
        return db.update(TABLE_NOTEBOOK,values,KEY_ID+"=?",new String[]{String.valueOf(newnote.getId())});
    }
    //delete record

    public void deletenote(Newnote newnote){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NOTEBOOK, KEY_ID+"=?",new String[] {String.valueOf(newnote.getId())});
        db.close();
    }
}
