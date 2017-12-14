package com.example.win81.project_advertinn_v2.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.win81.project_advertinn_v2.db.DBHelper;
import com.example.win81.project_advertinn_v2.dto.User;

import java.util.ArrayList;

/**
 * Created by Win 8.1 on 07/12/2017.
 */

public class UserController {
    DBHelper helper;
    Context context;

    public UserController(Context context) {
        this.context = context;
        helper=new DBHelper(context,DBHelper.DBNAME,null, DBHelper.VERSION);
    }

    public boolean saveUser(User u)
    {
        SQLiteDatabase db= helper.getWritableDatabase();
        ContentValues cv=new ContentValues();
        try{
            cv.put(DBHelper.COL1,u.getUserId());
            cv.put(DBHelper.COL2,u.getName());
            cv.put(DBHelper.COL3,u.getEmail());
            cv.put(DBHelper.COL4,u.getMobileNumber());
            cv.put(DBHelper.COL5,u.getPassword());
            db.insert(DBHelper.TNAME,null,cv);
            db.close();
        }
        catch (Exception e)
        {
            return false;
        }

        return true;
    }
    public User showUser(String email)
    {
        SQLiteDatabase db= helper.getReadableDatabase();
        try {
            Cursor c= db.query(DBHelper.TNAME,null,DBHelper.COL3+"=?",
                    new String[]{email},null,null,null);
            //   Cursor c =  db.rawQuery( "select * from tblUser where email="+email+"", null );
            if(c!=null)
            {
                c.moveToFirst();

                int userId=c.getInt(0);
                String uName=c.getString(1);
                String uEmail=c.getString(2);
                String uMobile=c.getString(3);
                String uPassword=c.getString(4);
                User u=new User(userId,uName,uEmail,uPassword,uMobile);
                return u;
            }
        }
        catch (Exception e)
        {
            return null;
        }

        return null;
    }

    public ArrayList<User> showAllUser()
    {
        String uName,uEmail,uPass,uMobile;
        int uID;
        ArrayList<User> arrayList=new ArrayList<>();
        SQLiteDatabase db=helper.getReadableDatabase();
        try{
            Cursor c= db.query(DBHelper.TNAME,null,null,null,null,null,null);
            while (c.moveToNext())
            {
                uID=c.getInt(0);
                uName=c.getString(1);
                uEmail=c.getString(2);
                uMobile=c.getString(3);
                uPass=c.getString(4);
                User e=new User(uID,uName,uEmail,uPass,uMobile);
                arrayList.add(e);
            }
            return arrayList;
        }
        catch (Exception e)
        {
            return null;
        }


    }
}
