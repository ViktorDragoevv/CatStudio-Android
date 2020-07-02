package com.example.izpit.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.izpit.Fragments.FragmentCat;
import com.example.izpit.Interface.Lisener;
import com.example.izpit.Interface.LisenerDelete;
import com.example.izpit.Model.Cat;
import com.example.izpit.R;
import com.example.izpit.Repository.Repository;

import java.util.ArrayList;

public class ViewHolder extends RecyclerView.ViewHolder implements Lisener {
    private TextView catName;
    private Button btnAction;
    Cat cat = new Cat();
    LisenerDelete lisenerDelete;
    Lisener lisener;
    ArrayList<Cat>cats=new ArrayList<>();
    Adapter adapter ;


    public ViewHolder(@NonNull View itemView , final Context context , final LisenerDelete lisenerDelete) {
        super(itemView);
        catName=itemView.findViewById(R.id.catName);
        btnAction=itemView.findViewById(R.id.btnAction);
        btnAction.setVisibility(View.INVISIBLE);
        this.lisenerDelete=lisenerDelete;

        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cat c = new Cat();
                c= Repository.findCatByName(catName.getText().toString());
               //int pos = cats.indexOf(cat);
                Log.d("sss",c.toString());

                lisenerDelete.delete(c);




            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("catName",catName.getText().toString());


                Log.d("sss",bundle.toString());

                FragmentManager fragmentManager =(((AppCompatActivity)context).getSupportFragmentManager());
                FragmentCat fragmentCat = new FragmentCat(ViewHolder.this);
                //fragmentCat= fragmentCat.newIstance();
                fragmentCat.setArguments(bundle);
                fragmentCat.show(fragmentManager,"catView");

            }
        });
    }

    public TextView getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName.setText(catName);
    }

    public Button getBtnAction() {
        return btnAction;
    }

    public void setBtnAction(Boolean btnAction) {

        if (btnAction){
            this.btnAction.setVisibility(View.VISIBLE);
        }
        else
        {
            this.btnAction.setVisibility(View.INVISIBLE);
        }

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void color() {
        itemView.setBackgroundColor(R.color.yellow);
    }

    @Override
    public void button() {

        btnAction.setVisibility(View.VISIBLE);
    }

    @Override
    public void state() {
        cat= Repository.findCatByName(catName.getText().toString());
        cat.setState(true);
    }


}
