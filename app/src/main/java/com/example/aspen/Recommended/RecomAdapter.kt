package com.example.aspen.Recommended

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.aspen.Popular.PopularAdapter
import com.example.aspen.R
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView

class RecomAdapter (private val recomList: List<Recom> ):
RecyclerView.Adapter<RecomAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recommended, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val recom = recomList[position]
        holder.img.setImageResource(recom.img)
        holder.title.text = recom.title
        holder.dn.text = recom.dn
    }

    override fun getItemCount(): Int {
        return recomList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val img: ImageView = itemView.findViewById(R.id.img)
        val title: MaterialTextView = itemView.findViewById(R.id.title)
        val dn: MaterialTextView = itemView.findViewById(R.id.dn)
    }


}