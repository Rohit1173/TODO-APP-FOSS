package com.example.todo20

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.todo20.data.word


class todoadapter(private var items: MutableList<word>) :
    RecyclerView.Adapter<todoadapter.ViewHolder>() {


    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val txt: TextView = view.findViewById(R.id.txt)
        val card: CardView = view.findViewById(R.id.card)
        val context = view.context

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        return ViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.txt.text = item.work

    }
    override fun getItemCount(): Int {
        return items.size
    }


}