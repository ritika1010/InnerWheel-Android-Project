package com.example.innerwheelclub;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread toRun = new Thread()

        {
            public void run()
            {
                try {
                    sleep(2000);

                    Intent intent = new Intent (MainActivity.this,home.class);
                    startActivity(intent);

                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        toRun.start();
    }

    public void login_page(View v)
    {
        Context context = MainActivity.this;
        Class destActivity = home.class;

        Intent intent = new Intent(context, destActivity);
        startActivity(intent);
        finish();
    }
}
