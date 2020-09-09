package com.example.myapplication;

import java.util.ArrayList;

public class Item {
    Item(String id) {
        this.id = id;
    }

    String id;
    public ArrayList<String> innerArrayList = new ArrayList<>();
}