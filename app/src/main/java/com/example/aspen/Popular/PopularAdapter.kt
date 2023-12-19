package com.example.aspen.Popular

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.aspen.R
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView

class PopularAdapter(
    private val popularList: List<Popular>,
    private val onItemClick: (Popular) -> Unit
) :
    RecyclerView.Adapter<PopularAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.popular, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val popular = popularList[position]
        holder.img.setImageResource(popular.img)
        holder.title.text = popular.title
        holder.rating.text = popular.rating

        holder.itemView.setOnClickListener {
            onItemClick(popular)
        }

        if (popular.like == "liked") {
            holder.like.visibility = View.VISIBLE
        } else {
            holder.like.visibility = View.GONE
        }

    }

    override fun getItemCount(): Int {
        return popularList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val img: ImageView = itemView.findViewById(R.id.img)
        val title: MaterialTextView = itemView.findViewById(R.id.place_name)
        val rating: MaterialTextView = itemView.findViewById(R.id.rating)
        val like: MaterialCardView = itemView.findViewById(R.id.like)
    }
}