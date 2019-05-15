package net.nickchen450.activityanimation

import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.drawable.Drawable
import android.graphics.drawable.PaintDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape

class GradientKUtils {
    companion object {
        fun getGradient(): Drawable {

            val shaderFactory = object : ShapeDrawable.ShaderFactory() {
                override fun resize(width: Int, height: Int): Shader {
                    return LinearGradient(0f, 0f, 0f, height.toFloat(),
                        intArrayOf(
                            -0xa1c00a,
                            -0xa3b711,
                            -0xa79e23,
                            -0xae7641,
                            -0xb73f6a,
                            -0xc00992
                        ), //substitute the correct colors for these
                        floatArrayOf(0f, 0.10f, 0.29f, 0.51f, 0.77f, 1f),
                        Shader.TileMode.REPEAT)
                }
            }
            val paint = PaintDrawable()
            paint.shape = RectShape()
            paint.shaderFactory = shaderFactory
            return paint
        }
    }
}