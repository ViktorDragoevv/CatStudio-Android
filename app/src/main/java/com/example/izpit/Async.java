package com.example.izpit;

import android.os.AsyncTask;
import android.os.Handler;

import com.example.izpit.Model.Cat;
import com.example.izpit.Repository.Repository;

import java.util.ArrayList;
import java.util.Random;

public class Async extends AsyncTask<Void,Void,Void> {
    ArrayList<Cat> cats;

    @Override
    protected Void doInBackground(Void... voids) {

        /*
    }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Random random = new Random();
                int number = random.nextInt(2)+1;

                if(number==1){
                    Cat c = new Cat();
                    c=cats.get(position);
                    cat= Repository.findCatByName(c.getName());
                    cat.setState(true);
                }
                if(number==2){
                    Cat c = new Cat();
                    cats.add(c);
                }
                if(number==3){
                    Cat c = new Cat();
                    c=cats.get(position);
                    int n= cats.indexOf(cat);
                    if(c.isState()==true){
                        cats.remove(c);

                        notifyItemRemoved(n);
                    }

                }

            }
        },300);


    }*/
        return null;
    };


    public Async() {
        super();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}