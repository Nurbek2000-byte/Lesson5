package com.example.lesson5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.progressindicator.LinearProgressIndicator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ViewPager pager;
    ViewPagerAdapter adapter;
    TextView txtSkip, txtNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.view_pager);
        txtSkip = findViewById(R.id.txt_skip);
        txtNext = findViewById(R.id.txt_next);

        List<OnBoardingModel> list = new ArrayList<>();
        list.add(new OnBoardingModel("Hello World! 1","It's my first OnBoarding Screen",R.drawable.logo));
        list.add(new OnBoardingModel("Hello World! 2","It's my first OnBoarding Screen",R.drawable.logo));
        list.add(new OnBoardingModel("Hello World! 3","It's my first OnBoarding Screen",R.drawable.logo));
    adapter = new ViewPagerAdapter(list,getSupportFragmentManager());
    pager.setAdapter(adapter);


    txtSkip.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }

    });

    pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
                if (position ==2){
                    txtNext.setText("Finish");
                }else txtNext.setText("Next");



        }

        @Override
        public void onPageScrollStateChanged(int state) {


        }
    });
    txtNext.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (pager.getCurrentItem()==2 ){
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }else
            pager.setCurrentItem(pager.getCurrentItem() + 1);
        }
    });
    }

}
