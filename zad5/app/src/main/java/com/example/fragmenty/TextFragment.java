package com.example.fragmenty;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class TextFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout=inflater.inflate(R.layout.fragment_text,container,false);
        Button button=layout.findViewById(R.id.button);
        button.setOnClickListener(this);
        // Inflate the layout for this fragment
        return layout;

    }

    @Override
    public void onStart() {
        super.onStart();
        View view=getView();
            TextView text=view.findViewById(R.id.textView);
            text.setText("UDA CI SIE TEGO NAUCZYC! PROGRAMOWANIE NIE JEST TAKIE CIEZKIE");

    }
     public void zmienTekst(View view){
         Toast.makeText(view.getContext(), "NIE OD RAZU RZYM ZBUDOWANO", Toast.LENGTH_SHORT).show();
     }

    @Override
    public void onClick(View v) {
         zmienTekst(v);
    }
}
