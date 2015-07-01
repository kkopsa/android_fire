package com.kbt.dev.friendlyfire0;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kevin on 7/1/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "friendly_fire";
    private static final String MINE_TABLE_NAME = "mine_coordinates";
    private static final String MINE_COLUMN_1 = "longitude";
    private static final String MINE_COLUMN_2 = "latitude";
    private static final String MINE_TABLE_CREATE =
            "CREATE TABLE " + MINE_TABLE_NAME + " (" +
                    MINE_COLUMN_1 + " REAL, " +
                    MINE_COLUMN_2 + " REAL);";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MINE_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
