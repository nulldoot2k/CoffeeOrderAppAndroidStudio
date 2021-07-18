package com.example.orderapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";
    public static final String DBNAME = "account.db";

    public DatabaseHelper(Context context) {
        super(context, "account.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // tạo bảng database la` db
        db.execSQL("create table User ( id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT NOT NULL, password TEXT not null, repassed TEXT NOT NULL, name TEXT NOT NULL, phone TEXT NOT NULL, address TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists User");
    }
// Nhập dữ liệu vào Database db
    public boolean ínsertData(String email, String password, String repassword, String name, String telephonenumber, String address) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("repassed", repassword);
        contentValues.put("name", name);
        contentValues.put("phone", telephonenumber);
        contentValues.put("address", address);
        long result = MyDB.insert("User", null, contentValues);
        if (result != -1) {
            return true;
        } else {
            return false;
        }
    }
//  check email
    public boolean checkUser(String email) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from User where email = ?", new String[] { email });
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
//  check user
    public boolean checkUserandPass(String email, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from User where email = ? and password = ?", new String[] { email, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
//   update password after forgot
    public boolean updatepassword(String email, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", password);
        long result = MyDB.update("User", contentValues, "email = ?", new String[] {email});
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
}