package com.example.ruthran13.globalcabs;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ruthran13 on 4/16/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Driver.db";
    public static final String TABLE_NAME = "Driver";
    public static final String COL_1 = "Name";
    public static final String COL_2 = "Password";
    public static final String COL_3 = "Email";

     public static final String COL_4 = "Age";
     public static final String COL_5 = "Experience";
     public static final String COL_6 = "User_Rating";
     public static final String COL_7 = "Bonus";

    SQLiteDatabase db = this.getWritableDatabase();

    private static DatabaseHelper sInstance;

    public static synchronized DatabaseHelper getHelper(Context context) {


        if (sInstance == null) {
            sInstance = new DatabaseHelper(context);
        }
        return sInstance;
    }



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + COL_2);
        db.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + COL_4);
        db.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + COL_5);
        db.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + COL_6);
        db.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + COL_7);

        onCreate(db);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        db.execSQL("create table " + TABLE_NAME + "(NAME TEXT, PASSWORD TEXT, EMAIL TEXT)");
    }



    public boolean insertData (String name, String password, String email){

        ContentValues contentvalues = new ContentValues();
        contentvalues.put(COL_1,name );
        contentvalues.put(COL_2, password);
        contentvalues.put(COL_3, email);

        long result = db.insert(TABLE_NAME, null, contentvalues);
        if (result == -1) {
            return false;
        }else {
            return true;
        }

    }


}
