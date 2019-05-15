package net.nickchen450.androidbrightnesssample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import static android.view.WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_NONE;

/**
 * 參考資料
 * http://nikeru8.blogspot.com/2017/05/android-androidpermissionwritesettings.html
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final float BRIGHTNESS_MAX = 255f;
    private Button btnOn, btnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOff = findViewById(R.id.btn_off);
        btnOn = findViewById(R.id.btn_on);

        btnOff.setOnClickListener(this);
        btnOn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnOff) {
            setBrightness(this, BRIGHTNESS_OVERRIDE_NONE);
        } else if (v == btnOn) {
            setBrightness(this, BRIGHTNESS_MAX);
        }
    }

    // 針對App端的UI作為 螢幕亮度調整
    // 設置屏幕亮度
    public void setBrightness(Activity activity, float brightness) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.screenBrightness = brightness * (1f / 255f);
        activity.getWindow().setAttributes(lp);
    }
}
