package com.example.shtrauch.restaurant;

/**
 * Created by ororo on 7/30/2016.
 */

import java.io.Serializable;


public class User implements Serializable
{
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean ValidateLogin(User credentials)
    {
        if (credentials == null)
        {
            return false;
        }

        return this.getUsername().equals(credentials.getUsername()) && this.getPassword().equals(credentials.getPassword());
    }
}
