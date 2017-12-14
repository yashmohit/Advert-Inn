package com.example.win81.project_advertinn_v2.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Win 8.1 on 07/12/2017.
 */

public class DBHelper  extends SQLiteOpenHelper{

    public static final String DBNAME="dbAdvertInn";
    public static final String TNAME="tblUser";
    public static final String COL1="tblUserID";
    public static final String COL2="name";
    public static final String COL3="email";
    public static final String COL4="mobileNumber";
    public static final String COL5="password";
    public static final int VERSION=1;
    Context con;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        con=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table tblUser(tblUserID integer primary key ,name varchar(50),email varchar(50),mobileNumber varchar(50),password varchar(50))");
       // Toast.makeText(con,"Table Created",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
