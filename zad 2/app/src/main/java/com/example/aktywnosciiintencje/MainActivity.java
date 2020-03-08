package com.example.aktywnosciiintencje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void onSendMessage(View view){
        Intent intent=new Intent(this,Main2Activity.class);
        intent.setType("text/plain");
        Spinner dzialanie=findViewById(R.id.spinner);
        String znak=dzialanie.getSelectedItem().toString();
        intent.putExtra("dzialanie",znak);
        startActivity((intent));
    }
}
