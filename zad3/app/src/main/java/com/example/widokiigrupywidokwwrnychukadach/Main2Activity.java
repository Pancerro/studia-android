package com.example.widokiigrupywidokwwrnychukadach;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void  kliczek(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void toast(View view){
        CharSequence text="Dzieki za klikniecie";
        int duration= Toast.LENGTH_SHORT;

        Toast toast=Toast.makeText(this,text,duration);
        toast.show();
    }
    public  void onoff(View view){
        Spinner spinner=findViewById(R.id.spinner);

        boolean on=((ToggleButton) view).isChecked();
        if(on){
            spinner.setEnabled(true);
        }
        else {
            spinner.setEnabled(false);
        }
    }
    public  void wlacznik(View view){
        boolean on=((Switch)view).isChecked();
        RadioButton przelacznik=findViewById(R.id.radioButton),przelacznik2=findViewById(R.id.radioButton2);
        if(on){
            przelacznik.toggle();
            checkRadio(view);
        }
        else {
            przelacznik2.toggle();
            checkRadio(view);
        }
    }
    public  void check(View view){
        CharSequence text="Odznaczone";
        int duration= Toast.LENGTH_SHORT;
        boolean checkBox= ((CheckBox)view).isChecked();
        switch (view.getId()){
            case R.id.checkBox: if(checkBox) text="zielony"; break;
            case R.id.checkBox2: if(checkBox) text="czerwony";break;
            case R.id.checkBox3: if(checkBox) text="zolty";break;
        }
        Toast toast=Toast.makeText(this,text,duration);
        toast.show();
    }
    public void  checkRadio(View view){
        Button button=findViewById(R.id.button2);
        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.radioGroup2);
        int id=radioGroup.getCheckedRadioButtonId();
        switch (id){
            case R.id.radioButton: button.setBackgroundColor(Color.RED); break;
            case R.id.radioButton2: button.setBackgroundColor(Color.BLACK); break;
        }
    }
}
