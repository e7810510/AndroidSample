package com.example.autosizingtextviewsample;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.library.AutoSizingTextView;

public class MainActivity extends AppCompatActivity {
    private static final int MAX_LINE = 2;
    private static final float MIN_TEXT_SIZE = 12f;
    private static final float MAX_TEXT_SIZE = 36f;

    private AutoSizingTextView textView;
    private AppCompatButton btnAddText, btnToSubtractText;
    private int sumCount = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.txt_content);
        btnAddText = findViewById(R.id.btn_add_text);
        btnToSubtractText = findViewById(R.id.btn_to_subtract_text);
        //
        setUpAddTextBtn(btnAddText);
        setUpToSubtractTextBtn(btnToSubtractText);
        // init
        textView.setTextAndAutoScaleByLine(getMockContentString(sumCount), MAX_LINE, MIN_TEXT_SIZE, MAX_TEXT_SIZE);
    }

    private void setUpAddTextBtn(AppCompatButton btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView != null) {
                    textView.setTextAndAutoScaleByLine(getMockContentString(++sumCount), MAX_LINE, MIN_TEXT_SIZE, MAX_TEXT_SIZE);
                }
            }
        });
    }

    private void setUpToSubtractTextBtn(AppCompatButton btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView != null) {
                    textView.setTextAndAutoScaleByLine(getMockContentString(--sumCount), MAX_LINE, MIN_TEXT_SIZE, MAX_TEXT_SIZE);
                }
            }
        });
    }

    private String getMockContentString(int sum) {

        if (sum < 1)
            sum = 1;

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < sum; i++) {
            builder.append("一二三四五六七八九十");
        }

        return builder.toString();
    }

    /**
     * Covert px to dp
     *
     * @param px
     * @param context
     * @return dp
     */
    public static float convertPixelToDp(float px, Context context) {
        float dp = px / getDensity(context);
        return dp;
    }

    public static float convertDpToPixel(float dp, Context context) {
        float px = dp * getDensity(context);
        return px;
    }

    public static int convertPixelToSp(float px, Context context) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (px / fontScale + 0.5f);
    }

    public static int convertSpToPixel(float sp, Context context) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (sp * fontScale + 0.5f);
    }


    /**
     * 取得螢幕密度
     * 120dpi = 0.75
     * 160dpi = 1 (default)
     * 240dpi = 1.5
     *
     * @param context
     * @return
     */
    public static float getDensity(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.density;
    }
}
