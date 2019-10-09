package vn.devpro.bookmanager_quannvph07250.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.devpro.bookmanager_quannvph07250.database.DatabaseHelper;
import vn.devpro.bookmanager_quannvph07250.model.NguoiDung;

public class NguoiDungDAO {
    private SQLiteDatabase sqLiteDatabase;
    private DatabaseHelper dbManager;

    public static final String TABLE_NAME = "NguoiDung";
    public static final String SQL_NguoiDung = "CREATE TABLE NguoiDung (username text primary key, password text, phone text, fullName text);";

    public NguoiDungDAO(Context context) {
        dbManager = new DatabaseHelper(context);
        sqLiteDatabase = dbManager.getWritableDatabase();
    }

    //insert
    public long insertUser(NguoiDung nguoiDung) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", nguoiDung.getUsername());
        contentValues.put("password", nguoiDung.getPassword());
        contentValues.put("phone", nguoiDung.getPhone());
        contentValues.put("fullName", nguoiDung.getFullName());
        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
        return result;
    }

    public List<NguoiDung> getAllNguoiDung() {
        List<NguoiDung> nguoiDungList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false){
            NguoiDung nd = new NguoiDung();
            nd.setUsername(cursor.getString(0));
            nd.setPassword(cursor.getString(1));
            nd.setPhone(cursor.getString(2));
            nd.setFullName(cursor.getString(3));
            nguoiDungList.add(nd);
            cursor.moveToNext();
        }
        dbManager.close();
        return nguoiDungList;
    }

    public int updateUser(String username, String phone, String fullName){
        ContentValues values = new ContentValues();
        values.put("phone", phone);
        values.put("fullName", fullName);

        int result = sqLiteDatabase.update(TABLE_NAME, values, "username=?", new String[]{username});
        if (result == 0){
            return -1;
        }
        return 1;
    }

    public int deleteUser(String username){
        int result= sqLiteDatabase.delete(TABLE_NAME, "username=?", new String[]{username});
        if (result == 0){
            return -1;
        }
        return 1;
    }

    public boolean isLogin(NguoiDung nd){
        String sqlSelect = "SELECT username, password from NguoiDung WHERE username =? and password =?";
        String username = nd.getUsername();
        String password = nd.getPassword();

        Cursor cursor = sqLiteDatabase.rawQuery(sqlSelect, new String[]{username, password});

        if (cursor.moveToFirst()){
            return true;
        }
        return false;
    }

    public boolean isChangePassword(NguoiDung nd){
        ContentValues values = new ContentValues();
        values.put("username", nd.getUsername());
        values.put("password", nd.getPassword());

        int result = sqLiteDatabase.update(TABLE_NAME, values, "username=?", new String[]{nd.getUsername()});
        if (result == -1){
            return false;
        }
        return true;
    }
}
