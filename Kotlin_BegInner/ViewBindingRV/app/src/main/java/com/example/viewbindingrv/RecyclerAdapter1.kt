package com.example.viewbindingrv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbinding.Task
import com.example.viewbinding.TaskList
import com.example.viewbindingrv.databinding.RecyclerItemViewBinding

class RecyclerAdapter1 (val itemList: List<Task>): RecyclerView.Adapter<RecyclerAdapter1.RecyclerViewHolder>() {
    inner class RecyclerViewHolder(val binding: RecyclerItemViewBinding): RecyclerView.ViewHolder(binding.root){
        fun asign(item: Task){
            binding.titleTv.text = item.title
            binding.timeTv.text = item.timeStamp
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding = RecyclerItemViewBinding.inflate(LayoutInflater.from(parent.context))

        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.asign(TaskList.taskList[position])
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}