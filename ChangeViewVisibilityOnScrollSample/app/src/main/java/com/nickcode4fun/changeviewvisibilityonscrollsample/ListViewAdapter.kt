package com.nickcode4fun.changeviewvisibilityonscrollsample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ListViewAdapter : RecyclerView.Adapter<ListViewAdapter.ViewHolder>() {

    private var itemCount: Int = 0

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val child = LayoutInflater.from(p0.context).inflate(R.layout.layout_list_item, p0, false)
        return ViewHolder(child)
    }

    override fun getItemCount(): Int {
        return 30
    }

    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
        if (holder.itemView is TextView) {
            holder.itemView.text = "item"
        }
    }

    inner class ViewHolder(child: View) : RecyclerView.ViewHolder(child)
}