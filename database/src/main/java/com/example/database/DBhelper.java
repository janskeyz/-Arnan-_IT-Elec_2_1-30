package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBhelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "my_database";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "my_table";

    public static final  String COLUMN_ID = "id";
    public static final  String COLUMN_NAME = "name";
    public static final  String COLUMN_AGE = "age";
    private static final String CREATE_TABLE =
            "CREATE TABLE" + TABLE_NAME + "(" +
                    COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_NAME + "TEXT," +
                    COLUMN_AGE + "INTEGER";
    public MyDatabaseHelper(Context context) {
        super(context);
    }

    }
