package com.example.expandablerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.expandablerecyclerview.databinding.ItemDesignBinding

class RecyclerAdapter(private val langList : List<LanguageData>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(val binding : ItemDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return langList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val binding = ItemDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val currentList = langList[position]
        holder.binding.tvLanguage.text = currentList.name
        holder.binding.tvDesc.text = currentList.desc
        holder.binding.ivLanguage.setImageResource(currentList.logo)

        val isExpandable : Boolean = currentList.isExpanded
        holder.binding.expandCard.visibility = if (isExpandable) View.VISIBLE else View.GONE
/*
        holder.binding.mainCard.setOnClickListener {
            currentList.isExpanded = !currentList.isExpanded
            notifyItemChanged(position)
        }

 */

        holder.binding.mainCard.setOnClickListener {
            val previouslyExpandedPosition = collapsePreviouslyExpandedItem()
            if (position == previouslyExpandedPosition) {
                currentList.isExpanded = false
                notifyItemChanged(position)
            } else {
                currentList.isExpanded = true
                notifyItemChanged(position)
                if (previouslyExpandedPosition != -1) {
                    notifyItemChanged(previouslyExpandedPosition)
                }
            }
        }
    }

    private fun collapsePreviouslyExpandedItem(): Int {
        val expandedPosition = langList.indexOfFirst { it.isExpanded }
        if (expandedPosition != -1) {
            langList[expandedPosition].isExpanded = false
        }
        return expandedPosition
    }
}