package com.example.designtest;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Random;

/**
 * 自定义tablayout 与  ViewPager
 */
public class TabLayoutTestActivity extends AppCompatActivity {

    private TabLayout.Tab mTab;

    String[] arrays =new String[]{"nihao","我是天马","首页","常常字符呵呵","我","没有","什么么么么么么吗","有吗","有吗","nihao","我是天马","首页","常常字符呵呵","我"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_test);
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);

        String[] path =new String[]{
                "http://p4.qhimg.com/t015a5cc8c8651e335a.png",
                "http://f5.jmstatic.com/static_account/dist/20160509/images/icons/android/checkin.png",
                "http://f3.jmstatic.com/static_account/dist/20160509/images/icons/android/comment.png",
                "http://p4.qhimg.com/t015a5cc8c8651e335a.png",
                "http://f5.jmstatic.com/static_account/dist/20160509/images/icons/android/wish_deal.png",
                "http://p4.qhimg.com/t015a5cc8c8651e335a.png",
                "http://p4.qhimg.com/t015a5cc8c8651e335a.png",
                "http://f5.jmstatic.com/static_account/dist/20160509/images/icons/android/checkin.png"
        };


        Random random =new Random();
        for (int i = 0; i < 10; i++) {
           int  x = random.nextInt(path.length-1);
            View v = LayoutInflater.from(this).inflate(R.layout.tab_layout, null);
            ImageView imageView = (ImageView) v.findViewById(R.id.image);
            Picasso.with(this).load(path[x]).into(imageView);
            mTab = tabLayout.newTab().setCustomView(v);
            mTab.setText(arrays[i]);
            tabLayout.addTab(mTab);
        }



        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpage);

        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myAdapter);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tabLayout.setScrollPosition(position, positionOffset, true);
                Log.d("position  == ", "" + position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new FragmentTest();
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }

    }

}
