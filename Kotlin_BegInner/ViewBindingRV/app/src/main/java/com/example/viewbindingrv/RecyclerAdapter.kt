package com.example.viewbindingrv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbinding.Task

class RecyclerAdapter(val itemList: List<Task>): RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {
    inner class RecyclerViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView){
        val titleTv: TextView = itemView.findViewById(R.id.titleTv)
        val timeTv: TextView = itemView.findViewById(R.id.timeTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_view, parent, false)

        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.titleTv.text = itemList[position].title
        holder.timeTv.text = itemList[position].timeStamp
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}