package com.example.bazy_danych;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AnimalDatebaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "animal"; // Nazwa bazy danych
    private static final int DB_VERSION = 1;
     AnimalDatebaseHelper(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }
    public  void upDatabase(SQLiteDatabase db,int old,int newV){
         if(old<1){
             db.execSQL("CREATE TABLE ANIMAL (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                     + "NAME TEXT,"
                     + "AGE TEXT, "
                     + "IMAGE_URL INTEGER);");
             insertAnimal(db,"Szynszyl","20",R.drawable.szynszyl);
             insertAnimal(db,"Pancernik","2 ",R.drawable.pancerro);
         }
         if(old<2){
            db.execSQL("ALTER TABLE ANIMAL ADD COLUMN FAVORITE NUMERIC;");
         }
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        upDatabase(db,0,DB_VERSION);

    }
    private static void insertAnimal(SQLiteDatabase db,String name, String age,int imageUrl){
        ContentValues contentValues=new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("AGE",age);
        contentValues.put("IMAGE_URL",imageUrl);
        db.insert("ANIMAL",null,contentValues);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        upDatabase(db,oldVersion,newVersion);
    }
}
