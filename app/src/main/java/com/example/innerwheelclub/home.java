package com.example.innerwheelclub;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

public class home extends AppCompatActivity {

    ViewPager viewPager;
    SlideAdapter slideAdapter;
    LinearLayout sliderdots;
    int dotscount;
    private ImageView[] dots;
    Timer timer;
    int currpos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager=(ViewPager)findViewById(R.id.view_pager);

        sliderdots=findViewById(R.id.slidershots);
        slideAdapter=new SlideAdapter(this);

        viewPager.setAdapter(slideAdapter);

        dotscount=slideAdapter.getCount();
        dots=new ImageView[dotscount];



        for(int i=0;i<dotscount;i++)
        {
            dots[i]=new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonacive_dot));
            LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(100, 100);
            params.setMargins(0,0,0,0);

            sliderdots.addView(dots[i],params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.actve_dot));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i=0;i<dotscount;i++)
                {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonacive_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.actve_dot));
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        createSlideshow();
    }

    public void createSlideshow()
    {
        final Handler handler=new Handler();
        final Runnable runnable=new Runnable() {
            @Override
            public void run() {
                if(currpos==slideAdapter.getCount())
                    currpos=0;

                viewPager.setCurrentItem(currpos++,true);
            }
        };

        timer= new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        },250,2500);
    }

    public void login_page(View view)
    {
        Intent intent = new Intent (home.this,login.class);
        startActivity(intent);
    }

    public void new_page(View view)
    {
        Intent intent = new Intent (home.this,new_user.class);
        startActivity(intent);
    }
}
