package com.kbt.dev.friendlyfire0;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kevin on 7/1/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "friendly_fire";
    private static final String MINES_TABLE_NAME = "mines";
    private static final String MINES_COLUMN_PLAYER = "player_phone_number";
    private static final String MINES_COLUMN_LATITUDE = "latitude";
    private static final String MINES_COLUMN_LONGITUDE = "longitude";
    private static final String MINES_COLUMN_PLANTED = "time_planted";
    private static final String MINES_COLUMN_EXPLODED = "time_exploded";
    private static final String MINES_TABLE_CREATE =
            "CREATE TABLE IF NOT EXISTS" + MINES_TABLE_NAME + " (" +
                    MINES_COLUMN_PLAYER + " TEXT," +
                    MINES_COLUMN_LATITUDE + " REAL," +
                    MINES_COLUMN_LONGITUDE + " REAL," +
                    MINES_COLUMN_PLANTED + "TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                    MINES_COLUMN_EXPLODED + "TIMESTAMP);";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MINES_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + MINES_TABLE_NAME);
        onCreate(db);

    }
}
