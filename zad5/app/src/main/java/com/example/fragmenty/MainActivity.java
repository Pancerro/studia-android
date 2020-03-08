package com.example.fragmenty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements ProgramListFragment.ProgramListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainer=findViewById(R.id.fragment_container);
        if(fragmentContainer!=null) {
            ProgramFragment programFragment = new ProgramFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            programFragment.setId(id);
            fragmentTransaction.replace(R.id.fragment_container, programFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        } else{
            Intent intent=new Intent(this,Main3Activity.class);
            intent.putExtra(Main3Activity.EXTRA_PROGRAM_ID,(int)id);
            startActivity(intent);
        }
    }
}
