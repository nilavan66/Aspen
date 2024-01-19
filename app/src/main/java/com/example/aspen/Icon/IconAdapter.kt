package com.example.aspen.Icon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.aspen.R
import com.google.android.material.textview.MaterialTextView

class IconAdapter(private val iconList: List<Icon>) :
    RecyclerView.Adapter<IconAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.f_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val icon = iconList[position]
        with(holder) {
            iconImage.setImageResource(icon.icon)
            iconText.text = icon.title
        }
    }

    override fun getItemCount(): Int {
        return iconList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iconImage: ImageView = itemView.findViewById(R.id.icon)
        val iconText: MaterialTextView = itemView.findViewById(R.id.name)
    }
}