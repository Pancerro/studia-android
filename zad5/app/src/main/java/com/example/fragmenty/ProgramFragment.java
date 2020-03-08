package com.example.fragmenty;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProgramFragment extends Fragment {

    public ProgramFragment() {
        // Required empty public constructor
    }

    private  long id;

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(savedInstanceState!=null) id=savedInstanceState.getLong("id");
        FragmentTransaction ft=getChildFragmentManager().beginTransaction();
        TextFragment textFragment=new TextFragment();
        ft.replace(R.id.text_container,textFragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
        return inflater.inflate(R.layout.fragment_program, container, false);
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putLong("id",id);
    }
    @Override
    public void onStart() {
        super.onStart();
        View view=getView();
        if(view!=null){
            TextView title=view.findViewById(R.id.tytul);
            Program program=Program.programs[(int)id];
            title.setText(program.getNazwa());
            TextView opis=view.findViewById(R.id.opis);
            opis.setText(program.getOpis());

        }
    }

}
