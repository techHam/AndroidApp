package com.example.shtrauch.restaurant;

import android.content.Context;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ororo on 7/30/2016.
 */
public class Actions
{
    static Gson gson = new Gson();


    public static String ReadDishes(Context context)
    {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(context.getAssets().open("Dishes.json"), "UTF-8"));

            String mLine;
            while ((mLine = reader.readLine()) != null) {
                builder.append(mLine);
            }
        }
        catch (IOException e)
        {
        }
        finally
        {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

        return builder.toString();
    }

    public static MenuItem SearchDish(String Name, Context context)
    {
        MenuItem item = null;
        MenuItem[] items = gson.fromJson(ReadDishes(context), MenuItem[].class);

        for (int i = 0; i < items.length; i += 1)
        {
            if (items[i].getName().equals(Name))
            {
                item = items[i];
            }
        }

        return item;
    }

    public static MenuItem[] GetMenuItemsArray(Context context)
    {
        return gson.fromJson(ReadDishes(context), MenuItem[].class);
    }

    public static String[] GetItemNameArray(Context context)
    {
        MenuItem[] items = GetMenuItemsArray(context);

        String[] names = new String[items.length];

        for (int i = 0; i < names.length ; i += 1)
        {
            names[i] = items[i].getName();
        }

        return names;
    }

    public static List<String> GetDrinks(Context context)
    {
        MenuItem[] items = GetMenuItemsArray(context);

        List<String> drinks = new ArrayList<>();

        for (int i = 0; i < items.length; i++)
        {
            if (items[i].getType().equals(DishType.Drink))
            {
                drinks.add(items[i].getName());
            }
        }

        return drinks;

    }

    public static List<String> GetFirsts(Context context)
    {
        MenuItem[] items = GetMenuItemsArray(context);

        List<String> drinks = new ArrayList<>();

        for (int i = 0; i < items.length; i++)
        {
            if (items[i].getType().equals(DishType.appetizer))
            {
                drinks.add(items[i].getName());
            }
        }

        return drinks;
    }


    public static List<String> GetMains(Context context)
    {
        MenuItem[] items = GetMenuItemsArray(context);

        List<String> drinks = new ArrayList<>();

        for (int i = 0; i < items.length; i++)
        {
            if (items[i].getType().equals(DishType.Main))
            {
                drinks.add(items[i].getName());
            }
        }

        return drinks;
    }


    public static List<String> GetDeserts(Context context)
    {
        MenuItem[] items = GetMenuItemsArray(context);

        List<String> drinks = new ArrayList<>();

        for (int i = 0; i < items.length; i++)
        {
            if (items[i].getType().equals(DishType.Desert))
            {
                drinks.add(items[i].getName());
            }
        }

        return drinks;
    }
}
