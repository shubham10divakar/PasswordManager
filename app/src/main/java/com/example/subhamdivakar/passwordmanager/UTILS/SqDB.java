package com.example.subhamdivakar.passwordmanager.UTILS;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.subhamdivakar.passwordmanager.Bean.ContactSaving;
import com.example.subhamdivakar.passwordmanager.Bean.EmailClass;

import java.util.HashMap;

/**
 * Created by Subham Divakar on 7/13/2016.
 */
public class SqDB extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "passwrap.db";
    public static final int Version=1;


    public static final String contact1_INFO_TABLE_COLUMN_p1 = "p1";
    public static final String contact2_INFO_TABLE_COLUMN_p2 = "p2";
    public static final String contact3_INFO_TABLE_COLUMN_p3 = "p3";
    public static final String contact4_INFO_TABLE_COLUMN_p4 = "p4";
    public static final String contact5_INFO_TABLE_COLUMN_p5 = "p5";
    public static final String contact6_INFO_TABLE_COLUMN_p6 = "p6";
    public static final String contact7_INFO_TABLE_COLUMN_p7 = "p7";
    public static final String contact8_INFO_TABLE_COLUMN_p8 = "p8";
    public static final String contact9_INFO_TABLE_COLUMN_p9 = "p9";
    public static final String contact10_INFO_TABLE_COLUMN_p10 = "p10";

    public static final String email1_INFO_TABLE_COLUMN_p1 = "p1";
    public static final String email2_INFO_TABLE_COLUMN_p2 = "p2";
    public static final String email3_INFO_TABLE_COLUMN_p3 = "p3";
    public static final String email4_INFO_TABLE_COLUMN_p4 = "p4";
    public static final String email5_INFO_TABLE_COLUMN_p5 = "p5";
    public static final String email6_INFO_TABLE_COLUMN_p6 = "p6";
    public static final String email7_INFO_TABLE_COLUMN_p7 = "p7";
    public static final String email8_INFO_TABLE_COLUMN_p8 = "p8";
    public static final String email9_INFO_TABLE_COLUMN_p9 = "p9";
    public static final String email10_INFO_TABLE_COLUMN_p10 = "p10";

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
                "create table contact1_INFO_TABLE " +
                        "(p1 text primary key)"
        );
        db.execSQL(
                "create table contact2_INFO_TABLE " +
                        "(p2 text primary key)"
        );
        db.execSQL(
                "create table contact3_INFO_TABLE " +
                        "(p3 text primary key)"
        );
        db.execSQL(
                "create table contact4_INFO_TABLE " +
                        "(p4 text primary key)"
        );
        db.execSQL(
                "create table contact5_INFO_TABLE " +
                        "(p5 text primary key)"
        );
        db.execSQL(
                "create table contact6_INFO_TABLE " +
                        "(p6 text primary key)"
        );
        db.execSQL(
                "create table contact7_INFO_TABLE " +
                        "(p7 text primary key)"
        );
        db.execSQL(
                "create table contact8_INFO_TABLE " +
                        "(p8 text primary key)"
        );
        db.execSQL(
                "create table contact9_INFO_TABLE " +
                        "(p9 text primary key)"
        );
        db.execSQL(
                "create table contact10_INFO_TABLE " +
                        "(p10 text primary key)"
        );


        db.execSQL(
                "create table email1_INFO_TABLE " +
                        "(p1 text primary key)"
        );
        db.execSQL(
                "create table email2_INFO_TABLE " +
                        "(p2 text primary key)"
        );db.execSQL(
                "create table email3_INFO_TABLE " +
                        "(p3 text primary key)"
        );db.execSQL(
                "create table email4_INFO_TABLE " +
                        "(p4 text primary key)"
        );db.execSQL(
                "create table email5_INFO_TABLE " +
                        "(p5 text primary key)"
        );db.execSQL(
                "create table email6_INFO_TABLE " +
                        "(p6 text primary key)"
        );db.execSQL(
                "create table email7_INFO_TABLE " +
                        "(p7 text primary key)"
        );db.execSQL(
                "create table email8_INFO_TABLE " +
                        "(p8 text primary key)"
        );db.execSQL(
                "create table email9_INFO_TABLE " +
                        "(p9 text primary key)"
        );db.execSQL(
                "create table email10_INFO_TABLE " +
                        "(p10 text primary key)"
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
    public boolean insertPassword1(String p1)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        
        ContentValues contentValues = new ContentValues();
        contentValues.put("p1", p1);//owner_name is the name as in field db.execSQL and same for all
        db.insert("contact1_INFO_TABLE", null, contentValues);
        return true;
    }
    public boolean insertPassword2(String p2)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p2", p2);//owner_name is the name as in field db.execSQL and same for all
        db.insert("contact2_INFO_TABLE", null, contentValues);
        return true;
    }
    public boolean insertPassword3(String p3)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p3", p3);//owner_name is the name as in field db.execSQL and same for all
        db.insert("contact3_INFO_TABLE", null, contentValues);
        return true;
    }
    public boolean insertPassword4(String p4)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p4", p4);//owner_name is the name as in field db.execSQL and same for all
        db.insert("contact4_INFO_TABLE", null, contentValues);
        return true;
    }
    public boolean insertPassword5(String p5)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p5", p5);//owner_name is the name as in field db.execSQL and same for all
        db.insert("contact5_INFO_TABLE", null, contentValues);
        return true;
    }
    public boolean insertPassword6(String p6)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p6", p6);//owner_name is the name as in field db.execSQL and same for all
        db.insert("contact6_INFO_TABLE", null, contentValues);
        return true;
    }
    public boolean insertPassword7(String p7)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p7", p7);//owner_name is the name as in field db.execSQL and same for all
        db.insert("contact7_INFO_TABLE", null, contentValues);
        return true;
    }
    public boolean insertPassword8(String p8)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p8", p8);//owner_name is the name as in field db.execSQL and same for all
        db.insert("contact8_INFO_TABLE", null, contentValues);
        return true;
    }
    public boolean insertPassword9(String p9)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p9", p9);//owner_name is the name as in field db.execSQL and same for all
        db.insert("contact9_INFO_TABLE", null, contentValues);
        return true;
    }
    public boolean insertPassword10(String p10)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p10", p10);//owner_name is the name as in field db.execSQL and same for all
        db.insert("contact10_INFO_TABLE", null, contentValues);
        return true;
    }


    public boolean insertEmail1(String p1)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p1", p1);//owner_name is the name as in field db.execSQL and same for all
        db.insert("email1_INFO_TABLE", null, contentValues);
        return true;
    }
    public boolean insertEmail2(String p2)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p2", p2);
        db.insert("email2_INFO_TABLE", null, contentValues);
        return true;
    }
    public boolean insertEmail3(String p3)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p3", p3);
        db.insert("email3_INFO_TABLE", null, contentValues);
        return true;
    }
    public boolean insertEmail4(String p4)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p4", p4);
        db.insert("email4_INFO_TABLE", null, contentValues);
        return true;
    }
    public boolean insertEmail5(String p5)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p5", p5);
        db.insert("email5_INFO_TABLE", null, contentValues);
        return true;
    }
    public boolean insertEmail6(String p6)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p6", p6);
        db.insert("email6_INFO_TABLE", null, contentValues);
        return true;
    }
    public boolean insertEmail7(String p7)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p7", p7);
        db.insert("email7_INFO_TABLE", null, contentValues);
        return true;
    }
    public boolean insertEmail8(String p8)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p8", p8);
        db.insert("email8_INFO_TABLE", null, contentValues);
        return true;
    }
    public boolean insertEmail9(String p9)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p9", p9);
        db.insert("email9_INFO_TABLE", null, contentValues);
        return true;
    }
    public boolean insertEmail10(String p10)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("p10", p10);
        db.insert("email10_INFO_TABLE", null, contentValues);
        return true;
    }





    public ContactSaving getPassword1()
    {
        ContactSaving obj=new ContactSaving();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contact1_INFO_TABLE", null );
        if( res.moveToNext())
        {
            obj.gmail=res.getString(res.getColumnIndex(contact1_INFO_TABLE_COLUMN_p1)) ;
            return  obj;
        }

        return null;
    }public ContactSaving getPassword2()
    {
        ContactSaving obj=new ContactSaving();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contact2_INFO_TABLE", null );
        if( res.moveToNext())
        {
            obj.fb=res.getString(res.getColumnIndex(contact2_INFO_TABLE_COLUMN_p2)) ;
            return  obj;
        }

        return null;
    }
    public ContactSaving getPassword3()
    {
        ContactSaving obj=new ContactSaving();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contact3_INFO_TABLE", null );
        if( res.moveToNext())
        {
            obj.twitter=res.getString(res.getColumnIndex(contact3_INFO_TABLE_COLUMN_p3)) ;
            return  obj;
        }

        return null;
    }
    public ContactSaving getPassword4()
    {
        ContactSaving obj=new ContactSaving();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contact4_INFO_TABLE", null );
        if( res.moveToNext())
        {
            obj.paytm=res.getString(res.getColumnIndex(contact4_INFO_TABLE_COLUMN_p4)) ;
            return  obj;
        }

        return null;
    }
    public ContactSaving getPassword5()
    {
        ContactSaving obj=new ContactSaving();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contact5_INFO_TABLE", null );
        if( res.moveToNext())
        {
            obj.uber=res.getString(res.getColumnIndex(contact5_INFO_TABLE_COLUMN_p5)) ;
            return  obj;
        }

        return null;
    }
    public ContactSaving getPassword6()
    {
        ContactSaving obj=new ContactSaving();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contact6_INFO_TABLE", null );
        if( res.moveToNext())
        {
            obj.ola=res.getString(res.getColumnIndex(contact6_INFO_TABLE_COLUMN_p6)) ;
            return  obj;
        }

        return null;
    }
    public ContactSaving getPassword7()
    {
        ContactSaving obj=new ContactSaving();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contact7_INFO_TABLE", null );
        if( res.moveToNext())
        {
            obj.microsoft=res.getString(res.getColumnIndex(contact7_INFO_TABLE_COLUMN_p7)) ;
            return  obj;
        }

        return null;
    }
    public ContactSaving getPassword8()
    {
        ContactSaving obj=new ContactSaving();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contact8_INFO_TABLE", null );
        if( res.moveToNext())
        {
            obj.irctc=res.getString(res.getColumnIndex(contact8_INFO_TABLE_COLUMN_p8)) ;
            return  obj;
        }

        return null;
    }
    public ContactSaving getPassword9()
    {
        ContactSaving obj=new ContactSaving();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contact9_INFO_TABLE", null );
        if( res.moveToNext())
        {
            obj.linkedin=res.getString(res.getColumnIndex(contact9_INFO_TABLE_COLUMN_p9)) ;
            return  obj;
        }

        return null;
    }
    public ContactSaving getPassword10()
    {
        ContactSaving obj=new ContactSaving();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contact10_INFO_TABLE", null );
        if( res.moveToNext())
        {
            obj.phonepay=res.getString(res.getColumnIndex(contact10_INFO_TABLE_COLUMN_p10)) ;
            return  obj;
        }

        return null;
    }
    public EmailClass getEmail1()
    {
        EmailClass obj=new EmailClass();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from email1_INFO_TABLE", null );
        if( res.moveToNext())
        {
            obj.gmail=res.getString(res.getColumnIndex(email1_INFO_TABLE_COLUMN_p1)) ;
            return  obj;
        }
        return null;
    }
    public EmailClass getEmail2()
    {
        EmailClass obj=new EmailClass();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from email2_INFO_TABLE", null );
        if( res.moveToNext())
        {
            obj.fb=res.getString(res.getColumnIndex(email2_INFO_TABLE_COLUMN_p2)) ;
            return  obj;
        }
        return null;
    }public EmailClass getEmail3()
    {
        EmailClass obj=new EmailClass();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from email3_INFO_TABLE", null );
        if( res.moveToNext())
        {
            obj.twitter=res.getString(res.getColumnIndex(email3_INFO_TABLE_COLUMN_p3)) ;
            return  obj;
        }
        return null;
    }public EmailClass getEmail4()
    {
        EmailClass obj=new EmailClass();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from email4_INFO_TABLE", null );
        if( res.moveToNext())
        {
            obj.paytm=res.getString(res.getColumnIndex(email4_INFO_TABLE_COLUMN_p4)) ;
            return  obj;
        }
        return null;
    }public EmailClass getEmail5()
    {
        EmailClass obj=new EmailClass();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from email5_INFO_TABLE", null );
        if( res.moveToNext())
        {
            obj.uber=res.getString(res.getColumnIndex(email5_INFO_TABLE_COLUMN_p5)) ;
            return  obj;
        }
        return null;
    }public EmailClass getEmail6()
    {
        EmailClass obj=new EmailClass();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from email6_INFO_TABLE", null );
        if( res.moveToNext())
        {

            obj.ola=res.getString(res.getColumnIndex(email6_INFO_TABLE_COLUMN_p6)) ;
            return  obj;
        }
        return null;
    }public EmailClass getEmail7()
    {
        EmailClass obj=new EmailClass();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from email7_INFO_TABLE", null );
        if( res.moveToNext())
        {
            obj.microsoft=res.getString(res.getColumnIndex(email7_INFO_TABLE_COLUMN_p7)) ;
            return  obj;
        }
        return null;
    }public EmailClass getEmail8()
    {
        EmailClass obj=new EmailClass();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from email8_INFO_TABLE", null );
        if( res.moveToNext())
        {
            obj.irctc=res.getString(res.getColumnIndex(email8_INFO_TABLE_COLUMN_p8)) ;
            return  obj;
        }
        return null;
    }public EmailClass getEmail9()
    {
        EmailClass obj=new EmailClass();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from email9_INFO_TABLE", null );
        if( res.moveToNext())
        {
            obj.linkedin=res.getString(res.getColumnIndex(email9_INFO_TABLE_COLUMN_p9)) ;
            return  obj;
        }
        return null;
    }public EmailClass getEmail10()
    {
        EmailClass obj=new EmailClass();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from email10_INFO_TABLE", null );
        if( res.moveToNext())
        {
            obj.phonepay=res.getString(res.getColumnIndex(email10_INFO_TABLE_COLUMN_p10)) ;
            return  obj;
        }
        return null;
    }
}
