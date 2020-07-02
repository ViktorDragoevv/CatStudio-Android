package com.example.izpit.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.izpit.Adapter.ViewHolder;
import com.example.izpit.Interface.Lisener;
import com.example.izpit.Model.Cat;
import com.example.izpit.R;
import com.example.izpit.Repository.Repository;

public class FragmentCat extends DialogFragment {
    private TextView fCatName;
    private TextView fCatPoroda;
    private TextView fCatStatus;
    private Button BTNBack;
    private Button BTNStart;
    ViewHolder holder;
    Lisener lisener;


    public FragmentCat(Lisener lisener) {
        this.lisener=lisener;

    }
    /*
    public static FragmentCat newIstance(){
        return new FragmentCat();

    }*/

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fCatName=view.findViewById(R.id.fCatName);
        fCatPoroda=view.findViewById(R.id.fCatPoroda);
        fCatStatus=view.findViewById(R.id.fCatStatus);
        BTNBack=view.findViewById(R.id.btnBack);
        BTNStart = view.findViewById(R.id.btnStart);
        Cat cat = new Cat();
        cat= Repository.findCatByName(getArguments().getString("catName"));
        fCatName.setText(String.valueOf(cat.getName()));
        fCatPoroda.setText(String.valueOf(cat.getPoroda()));
        if(cat.isState()){
            fCatStatus.setText("activno");

        }
        else
        {
            fCatStatus.setText("izchakvashto");
        }
        BTNBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        BTNStart.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
               // holder.itemView.setBackgroundColor(R.color.yellow);
                //setBackgroundColor(R.color.yellow);
                lisener.color();
                lisener.button();
                lisener.state();

                dismiss();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cat, container, false);
    }
}