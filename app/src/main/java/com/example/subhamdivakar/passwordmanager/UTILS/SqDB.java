package com.example.subhamdivakar.passwordmanager.UTILS;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.subhamdivakar.passwordmanager.Bean.AlertSms;
import com.example.subhamdivakar.passwordmanager.Bean.ContactSaving;
import com.example.subhamdivakar.passwordmanager.Bean.EmailClass;
import com.example.subhamdivakar.passwordmanager.Bean.UserInfo;

import java.util.HashMap;

/**
 * Created by Subham Divakar on 7/13/2016.
 */
public class SqDB extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "bus.db";
    public static final int Version=1;

    public static final String busowner_TABLE_NAME = "bus_owner";
    public static final String USER_TABLE_NAME = "user_table";
    public static final String USER_INFO_TABLE = "user_info";
    public static final String busowner_INFO_TABLE_NAME = "bus_table";
    public static final String contact_INFO_TABLE_NAME = "con_table";


    public static final String USER_TABLE_COLUMN_NAME = "name";
    public static final String USER_TABLE_COLUMN_PHONE = "phone";

    public static final String USER_INFO_TABLE_COLUMN_NAME = "name";
    public static final String USER_INFO_TABLE_COLUMN_PHONE = "phone";
    public static final String USER_INFO_TABLE_COLUMN_ADDRESS = "address";


    public static final String busowner_INFO_TABLE_COLUMN_name = "owner_name";
    public static final String busowner_INFO_TABLE_COLUMN_busnum = "bus_num";
    public static final String busowner_INFO_TABLE_COLUMN_PHONE = "phone";
    public static final String busowner_INFO_TABLE_COLUMN_ADDRESS = "address";

    public static final String contact_INFO_TABLE_COLUMN_p1 = "p1";
    public static final String contact_INFO_TABLE_COLUMN_p2 = "p2";
    public static final String contact_INFO_TABLE_COLUMN_p3 = "p3";
    public static final String contact_INFO_TABLE_COLUMN_p4 = "p4";
    public static final String contact_INFO_TABLE_COLUMN_p5 = "p5";
    public static final String contact_INFO_TABLE_COLUMN_p6 = "p6";
    public static final String contact_INFO_TABLE_COLUMN_p7 = "p7";
    public static final String contact_INFO_TABLE_COLUMN_p8 = "p8";
    public static final String contact_INFO_TABLE_COLUMN_p9 = "p9";
    public static final String contact_INFO_TABLE_COLUMN_p10 = "p10";

    public static final String email_INFO_TABLE_COLUMN_p1 = "p1";
    public static final String email_INFO_TABLE_COLUMN_p2 = "p2";
    public static final String email_INFO_TABLE_COLUMN_p3 = "p3";
    public static final String email_INFO_TABLE_COLUMN_p4 = "p4";
    public static final String email_INFO_TABLE_COLUMN_p5 = "p5";
    public static final String email_INFO_TABLE_COLUMN_p6 = "p6";
    public static final String email_INFO_TABLE_COLUMN_p7 = "p7";
    public static final String email_INFO_TABLE_COLUMN_p8 = "p8";
    public static final String email_INFO_TABLE_COLUMN_p9 = "p9";
    public static final String email_INFO_TABLE_COLUMN_p10 = "p10";


    public static final String alert_INFO_TABLE_COLUMN_msg = "msg";



    public static final String busowner_TABLE_COLUMN_name = "owner_name";
    public static final String busowner_TABLE_COLUMN_busnum = "bus_num";
    public static final String busowner_TABLE_COLUMN_PHONE = "phone";

    private HashMap hp;

    public SqDB(Context context)
    {
        super(context, DATABASE_NAME , null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(
//                "create table USER_INFO_TABLE " +
//                        "(name text primary key, phone text,address text)"
//        );
//        db.execSQL(
//                "create table busowner_INFO_TABLE " +
//                        "(owner_name text primary key, phone text,bus_num text,address text)"
//        );
        db.execSQL(
                "create table contact_INFO_TABLE " +
                        "(p1 text primary key, p2 text,p3 text,p4 text,p5 text,p6 text,p7 text,p8 text,p9 text,p10 text)"
        );
        db.execSQL(
                "create table email_INFO_TABLE " +
                        "(p1 text primary key, p2 text,p3 text,p4 text,p5 text,p6 text,p7 text,p8 text,p9 text,p10 text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                if(newVersion>oldVersion)
               {
                    db.execSQL("DROP TABLE IF EXISTS contacts");
                    onCreate(db);
                }
    }
    public boolean insertPassword  (String p1, String p2, String p3, String p4,String p5,String p6,String p7,String p8,String p9,String p10)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p1", p1);//owner_name is the name as in field db.execSQL and same for all
        contentValues.put("p2", p2);
        contentValues.put("p3", p3);
        contentValues.put("p4", p4);
        contentValues.put("p5", p5);
        contentValues.put("p5", p6);
        contentValues.put("p5", p7);
        contentValues.put("p5", p8);
        contentValues.put("p5", p9);
        contentValues.put("p5", p10);

        db.insert("contact_INFO_TABLE", null, contentValues);
        return true;
    }


    public boolean insertEmail(String p1, String p2, String p3, String p4,String p5,String p6,String p7,String p8,String p9,String p10)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p1", p1);//owner_name is the name as in field db.execSQL and same for all
        contentValues.put("p2", p2);
        contentValues.put("p3", p3);
        contentValues.put("p4", p4);
        contentValues.put("p5", p5);
        contentValues.put("p5", p6);
        contentValues.put("p5", p7);
        contentValues.put("p5", p8);
        contentValues.put("p5", p9);
        contentValues.put("p5", p10);

        db.insert("email_INFO_TABLE", null, contentValues);
        return true;
    }





    public ContactSaving getPassword()
    {
        ContactSaving obj=new ContactSaving();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contact_INFO_TABLE", null );
        if( res.moveToNext())
        {
            obj.gmail=res.getString(res.getColumnIndex(contact_INFO_TABLE_COLUMN_p1)) ;
            obj.fb=res.getString(res.getColumnIndex(contact_INFO_TABLE_COLUMN_p2)) ;
            obj.twitter=res.getString(res.getColumnIndex(contact_INFO_TABLE_COLUMN_p3)) ;
            obj.paytm=res.getString(res.getColumnIndex(contact_INFO_TABLE_COLUMN_p4)) ;
            obj.uber=res.getString(res.getColumnIndex(contact_INFO_TABLE_COLUMN_p5)) ;
            obj.ola=res.getString(res.getColumnIndex(contact_INFO_TABLE_COLUMN_p6)) ;
            obj.microsoft=res.getString(res.getColumnIndex(contact_INFO_TABLE_COLUMN_p7)) ;
            obj.irctc=res.getString(res.getColumnIndex(contact_INFO_TABLE_COLUMN_p8)) ;
            obj.linkedin=res.getString(res.getColumnIndex(contact_INFO_TABLE_COLUMN_p9)) ;
            obj.phonepay=res.getString(res.getColumnIndex(contact_INFO_TABLE_COLUMN_p10)) ;
            return  obj;
        }
        return null;
    }

    public EmailClass getEmail()
    {
        EmailClass obj=new EmailClass();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from email_INFO_TABLE", null );
        if( res.moveToNext())
        {
            obj.gmail=res.getString(res.getColumnIndex(email_INFO_TABLE_COLUMN_p1)) ;
            obj.fb=res.getString(res.getColumnIndex(email_INFO_TABLE_COLUMN_p2)) ;
            obj.twitter=res.getString(res.getColumnIndex(email_INFO_TABLE_COLUMN_p3)) ;
            obj.paytm=res.getString(res.getColumnIndex(email_INFO_TABLE_COLUMN_p4)) ;
            obj.uber=res.getString(res.getColumnIndex(email_INFO_TABLE_COLUMN_p5)) ;
            obj.ola=res.getString(res.getColumnIndex(email_INFO_TABLE_COLUMN_p6)) ;
            obj.microsoft=res.getString(res.getColumnIndex(email_INFO_TABLE_COLUMN_p7)) ;
            obj.irctc=res.getString(res.getColumnIndex(email_INFO_TABLE_COLUMN_p8)) ;
            obj.linkedin=res.getString(res.getColumnIndex(email_INFO_TABLE_COLUMN_p9)) ;
            obj.phonepay=res.getString(res.getColumnIndex(email_INFO_TABLE_COLUMN_p10)) ;
            return  obj;
        }
        return null;
    }
}
