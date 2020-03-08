package com.example.aktywnosciiintencje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent=getIntent();
        TextView wynik=findViewById(R.id.textView);
        String dzialanie=intent.getStringExtra("znak"),liczba=intent.getStringExtra("liczba1"),liczba0=intent.getStringExtra("liczba2");
        int obliczenia=0,liczba1=Integer.parseInt(liczba),liczba2=Integer.parseInt(liczba0);
        switch (dzialanie){
            case "+": obliczenia=liczba1+liczba2; break;
            case "-": obliczenia=liczba1-liczba2; break;
            case "/": obliczenia=liczba1/liczba2; break;
            case "*": obliczenia=liczba1*liczba2; break;
            case "^": obliczenia= (int)Math.pow((double)liczba1,(double)liczba2); break;
            default: wynik.setText("Bład");
        }
        StringBuilder liczenie = new StringBuilder();
        liczenie.append(obliczenia);
        wynik.setText(liczenie);
        Intent sendWynik= new Intent(Intent.ACTION_SEND);
        sendWynik.setType("text/plain");
        sendWynik.putExtra(Intent.EXTRA_TEXT,liczenie.toString());
        Intent chosenIntent=Intent.createChooser(sendWynik,"Wyslij wynik");
        startActivity(chosenIntent);
    }
}
