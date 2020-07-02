package com.example.izpit.Model;

public class Cat {
    private String name;
    private String poroda;
    private boolean state;

    public Cat(){}

    public Cat(String name, String poroda, boolean state) {
        this.name = name;
        this.poroda = poroda;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoroda() {
        return poroda;
    }

    public void setPoroda(String poroda) {
        this.poroda = poroda;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", poroda='" + poroda + '\'' +
                ", state=" + state +
                '}';
    }


}
