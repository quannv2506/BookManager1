package vn.devpro.bookmanager_quannvph07250.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import vn.devpro.bookmanager_quannvph07250.dao.NguoiDungDAO;
import vn.devpro.bookmanager_quannvph07250.dao.TheLoaiDAO;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "dbBookManager";
    public static final int VERSION = 1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(NguoiDungDAO.SQL_NguoiDung);
        sqLiteDatabase.execSQL(TheLoaiDAO.SQL_TheLoai);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NguoiDungDAO.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TheLoaiDAO.TABLE_NAME);
    }
}
