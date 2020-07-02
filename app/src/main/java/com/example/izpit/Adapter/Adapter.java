package com.example.izpit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.izpit.Interface.LisenerDelete;
import com.example.izpit.Model.Cat;
import com.example.izpit.R;
import com.example.izpit.Repository.Repository;

import java.util.ArrayList;
import java.util.Random;

public class Adapter extends RecyclerView.Adapter<ViewHolder> implements LisenerDelete {
    Context context;
    ArrayList<Cat>cats =new ArrayList<>();
    Cat cat = new Cat();
    LisenerDelete lisenerDelete;



    public Adapter(ArrayList<Cat>cats ){
            this.cats=cats;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType ) {
        context=parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cat_row,parent,false);
        ViewHolder holder = new ViewHolder(view,context,this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        cat=cats.get(position);

        holder.setCatName(cat.getName());









    }

    @Override
    public int getItemCount() {
        return cats.size();
    }

    @Override
    public void delete(Cat cat) {
        int pos= cats.indexOf(cat);
        cats.remove(cat);


        notifyItemRemoved(pos);
    }
}
