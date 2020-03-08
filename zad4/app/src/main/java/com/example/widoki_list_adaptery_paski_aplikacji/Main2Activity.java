package com.example.widoki_list_adaptery_paski_aplikacji;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main2Activity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listAnimal =getListView();
        ArrayAdapter<Animal> listAdapter=new ArrayAdapter<Animal>(
                this,
                android.R.layout.simple_list_item_1,
                Animal.animals);
        listAnimal.setAdapter(listAdapter);
    }
    @Override
    public  void onListItemClick(ListView listView, View itemView,int position, long id){
        Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
        intent.putExtra(Main3Activity.EXTRA_ANIMAL,(int) id);
        startActivity(intent);
    }


}
