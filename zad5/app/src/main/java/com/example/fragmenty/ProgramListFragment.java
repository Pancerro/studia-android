package com.example.fragmenty;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProgramListFragment extends ListFragment {
    static interface ProgramListListener{
        void itemClicked(long id);
    }
    private ProgramListListener listListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listListener=(ProgramListListener)context;
    }
    @Override
    public void onListItemClick(ListView l,View v,int position,long id){
        if(listListener!=null){
            listListener.itemClicked(id);
        }
    }
    public ProgramListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] names=new String[Program.programs.length];
        for(int i=0;i<names.length;i++){
            names[i]=Program.programs[i].getNazwa();
        }
        ArrayAdapter<String > adapter=new ArrayAdapter<String >(
                inflater.getContext(),android.R.layout.simple_list_item_1,names);
        setListAdapter(adapter);
        return super.onCreateView(inflater,container,savedInstanceState);
    }
}
