package com.example.viikko11;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.viikko11.fragments.FragmentAdd;
import com.example.viikko11.fragments.FragmentMain;
import com.example.viikko11.fragments.FragmentSuper;

public class TabPagerAdapter extends FragmentStateAdapter {

    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new FragmentAdd();
            case 2:
                return new FragmentSuper();
            default:
                return new FragmentMain();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
