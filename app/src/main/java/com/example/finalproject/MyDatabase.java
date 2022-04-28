package com.example.finalproject;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//import com.google.firebase.firestore.auth.User;

public class MyDatabase extends SQLiteOpenHelper {
    public static final String DB_NAME = "flower_shop";
    public static final int DB_VERSION = 3;
    public static final String TABLE_USER = "User";
    public static final String COLUMN_USER_FIRST_NAME = "user_first_name";
    public static final String COLUMN_USER_LAST_NAME = "user_last_name";
    public static final String COLUMN_USER_EMAIL = "user_email";
    public static final String COLUMN_USER_PASSWORD = "user_password";

    public static final String CREATE_USER_TABLE = " CREATE TABLE " + TABLE_USER + " ( " + COLUMN_USER_FIRST_NAME + " varchar(255) not null, " + COLUMN_USER_LAST_NAME +" varchar(255) not null, " + COLUMN_USER_EMAIL + " varchar(255) not null , " + COLUMN_USER_PASSWORD + " varchar(255) not null" + ")";

    public MyDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //called on creating database only one time
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_USER);
        onCreate(sqLiteDatabase);
    }
    public boolean insertUser(User user) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_FIRST_NAME, user.getFirstName());
        values.put(COLUMN_USER_LAST_NAME, user.getLastName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        long result = database.insert(TABLE_USER, null, values);
        return result != -1;
    }
    public boolean checkUser(String email, String password) {
        SQLiteDatabase database = getReadableDatabase();
        String selection[] = {email, password};
        Cursor cursor = database.rawQuery("select * from " + TABLE_USER + " where " + COLUMN_USER_EMAIL + "=? AND " + COLUMN_USER_PASSWORD + "=?", selection);
        return cursor.getCount() > 0;
    }
    public boolean hasDuplicateUser(String email) {
        SQLiteDatabase database = this.getReadableDatabase();
        String selection[] = {email};
        Cursor cursor = database.rawQuery("select * from " + TABLE_USER + " where " + COLUMN_USER_EMAIL + "=?", selection);
        return cursor.getCount() != 0;
    }
    public String getUserFirstName(String email) {
        SQLiteDatabase database = this.getReadableDatabase();
        String selection[] = {email};
        String data = null;
        Cursor cursor = database.rawQuery(" select *  from " + TABLE_USER + " where " + COLUMN_USER_EMAIL + "=? ", selection);
        if (cursor.moveToFirst()) {
            do {
                data = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        return data;
    }

    public String getUserLastName(String email) {
        SQLiteDatabase database = this.getReadableDatabase();
        String selection[] = {email};
        String data = null;
        Cursor cursor = database.rawQuery(" select *  from " + TABLE_USER + " where " + COLUMN_USER_EMAIL + "=? ", selection);
        if (cursor.moveToFirst()) {
            do {
                data = cursor.getString(1);
            } while (cursor.moveToNext());
        }
        return data;
    }

}