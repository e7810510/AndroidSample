package com.example.library;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.appcompat.widget.AppCompatTextView;

/**
 * 依照行數來判斷是否縮小，字體
 */
public class AutoSizingTextView extends AppCompatTextView {

    private boolean isEnableAutoSizing = false;
    private int lineFlag = 1;
    private float minTextSize = 12f;
    private float maxTextSize = 14f;
    private float currentTextSize = 12f;

    public AutoSizingTextView(Context context) {
        super(context);
    }

    public AutoSizingTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoSizingTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // 設定文字，及自動放大縮小的字體大小，
    public void setTextAndAutoScaleByLine(String text, int lineFlag, float minTextSize, float maxTextSize) {
        this.lineFlag = lineFlag;
        this.minTextSize = minTextSize;
        this.maxTextSize = maxTextSize;
        isEnableAutoSizing = true;
        this.setText(text);
        requestLayout();
        invalidate();
    }


    private synchronized void scaleTextIfOverSpecificLine(int lineFlag, float textSize, float maxTextSize) {
        if (getLineCount() > lineFlag) {
            if (currentTextSize == textSize)
                return;
            currentTextSize = textSize;
            setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        } else {
            if (currentTextSize == maxTextSize)
                return;
            currentTextSize = maxTextSize;
            setTextSize(TypedValue.COMPLEX_UNIT_SP, maxTextSize);
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (isEnableAutoSizing) {
            scaleTextIfOverSpecificLine(lineFlag, minTextSize, maxTextSize);
            // 關閉flag避免一直觸發
            isEnableAutoSizing = false;
        }
    }
}
