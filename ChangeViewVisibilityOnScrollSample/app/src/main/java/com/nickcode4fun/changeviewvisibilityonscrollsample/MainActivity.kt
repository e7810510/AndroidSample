package com.nickcode4fun.changeviewvisibilityonscrollsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        list_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ListViewAdapter()
        }

    }
}
