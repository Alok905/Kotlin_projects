package com.example.viewbinding

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.viewbinding.databinding.RecyclerviewItemBinding

class MainAdapter(val taskList: List<Task>): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    class MainViewHolder(val itemBinding: RecyclerviewItemBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(task: Task) {
            itemBinding.timeTv.text = task.timeStamp
            itemBinding.titleTv.text = task.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context))

        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bindItem(taskList[position])
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

}