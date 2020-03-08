package com.example.widoki_list_adaptery_paski_aplikacji;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    public static final String EXTRA_ANIMAL="animalNO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        int animalNo=(Integer)getIntent().getExtras().get(EXTRA_ANIMAL);
        Animal animal=Animal.animals[animalNo];

        ImageView photo=findViewById(R.id.photo);
        photo.setImageResource(animal.getImageUrl());
        photo.setContentDescription(animal.getName());

        TextView name=findViewById(R.id.name);
        name.setText(animal.getName());

        TextView description=findViewById(R.id.description);
        description.setText("Jest to "+animal.getName()+". Ma on "+animal.getAge()+" lat.");
    }

}
