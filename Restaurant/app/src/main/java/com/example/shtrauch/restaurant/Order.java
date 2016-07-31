package com.example.shtrauch.restaurant;

import android.content.Context;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ororo on 7/30/2016.
 */
public class Order {
    private int amoutOfDiners;
    private Menu tableMenu;
    private List<MenuItem> dishs;
    private User waiter;
    private Date time;
    public String orderID;

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");


    public Order(int amoutOfDiners, Context context) {
        this.amoutOfDiners = amoutOfDiners;
        tableMenu = new Menu(context);
        dishs = new ArrayList<>();
        waiter = MainActivity.currentWaiter;
        time = new Date();
        orderID = GenerateOrderID();
    }

    public int getAmoutOfDiners() {
        return amoutOfDiners;
    }

    public void setAmoutOfDiners(int amoutOfDiners) {
        this.amoutOfDiners = amoutOfDiners;
    }

    public Menu getTableMenu() {
        return tableMenu;
    }

    public void setTableMenu(Menu tableMenu) {
        this.tableMenu = tableMenu;
    }

    public List<MenuItem> getDishs() {
        return dishs;
    }

    public void setDishs(List<MenuItem> dishs) {
        this.dishs = dishs;
    }

    public User getWaiter() {
        return waiter;
    }

    public void setWaiter(User waiter) {
        this.waiter = waiter;
    }

    private String GenerateOrderID()
    {
        return waiter.getUsername() + "-" + amoutOfDiners + "-" + dateFormat.format(time);
    }
}
