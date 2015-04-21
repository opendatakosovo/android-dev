package com.example.gramos.raportiti;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "gps_coordinates.db";
    public static final String TABLE_COORDINATES = "coordinates";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_LAT = "lat";
    public static final String COLUMN_LNG = "lng";


    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_COORDINATES + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_LAT + " FLOAT," +
                COLUMN_LNG + " FLOAT" +

                " ); ";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    /**
    public String getDataTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }*/

    public void insertRecord(double lat, double lon){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LAT,  lat);
        values.put(COLUMN_LNG, lon);
        //values.put("timestamp", getDataTime());

        db.insert(TABLE_COORDINATES, null, values);
        db.close();
    }
    /**
    public void getAllCoordinates(){
        // Query table for all coordinates
        // Return list.
    }
    */
}
