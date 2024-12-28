package com.example.lottie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lottie.databinding.ItemBinding

class ItemAdapter(val itemList: ArrayList<Items>, val listener: (position: Int) -> Unit ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(items: Items){
            binding.apply{
                itemDesc.text = items.desc
                itemName.text = items.name
                itemPrice.text = items.price
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        return binding
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
        holder.itemView.setOnClickListener{
            listener(position)
        }
    }
}