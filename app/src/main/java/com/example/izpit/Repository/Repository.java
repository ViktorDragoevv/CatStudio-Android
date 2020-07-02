package com.example.izpit.Repository;

import com.example.izpit.Model.Cat;

import java.util.ArrayList;
import java.util.Random;

public class Repository {

    public static ArrayList<Cat>cats = new ArrayList<>();

    public static ArrayList<Cat> generateCats(int num){
        Random random;
        for (int i = 0; i<=num;i++){

            cats.add(new Cat("Cat"+i,"poroda"+i,false));
        }
        return cats;
    }

    public static Cat findCatByName(String name){
        for (Cat cat:cats) {
            if(cat.getName().equals(name)){
                return cat;
            }

        }
         return null;
    }
}
