package com.example.aktywnosciiintencje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent dzialanie = getIntent();
        String znak=dzialanie.getStringExtra("dzialanie");
        TextView textView=findViewById(R.id.textView3);
        textView.setText(znak);
    }
    public  void onSendLiczby(View view){
        Intent dzialanie = getIntent();
        String znak=dzialanie.getStringExtra("dzialanie");
        Intent intent=new Intent(this,Main3Activity.class);
        EditText liczba1=findViewById(R.id.liczba1),liczba2=findViewById(R.id.liczba2);
        intent.putExtra("liczba1",liczba1.getText().toString());
        intent.putExtra("liczba2",liczba2.getText().toString());
        intent.putExtra("znak",znak);
        startActivity((intent));

    }
}

