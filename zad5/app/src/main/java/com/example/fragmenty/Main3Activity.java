package com.example.fragmenty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Main3Activity extends AppCompatActivity {
    public static final String EXTRA_PROGRAM_ID = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ProgramFragment programFragment= (ProgramFragment) getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        int id= (int) getIntent().getExtras().get(EXTRA_PROGRAM_ID);
        programFragment.setId(id);
    }
}
