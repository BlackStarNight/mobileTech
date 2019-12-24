package com.blackapp.mobileteh;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATEBASE_NAME = "contactDb";
    public static final String TABLE_CONTACTS = "contacts";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_DATE = "date";


    public DBhelper(@Nullable Context context) {
        super(context, DATEBASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+ TABLE_CONTACTS + "(" + KEY_ID +
                " integer primary key autoincrement," + KEY_NAME + " text,"+ KEY_DATE + " text" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_CONTACTS);

        onCreate(sqLiteDatabase);
    }
}
