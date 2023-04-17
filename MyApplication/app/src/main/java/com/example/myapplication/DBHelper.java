package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "MyUserDatabase.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table UserRecord (SN INTEGER primary key AUTOINCREMENT, NAME Text, " +
                "CONTACT Text, DOB Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists UserRecord");
    }

    public Boolean insertUserData(String name, String contact, String dob) {

        // to get database connection
        SQLiteDatabase db = this.getWritableDatabase();

        // to write content in database
        ContentValues contentValues = new ContentValues();

        // assign values to content variable
        contentValues.put("NAME", name);
        contentValues.put("CONTACT", contact);
        contentValues.put("DOB", dob);

        // execute the insert query
        Long result = db.insert("UserRecord", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean updateUserData(String name, String contact, String dob) {

        // to get database connection
        SQLiteDatabase db = this.getWritableDatabase();

        // to write content in database
        ContentValues contentValues = new ContentValues();

        // assign values to content variable
        contentValues.put("CONTACT", contact);
        contentValues.put("DOB", dob);

        // find current record
        Cursor getUserRecord = db.rawQuery("select * from UserRecord where NAME=?",
                new String[]{name});

        if (getUserRecord.getCount() > 0) {
            int result = db.update("UserRecord", contentValues, "Name=?",
                    new String[]{name});

            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Boolean deleteUserData(String name) {

        // to get database connection
        SQLiteDatabase db = this.getWritableDatabase();

        // find current record
        Cursor getUserRecord = db.rawQuery("select * from UserRecord where NAME=?",
                new String[]{name});

        if (getUserRecord.getCount() > 0) {
            int result = db.delete("UserRecord", "Name=?",
                    new String[]{name});

            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public Cursor viewUserData() {

        // to get database connection
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor findAllRecords = db.rawQuery("select * from UserRecord", null);
        return findAllRecords;
    }
}
