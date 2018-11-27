package com.nickcode4fun.bottomsheetsample

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout

class ImageTextView : FrameLayout {

    private lateinit var imgIconView: AppCompatImageView
    private lateinit var txtNameView: AppCompatTextView

    constructor(context: Context?) : super(context) {
        context?.apply { initView(this) }
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        context?.apply { initView(this) }
        readXMLAttributes(context, attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        context?.apply { initView(this) }
        readXMLAttributes(context, attrs)
    }

    private fun initView(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.layout_image_text_view, this)
        imgIconView = findViewById(R.id.img_icon)
        txtNameView = findViewById(R.id.txt_name)
    }

    private fun readXMLAttributes(context: Context?, attrs: AttributeSet?) {
        val typedArray = context?.obtainStyledAttributes(attrs, R.styleable.ImageTextView)

        val itemName = typedArray?.getString(R.styleable.ImageTextView_text)
        val itemSrc = typedArray?.getDrawable(R.styleable.ImageTextView_src)

        itemName?.isNotEmpty().apply { setItemName(itemName!!) }
        itemSrc?.apply { setImageResource(itemSrc) }

        typedArray?.recycle()
    }


    fun setImageResource(resId: Int) {
        imgIconView.setImageResource(resId)
    }

    fun setImageResource(res: Drawable) {
        imgIconView.setImageDrawable(res)
    }

    fun setItemName(name: String) {
        txtNameView.text = name
    }
}