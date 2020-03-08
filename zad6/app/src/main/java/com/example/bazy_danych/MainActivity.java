package com.example.bazy_danych;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private Cursor favoritesCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listView, View v, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }
            }
        };
        ListView listView = findViewById(R.id._dynamic);
        listView.setOnItemClickListener(itemClickListener);
        ListView listFavorites = findViewById(R.id.list_favorites);
        try {
            SQLiteOpenHelper animalDatebaseHelper = new AnimalDatebaseHelper(this);
            db = animalDatebaseHelper.getReadableDatabase();
            favoritesCursor = db.query("ANIMAL", new String[]{"_id", "NAME"},
                    "FAVORITE=1", null, null, null, null);
            CursorAdapter favoriteAdapter = new SimpleCursorAdapter(MainActivity.this, android.R.layout.simple_list_item_1, favoritesCursor,
                    new String[]{"NAME"}, new int[]{android.R.id.text1}, 0);
            listFavorites.setAdapter(favoriteAdapter);
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "BAZA DANYCH JEST NIEDOSTEPNA", Toast.LENGTH_SHORT);
        }
        listFavorites.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                intent.putExtra(Main3Activity.EXTRA_ANIMAL, (int) id);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        favoritesCursor.close();
        db.close();
    }

    @Override
    public void onRestart() {
     super.onRestart();
     try{
         AnimalDatebaseHelper animalDatebaseHelper=new AnimalDatebaseHelper(this);
         db=animalDatebaseHelper.getReadableDatabase();
         Cursor newCursor=db.query("ANIMAL",new String[]{"_id","NAME"},"FAVORITE=1",
                 null,null,null,null);
         ListView listView=findViewById(R.id.list_favorites);
         CursorAdapter adapter=(CursorAdapter) listView.getAdapter();
         adapter.changeCursor(newCursor);
         favoritesCursor=newCursor;
     } catch (SQLiteException e){
         Toast toast=Toast.makeText(this,"BAZA DANYCH JEST NIEDOSTEPNA",Toast.LENGTH_SHORT);
         toast.show();
     }
    }
}
