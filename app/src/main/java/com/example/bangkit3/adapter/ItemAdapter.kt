package com.example.bangkit3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bangkit3.R
import com.example.bangkit3.model.Item
import com.example.bangkit3.network.Event

class ItemAdapter(
    private val items: List<Event>,
    private val onItemClick: (Item) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.itemTitle)
        val description: TextView = itemView.findViewById(R.id.itemDescription)

        fun bind(event: Event) {
            title.text = event.name
            description.text = event.description
            itemView.setOnClickListener {
                val item = Item(
                    id = event.id,
                    name = event.name,
                    summary = event.summary,
                    description = event.description,
                    imageLogo = event.imageLogo,
                    mediaCover = event.mediaCover,
                    category = event.category,
                    ownerName = event.ownerName,
                    cityName = event.cityName,
                    quota = event.quota,
                    registrants = event.registrants,
                    beginTime = event.beginTime,
                    endTime = event.endTime,
                    link = event.link
                )
                onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}