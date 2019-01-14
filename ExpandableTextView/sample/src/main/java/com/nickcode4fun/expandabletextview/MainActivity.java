package com.nickcode4fun.expandabletextview;

import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nickcode4fun.lib.ExpandableTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LinearLayout linearLayout = findViewById(R.id.view_group);
        final ExpandableTextView txtExpandableView = findViewById(R.id.txt_expandable_view);
        txtExpandableView.setText(getMockText());

        txtExpandableView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(linearLayout);
                txtExpandableView.setTrimDisplay(!txtExpandableView.isTrim());
            }
        });
    }

    private String getMockText() {
        return  "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Ut volutpat interdum interdum. Nulla laoreet lacus diam, vitae " +
                "sodales sapien commodo faucibus. Vestibulum et feugiat enim. Donec " +
                "semper mi et euismod tempor. Sed sodales eleifend mi id varius. Nam " +
                "et ornare enim, sit amet gravida sapien. Quisque gravida et enim vel " +
                "volutpat. Vivamus egestas ut felis a blandit. Vivamus fringilla " +
                "dignissim mollis. Maecenas imperdiet interdum hendrerit. Aliquam" +
                " dictum hendrerit ultrices. Ut vitae vestibulum dolor. Donec auctor ante" +
                " eget libero molestie porta. Nam tempor fringilla ultricies. Nam sem " +
                "lectus, feugiat eget ullamcorper vitae, ornare et sem. Fusce dapibus ipsum" +
                " sed laoreet suscipit. ";

    }
}
