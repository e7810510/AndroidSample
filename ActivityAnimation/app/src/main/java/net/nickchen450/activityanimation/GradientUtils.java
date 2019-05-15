package net.nickchen450.activityanimation;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v4.content.ContextCompat;

public class GradientUtils {
    public static Drawable getGradient() {
        ShapeDrawable.ShaderFactory shaderFactory = new ShapeDrawable.ShaderFactory() {
            @Override
            public Shader resize(int width, int height) {
                LinearGradient linearGradient = new LinearGradient(0, 0, 0, height,
                        new int[]{
                                0xFF5e3ff6,
                                0xFF5c48ef,
                                0xFF5861dd,
                                0xFF5189bf,
                                0xFF48c096,
                                0xFF3ff66e}, //substitute the correct colors for these
                        new float[]{
                                0, 0.10f, 0.29f, 0.51f, 0.77f, 1},
                        Shader.TileMode.REPEAT);
                return linearGradient;
            }
        };
        PaintDrawable paint = new PaintDrawable();
        paint.setShape(new RectShape());
        paint.setShaderFactory(shaderFactory);
        return paint;
    }

    public static Drawable getCustomGradient(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{ContextCompat.getColor(context, R.color.color1),
                        ContextCompat.getColor(context, R.color.color2),
                        ContextCompat.getColor(context, R.color.color3),
                        ContextCompat.getColor(context, R.color.color4),
                        ContextCompat.getColor(context, R.color.color5),
                        ContextCompat.getColor(context, R.color.color6)});

        return gradientDrawable;
    }
}
