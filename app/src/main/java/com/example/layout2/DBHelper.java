package com.example.layout2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Mahasiswa.db";
    public static final String MAHASISWA_TABLE_NAME = "mahasiswa";
    public static final String MAHASISWA_COLUMN_NIM = "nim";
    public static final String MAHASISWA_COLUMN_NAMA = "nama";
    public static final String MAHASISWA_COLUMN_PRODI = "prodi";
    private HashMap hp;


    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table mahasiswa "+ "(nim char(8) NOT NULL,"+
                " nama TEXT NOT NULL,"+
                " prodi TEXT NOT NULL,"+
                " PRIMARY KEY(nim))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS mahasiswa");
        onCreate(db);
    }

    public boolean insertMahasiswa(String nim, String nama, String prodi){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nim", nim);
        contentValues.put("nama", nama);
        contentValues.put("prodi", prodi);
        db.insert("mahasiswa", null, contentValues);
        return true;
    }

    public Integer deleteMahasiswa(String nama){
        SQLiteDatabase db = this.getWritableDatabase();
        String[] namaMhs = {nama};
        return db.delete("mahasiswa", "nama = ? ", namaMhs);
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from mahasiswa where id="+id+"", null );
        return res;
    }


    //nama mahasiswa
    public ArrayList<String> getAllMahasiswa() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from mahasiswa", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(MAHASISWA_COLUMN_NAMA)));
            res.moveToNext();
        }
        return array_list;
    }
}
