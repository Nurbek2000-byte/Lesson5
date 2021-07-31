package com.example.lesson5;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


   private List<OnBoardingModel> list;

    public ViewPagerAdapter(List<OnBoardingModel> list, FragmentManager fm){
        super(fm);
        this.list = list;

    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
            case 1:
            case 2:
            return OnBoardingItemFragment.newInstance(list.get(position).getTitle(), list.get(position).getDescription(), list.get(position).getImage());
        }
        return null;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
