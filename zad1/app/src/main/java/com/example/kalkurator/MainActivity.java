package com.example.kalkurator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickLicz(View view){
        TextView wynik=findViewById(R.id.wynik);
        Spinner  liczba=findViewById(R.id.spinner),liczba0=findViewById(R.id.spinner2),typ=findViewById(R.id.spinner3);
        String dzialanie=String.valueOf(typ.getSelectedItem());
        int obliczenia=0,liczba1=Integer.parseInt(liczba.getSelectedItem().toString()),liczba2=Integer.parseInt(liczba0.getSelectedItem().toString());
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
    }
}
