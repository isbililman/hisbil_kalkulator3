package com.example.hisbil_kalkulator1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapater(private val dataset: ArrayList<DataKalku>) :
    RecyclerView.Adapter<Adapater.ViweHolder>() {
    class ViweHolder(view: View) : RecyclerView.ViewHolder(view) {
        val Hasil = view.findViewById<TextView>(R.id.hasiladpter)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViweHolder {
        return ViweHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_adapater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViweHolder, position: Int) {
        val data = dataset[position]
        holder.Hasil.text = data.hasil.toString().toDouble().toString()
    }

    override fun getItemCount(): Int = dataset.size
}
