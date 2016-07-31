package com.example.shtrauch.restaurant;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.JsonSerializer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginScreen extends AppCompatActivity {

    User[] users = null;
    User user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        final EditText username = (EditText)findViewById(R.id.et_username);
        final EditText password = (EditText)findViewById(R.id.et_password);

        Button bt_login = (Button)findViewById(R.id.bt_login);

        final TextView status = (TextView)findViewById(R.id.status);

        final String usersJson = ReadJson();

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                user = PopulateUser(username, password);
                Intent intent = new Intent(LoginScreen.this, MainActivity.class);

                try
                {
                    JSONArray array = new JSONArray(usersJson);

                    users = DeDeserializeUsers(array);

                    if (SearchUser(users, user))
                    {
                        //green 0, 128, 0
                        status.setTextColor(Color.rgb(0, 128, 0));
                        status.setText("Success!, Hello " + username.getText().toString());
                        intent.putExtra("User", user);

                        startActivity(intent);
                    }
                    else
                    {
                        status.setTextColor(Color.rgb(255, 0, 0));
                        status.setText("Error!, User Doesn't Exist");
                    }

                }
                catch (JSONException ex)
                {
                    ex.printStackTrace();
                }
            }
        });
    }

    public User DeserializeUser(JSONArray array, int index)
    {
        User user = new User();

        try
        {
            user.setUsername(array.getJSONObject(index).getString("username"));
            user.setPassword(array.getJSONObject(index).getString("password"));
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        return user;
    }

    public User[] DeDeserializeUsers(JSONArray array)
    {
        User[] users = new User[array.length()];

        for (int i = 0; i < users.length; i += 1)
        {
            users[i] = DeserializeUser(array, i);
        }

        return users;
    }

    public String ReadJson()
    {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("Users.json"), "UTF-8"));

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

    public boolean SearchUser(User[] users, User user)
    {
        for (int i = 0; i < users.length; i += 1)
        {
            if (users[i].ValidateLogin(user))
            {
                return true;
            }
        }

        return false;
    }

    public User PopulateUser(EditText username, EditText password)
    {
        User user = new User();

        user.setUsername(username.getText().toString());
        user.setPassword(password.getText().toString());

        return user;
    }
}
