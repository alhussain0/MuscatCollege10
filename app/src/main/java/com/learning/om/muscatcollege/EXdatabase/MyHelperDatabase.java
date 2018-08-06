package com.learning.om.muscatcollege.EXdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.learning.om.muscatcollege.teacher_profile.TeacherProfileNew;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MyHelperDatabase extends SQLiteOpenHelper {

    private ArrayList<TeacherProfileNew> teacherProfile;
    private TeacherProfileNew mTeacher;

    private SQLiteDatabase sqLiteDatabase;

    private static final String DATABASE_NAME = "teacherProfile.db";
    private static final String TABLE_NAME = "teacherProfile";
    private static final String NAME = "name";
    private static final String SPE = "specialization";
    private static final String ADDRESS = "address";
    private static final String PHOTO ="photo";
    //this culomn is required to display the data in list view
    private static final String ID= "_id";
    //version will be used to do any modification in the existing table
    private static final int VERSION =2;

    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" +ID + " integer primary key autoincrement,"+NAME+" text not null," + SPE
            + " text not null," + ADDRESS +" text not null,"+ PHOTO +" BLOB not null"+");";


//    private TeacherProfileNew teacherProfileNew ;

    public MyHelperDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
//        sqLiteDatabase.execSQL(CREATE_TABLE);
//        sqLiteDatabase.execSQL(CREATE_TABLE);
//        sqLiteDatabase.execSQL(CREATE_TABLE);
        //if you have more than one table just write the last statement for another table
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        //if you want to add tables

//        if(newVersion==2){
//            sqLiteDatabase.execSQL("alter table ");
//        }
//        if(newVersion == 3){
            sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME);
            onCreate(sqLiteDatabase);
//        }
    }

    public long  insertTeacherProfile(TeacherProfileNew teacherProfileNew){
        sqLiteDatabase = getWritableDatabase();
        byte[] image = getBitmapAsByteArray(teacherProfileNew.getImage());

        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, teacherProfileNew.getName());
        contentValues.put(SPE, teacherProfileNew.getSpecialization());
        contentValues.put(ADDRESS, teacherProfileNew.getAddress());

        //check above image variable
        contentValues.put(PHOTO,image);

        long l = sqLiteDatabase.insert(TABLE_NAME,null ,contentValues);
        return l;


    }

    public  static  byte[] getBitmapAsByteArray (Bitmap bitmap){

        ByteArrayOutputStream outputStream  =new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,0,outputStream);
        return outputStream.toByteArray();

    }

    public ArrayList<TeacherProfileNew> getAllTheTeacher (){
        teacherProfile = new ArrayList<>();
        String sql = "select * from " + TABLE_NAME;

        sqLiteDatabase= getReadableDatabase();

        Cursor data = sqLiteDatabase.rawQuery(sql,null);

        if(data.moveToFirst()){
            do{
                mTeacher = new TeacherProfileNew();
                Bitmap bitmap = BitmapFactory.decodeByteArray(data.getBlob(data.getColumnIndex(PHOTO)),0,data.getBlob(data.getColumnIndex(PHOTO)).length);
                mTeacher.setImage(bitmap);
                mTeacher.setName(data.getString(data.getColumnIndex(NAME)));
                mTeacher.setSpecialization(data.getString(data.getColumnIndex(SPE)));
                mTeacher.setAddress(data.getString(data.getColumnIndex(ADDRESS)));
                teacherProfile.add(mTeacher);

            }while (data.moveToNext());

        }
        return teacherProfile;
        
    }

    public void  deleteTeacherProfile (int id){}

    public void  updateSingleTeacher (int id){}

}
