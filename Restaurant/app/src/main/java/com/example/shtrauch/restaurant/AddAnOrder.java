package com.example.shtrauch.restaurant;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddAnOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_an_order);

        final RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.layoutAddOrder);

        final Context context = this;

        final Order order = new Order(2, this);

        MenuItem[] items = Actions.GetMenuItemsArray(this);
        String[] names = Actions.GetItemNameArray(this);

        final List<String> drinks = Actions.GetDrinks(this);
        final List<String> firsts = Actions.GetFirsts(this);
        final List<String> main = Actions.GetMains(this);
        final List<String> desert = Actions.GetDeserts(this);

        final RelativeLayout layout = (RelativeLayout)findViewById(R.id.layoutAddOrder);

        final Button bt_drinks = new Button(this);
        Button bt_firsts = new Button(this);
        Button bt_mains = new Button(this);
        Button bt_deserts = new Button(this);

        Button add = (Button)findViewById(R.id.AddToOrder);

        bt_drinks.setText("Drinks");

        final Spinner spinner = new Spinner(context);

        final List<MenuItem> toAdd = new ArrayList<>();

        layout.addView(bt_drinks);

        bt_drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                spinner.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, drinks));

                relativeLayout.addView(spinner, bt_drinks.getLayoutParams().width ,  bt_drinks.getLayoutParams().height + 300);

                Button addToList = new Button(context);

                relativeLayout.addView(addToList, bt_drinks.getLayoutParams().width ,  bt_drinks.getLayoutParams().height + 600);

                addToList.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        String spinerItem = spinner.getSelectedItem().toString();

                        MenuItem selected = Actions.SearchDish(spinerItem, context);

                        toAdd.add(selected);
                    }
                });
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < toAdd.size(); i++)
                {
                    order.getDishs().add(toAdd.get(i));
                }
            }
        });

        TextView view = new TextView(context);
        view.setText(order.getDishs().toString());

        //layout.addView(view, bt_drinks.getLayoutParams().width ,  bt_drinks.getLayoutParams().height + 600);

    }
}
