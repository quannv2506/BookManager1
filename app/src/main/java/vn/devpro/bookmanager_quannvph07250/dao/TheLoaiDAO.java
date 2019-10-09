package vn.devpro.bookmanager_quannvph07250.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.devpro.bookmanager_quannvph07250.database.DatabaseHelper;
import vn.devpro.bookmanager_quannvph07250.model.TheLoai;

public class TheLoaiDAO {

    private SQLiteDatabase db;
    private DatabaseHelper dbManager;

    public static final String TABLE_NAME = "TheLoai";
    public static final String SQL_TheLoai = "CREATE TABLE TheLoai (maTheLoai integer primary key autoincrement, tenTheLoai text, viTri text, moTa text);";

    public TheLoaiDAO(Context context){
        dbManager = new DatabaseHelper(context);
        db = dbManager.getWritableDatabase();
    }

    //insert
    public long insertTheLoai(TheLoai theLoai){
        ContentValues values = new ContentValues();
//        values.put("maTheLoai", theLoai.getMaTheLoai());
        values.put("tenTheLoai", theLoai.getTenTheLoai());
        values.put("moTa", theLoai.getMoTa());
        values.put("viTri", theLoai.getViTri());

        long result = db.insert(TABLE_NAME, null, values);
        db.close();
        return result;
    }

    public List<TheLoai> getAllTheLoai(){
        List<TheLoai> theLoaiList = new ArrayList<>();

        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);
        c.moveToFirst();

        while (c.isAfterLast() == false){

            TheLoai theLoai = new TheLoai();
            theLoai.setMaTheLoai(c.getInt(0));
            theLoai.setTenTheLoai(c.getString(1));
            theLoai.setViTri(c.getString(2));
            theLoai.setMoTa(c.getString(3));

            theLoaiList.add(theLoai);
            c.moveToNext();
        }

        c.close();
        return theLoaiList;
    }

    public int updateTheLoai(TheLoai theLoai){
        ContentValues values = new ContentValues();
        values.put("maTheLoai", theLoai.getMaTheLoai());
        values.put("tenTheLoai", theLoai.getTenTheLoai());
        values.put("moTa", theLoai.getMoTa());
        values.put("viTri", theLoai.getViTri());

        int result = db.update(TABLE_NAME, values, "maTheLoai=?", new String[]{String.valueOf(theLoai.getMaTheLoai())});
        if (result == 0){
            return -1;
        }
        return 1;
    }

    public int deleteTheLoai(int maTheLoai){
        int result= db.delete(TABLE_NAME, "maTheLoai=?", new String[]{String.valueOf(maTheLoai)});
        if (result == 0){
            return -1;
        }
        return 1;
    }


}
