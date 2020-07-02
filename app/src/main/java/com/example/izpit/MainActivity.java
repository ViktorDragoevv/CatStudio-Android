package com.example.izpit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.izpit.Adapter.Adapter;
import com.example.izpit.Model.Cat;
import com.example.izpit.Repository.Repository;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv);

       final ArrayList<Cat>cats=Repository.generateCats(5);

        final Adapter adapter = new Adapter(cats);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final Handler handler = new Handler();




        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this,3000);

                Random random = new Random();
                int number = random.nextInt(3)+1;
                int p =adapter.getItemCount();
                int num = random.nextInt(p-1)+1;
                //int number = 3;



                if(number==1){
                    Cat c = new Cat("cat","poroda",false);
                    c=cats.get(num);

                    c.setState(true);
                    adapter.notifyItemChanged(num);
                }
                if(number==2){
                    Cat c = new Cat("cat"+p,"poroda",false);
                    cats.add(c);
                    adapter.notifyDataSetChanged();
            }
                if(number==3){
                    Cat c = new Cat();
                    c=cats.get(num);

                    if(c.isState()==true){
                        cats.remove(c);

                        adapter.notifyItemRemoved(num);
                    }
                    //cats.remove(c);

                    //adapter.notifyItemRemoved(num);


                }

            }

        };

        handler.post(runnable);





    }
}