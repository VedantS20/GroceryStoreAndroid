package com.vedant.fragdrawer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public final static String DATABASE_NAME = "User.db";
    public final static String TABLE_NAME = "user_table";
    public final static String COL_1 = "ID";
    public final static String COL_2 = "NAME";
    public final static String COL_3 = "PASSWORD";
    private static final String[] COLUMNS = {COL_1, COL_2, COL_3};

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "
                + TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " NAME TEXT," +
                " PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
//
//    public long insertDta(String name, String password) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL_2, name);
//        contentValues.put(COL_3, password);
//        long result = db.insert(TABLE_NAME, null, contentValues);
//        db.close();
//        return result;
//    }


    public int updateUser(User player) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2, player.getName());
        values.put(COL_3, player.getPassword());

        int i = db.update(TABLE_NAME, // table
                values, // column/value
                "id = ?", // selections
                new String[]{String.valueOf(player.getId())});

        db.close();

        return i;
    }

//    public boolean updateData( String id , String name, String password) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//      contentValues.put(COL_1, id);
//        contentValues.put(COL_2, name);
//        contentValues.put(COL_3, password);
//        db.update(TABLE_NAME, contentValues, "ID=?", new String[]{name});
//        return true;
//    }

    public User getuser(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME, COLUMNS, " id = ?", new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        User user = new User();
        user.setId(Integer.parseInt(cursor.getString(0)));
        user.setName(cursor.getString(1));
        user.setPassword(cursor.getString(2));

        return user;
    }
//    public Cursor getData(String id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        String query = "SELECT * FROM " + TABLE_NAME + " WHERE ID='" + id + "'";
//        Cursor cursor = db.rawQuery(query, null);
//        return cursor;
//    }

    public void deleteuser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "ID=?", new String[]{String.valueOf(user.getId())});
    }

    //    public Integer deleteData(String id) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        return db.delete(TABLE_NAME, "ID=?", new String[]{id});
//    }
    public List<User> allusers() {

        List<User> users = new LinkedList<User>();
        String query = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        User user = null;

        if (cursor.moveToFirst()) {
            do {
                user = new User();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setName(cursor.getString(1));
                user.setPassword(cursor.getString(2));
                users.add(user);
            } while (cursor.moveToNext());
        }

        return users;
    }

    //    public Cursor getAllData() {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
//        return cursor;
//    }
    public boolean addUser(User user) {
        boolean result =true;
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COL_2, user.getName());
            values.put(COL_3, user.getPassword());
            // insert
            db.insert(TABLE_NAME, null, values);
            db.close();
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

//    public boolean checkuser(String name, String password) {
//        String[] columns = {COL_1};
//        SQLiteDatabase db = getReadableDatabase();
//        String selection = COL_2 + "=?" + " and " + COL_3 + "=?";
//        String[] selectionArgs = {name, password};
//        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
//        int count = cursor.getCount();
//        cursor.close();
//        db.close();
//        if (count > 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public User CheckUser(String name, String password) {
        User user = null;
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " +TABLE_NAME + " where name=? and password=?",new String[]{name , password});
        if(cursor.moveToFirst()){
             user = new User();
            user.setId(cursor.getInt(0));
            user.setName(cursor.getString(1));
            user.setPassword(cursor.getString(2));
        }
        return user;
    }
    public User CheckUsername(String name) {
        User user = null;
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from " +TABLE_NAME + " where name=?",new String[]{name});
        if(cursor.moveToFirst()){
            user = new User();
            user.setId(cursor.getInt(0));
            user.setName(cursor.getString(1));
            user.setPassword(cursor.getString(2));
        }
        return user;
    }
//    public boolean CheckUser(User user)
//    {
//        String[] columns = {COL_1};
//        SQLiteDatabase db = getReadableDatabase();
//        String selection = COL_2 + "=?" + " and " + COL_3 + "=?";
//        String[] selectionArgs = {user.getName(),user.getPassword()};
//        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
//        int count = cursor.getCount();
//        cursor.close();
//        db.close();
//        if (count > 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }
}

