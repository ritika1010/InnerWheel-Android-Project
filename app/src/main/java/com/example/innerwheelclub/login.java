package com.example.innerwheelclub;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.appcompat.*;
import android.R.layout; // at the top
import android.view.View;


public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void newuser(View v)
    {
        Context context =this;
        Class destActivity = new_user.class;

        Intent intent = new Intent(context, destActivity);
        startActivity(intent);
        finish();
    }
    public void loginned(View v)
    {
        Context context =this;
        Class destActivity = user_home.class;

        Intent intent = new Intent(context, destActivity);
        startActivity(intent);
        finish();
    }


}
