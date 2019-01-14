package com.nickcode4fun.changeviewvisibilityonscrollsample

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.v4.view.ViewCompat
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils

/**
 * Tips
 * 1.The child view must be last on in parent
 * 2.
 * */
class ScrollingFloatingViewBehavior<T : View> : CoordinatorLayout.Behavior<T> {

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    private var height: Int = 0
    private var marginBottom = 0
    private var direction: Direction = Direction.NONE

    private enum class Direction {
        UP, DOWN, NONE
    }

    override fun onLayoutChild(parent: CoordinatorLayout, child: T, layoutDirection: Int): Boolean {

        if (parent.childCount != 0) {
            val lastChildView: View = parent.getChildAt(parent.childCount - 1)
            height = lastChildView.height
            marginBottom = (lastChildView.layoutParams as ViewGroup.MarginLayoutParams).bottomMargin // Get view height and margin bottom
        }

        return super.onLayoutChild(parent, child, layoutDirection)
    }

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: T, directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL // check the scroll direction
                || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type)
    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: T, target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type)

        if (dyConsumed > 0) {
            didAnimation(child, Direction.DOWN)
        } else if (dyConsumed < 0) {
            didAnimation(child, Direction.UP)
        }
    }

    private fun didAnimation(child: T, direction: Direction) {
        if (this.direction != direction) {
            this.direction = direction

            when (this.direction) {
                Direction.DOWN -> { // 下滑
                    slideDown(child)
                }

                Direction.UP -> {
                    slideUp(child) // 上滑
                }
                else -> return
            }
        }
    }

    private fun slideUp(child: T) {
        child.visibility = View.VISIBLE
        val animation = AnimationUtils.loadAnimation(child.context, R.anim.anim_slide_in_from_bottom)
        child.startAnimation(animation)
    }

    private fun slideDown(child: T) {
        val animation = AnimationUtils.loadAnimation(child.context, R.anim.anim_slide_out_from_bottom)
        child.startAnimation(animation)
        child.visibility = View.INVISIBLE
    }

}