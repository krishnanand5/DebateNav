package com.example.android.myapplication;
public class Planet {

    private String name;

    private String descr;




    public Planet(String name) {
        this.name = name;

    }

    public Planet(String name, String descr) {
        this.name = name;
        this.descr = descr;
    }




    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }






}
