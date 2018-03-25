package school.zx.newboston.demo.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by THink on 2018/3/24.
 */

public class DbHandle extends SQLiteOpenHelper {

    //Set up variables for database name, table name, column name
    private static final int DATABASE_VERSION = 1;//The very first time we are creating this database;whenever you update you database, you have to upgrade the verison as well
    private static final String DATABASE_NAME = "product.db";//Make sure you type the db extension that tells studio there is a database stored here
    public static final String TABLE_PRODUCTS = "products";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCTNAME = "productname";

    public DbHandle(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);//Pass information along to the super class which works directly with android  and takes care of all the behind the scene staff for sql
    }

    @Override
    //whenever you create this table first time, call the code below
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_PRODUCTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PRODUCTNAME + " TEXT " +
                ");";
        db.execSQL(query);
    }

    //whenever you upgrade the version, call the code below
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }

    //Adding a new row
    public void addProduct(Products product) {
        ContentValues values = new ContentValues();//contentvalues methods allows users to set up different values for different columns, they allows you to insert them in one statement

        values.put(COLUMN_PRODUCTNAME, product.get_productname());
        SQLiteDatabase db = getWritableDatabase();//db is equal to the database we are going to write through
        db.insert(TABLE_PRODUCTS, null, values);//Insert a new row into your table
        db.close();
    }

    //Delete a row
    public void deleteProduct(String productName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME + "=\"" + productName + "\";");
    }
    //Take the database and convert it to a string

    public String databaseToString() {
        String dbSrting = "";//Store the string
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE 1";//1 MEANS EVERY CONDITION IS MATCHED

        //CURSOR point to a location in your result
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //loops through each row in your database
        while (!c.isAfterLast()) {//It is not positioned after the last row//make sure you still have some result
            if (c.getString(c.getColumnIndex("productname")) != null) {
                dbSrting += c.getString(c.getColumnIndex("productname"));
                dbSrting += "\n";
            }
            //pointer must move
            c.moveToNext();
        }

        db.close();
        return dbSrting;
    }
}