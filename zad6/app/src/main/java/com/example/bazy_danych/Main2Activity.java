package com.example.bazy_danych;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Main2Activity extends ListActivity {
    private SQLiteDatabase db;
    private Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listAnimal =getListView();
        try{
            SQLiteOpenHelper animalDateBaseHelper=new AnimalDatebaseHelper(this);
            db=animalDateBaseHelper.getReadableDatabase();
            cursor=db.query("ANIMAL",
                    new String[]{"_id","NAME"},null,null,null,null,null);
            CursorAdapter listAdapter=new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,cursor,new String[]{"NAME"},
            new int[]{android.R.id.text1},0);
            listAnimal.setAdapter(listAdapter);
        }  catch (SQLiteException e){
            Toast toast=Toast.makeText(this,"BAZA DANYCH JEST NIEDOSTEPNA",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    @Override
    public void onDestroy(){
        super.onDestroy();;
        cursor.close();
        db.close();
    }
    @Override
    public  void onListItemClick(ListView listView, View itemView,int position, long id){
        Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
        intent.putExtra(Main3Activity.EXTRA_ANIMAL,(int) id);
        startActivity(intent);
    }


}
