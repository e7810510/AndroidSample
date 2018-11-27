package com.nickcode4fun.bottomsheetsample

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialog
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {

    lateinit var bottomBehavior: BottomSheetBehavior<View>
    lateinit var bottomSheet: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)
        bottomSheet = findViewById<View>(R.id.bottom_sheet)
        bottomBehavior = BottomSheetBehavior.from(bottomSheet)
    }

    fun showBottomSheet(v: View) {
        setBottomViewVisible(bottomBehavior.state != BottomSheetBehavior.STATE_EXPANDED)
    }

    fun showBottomSheetDialog(v: View) {
        val view: View = layoutInflater.inflate(R.layout.bottom_sheet, null)
        val dialog: BottomSheetDialog = BottomSheetDialog(this)
        dialog.setContentView(view)
        dialog.show()
    }

    fun showBottomSheetDialogFragment(v: View) {
        val bottomSheetFragment = BottomSheetFragment()
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
    }

    private fun setBottomViewVisible(isShow: Boolean) {
        if (isShow)
            bottomBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        else
            bottomBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }
}
