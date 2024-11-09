package com.thoriq.mylist

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import com.thoriq.mylist.databinding.ItemLayoutBinding

class ItemAdapter(
    private val values: List<Note>,
) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        val index = item.id
        val stringQuote = "\"${item.title}\" -${item.content}"
        holder.binding.itemNumber.text = index.toString()
        holder.binding.content.text = stringQuote
        holder.binding.root.setOnClickListener {
            val action = ItemFragmentDirections.actionItemFragment3ToUpdateFragment(item)
            holder.binding.root.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

}