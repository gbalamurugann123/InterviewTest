package com.android.form.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.android.form.R
import com.android.form.adapter.PageAdapter.PageViewHolder
import com.android.form.model.Control
import com.android.form.utils.PageUtils

/**
 * Created by Balamurugan on 10/5/2017.
 */
class PageAdapter(private val itemsList: List<Control>, var context: Activity) : RecyclerView.Adapter<PageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.page_item, parent, false)
        return PageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        // bind layout and data etc..
        val itemRow = itemsList[position]
        holder.dynamicItemLayout.removeAllViews()
        PageUtils.createView(itemRow, context, holder.dynamicItemLayout)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    class PageViewHolder(itemView: View) : ViewHolder(itemView) {
        val dynamicItemLayout: LinearLayout

        init {
            dynamicItemLayout = itemView.findViewById<View>(R.id.layout_dynamic_row) as LinearLayout
        }
    }

}