package com.example.shtrauch.restaurant;

import android.content.Context;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by ororo on 7/30/2016.
 */
public class Menu {
    private ArrayList<Dish> items;
    private Context context;

    public Menu(Context _context) {
        items = new ArrayList<>();
        context = _context;
    }

    public MenuItem getDish(String Name)
    {
        return Actions.SearchDish(Name, context);
    }

}
