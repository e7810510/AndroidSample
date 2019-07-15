package com.example.appbarsample;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private AppCompatImageView imageView;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        initViewPager();
        initTabView();
    }

    private void findViewById() {
        imageView = findViewById(R.id.img);
        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.view_pager);
    }

    private void initViewPager() {
        viewPager.setAdapter(new ChildViewAdapter());
    }

    private void initTabView() {
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fadeInAndShowImage(imageView);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(LayoutInflater.from(this).inflate(R.layout.layout_tab, null, false));
            }
        }
    }

    private int[] imgRes = {R.drawable.google, R.drawable.apple};

    private void fadeOutAndHideImage(final ImageView img) {
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(500);

        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                img.setImageResource(imgRes[tabLayout.getSelectedTabPosition()]);
            }
        });

        img.startAnimation(fadeOut);
    }

    private void fadeInAndShowImage(final ImageView img) {
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new AccelerateInterpolator());
        fadeIn.setDuration(500);

        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                img.setImageResource(imgRes[tabLayout.getSelectedTabPosition()]);
            }
        });
        img.startAnimation(fadeIn);
    }
}
