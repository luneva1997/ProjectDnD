package com.example.begin.presentation.adventures.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.begin.data.db.entities.Adventure
import com.example.begin.databinding.ItemAdventureBinding

typealias AdventureClickListener = (Adventure) -> Unit

class AdventuresListAdapter(
    private val adventureClickListener: AdventureClickListener,
) : RecyclerView.Adapter<AdventuresListAdapter.ViewHolder>() {

    val adventures: MutableList<Adventure> = mutableListOf()

    override fun getItemCount(): Int = adventures.size

    @SuppressLint("NotifyDataSetChanged")
    fun update(newItems: List<Adventure>) {
        adventures.apply {
            clear()
            addAll(newItems)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAdventureBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).root
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = ItemAdventureBinding.bind(holder.itemView)
        val adventure = adventures[position]
        with(binding) {
            root.setOnClickListener { adventureClickListener(adventure) }
            name.text = adventure.name
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}