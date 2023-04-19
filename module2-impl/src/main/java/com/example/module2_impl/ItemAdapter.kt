package com.example.module2_impl

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.module2.R

class ItemAdapter(
    private val onClick: (text: String) -> Unit,
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private val list = arrayListOf<String>()

    @SuppressLint("NotifyDataSetChanged")
    fun bindData(data: List<String>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textField: TextView = view.findViewById(R.id.txt_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val string = list[position]
        holder.textField.text = string
        holder.itemView.setOnClickListener {
            onClick.invoke(string)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}