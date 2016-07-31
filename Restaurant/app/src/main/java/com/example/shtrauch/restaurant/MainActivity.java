package com.example.shtrauch.restaurant;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static User currentWaiter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        currentWaiter = (User)intent.getSerializableExtra("User");
/*
        Order order = new Order(2, this);

        MenuItem[] items = Actions.GetMenuItemsArray(this);
        String[] names = Actions.GetItemNameArray(this);


        RelativeLayout layout = (RelativeLayout)findViewById(R.id.Main);

        Spinner spinner = new Spinner(this);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        layout.addView(spinner);

        */

        Button addOrder = (Button)findViewById(R.id.bt_addOrder);
        final Intent intent1 = new Intent(this, AddAnOrder.class);

        intent1.putExtra("User", currentWaiter);

        addOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(intent1);
            }
        });
    }
}
