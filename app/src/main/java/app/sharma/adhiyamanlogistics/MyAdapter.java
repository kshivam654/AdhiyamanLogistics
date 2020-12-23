package app.sharma.adhiyamanlogistics;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import app.sharma.adhiyamanlogistics.HomeFragment;

public class MyAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public MyAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}