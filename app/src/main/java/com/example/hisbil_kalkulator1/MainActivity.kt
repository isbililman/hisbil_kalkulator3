package com.example.hisbil_kalkulator1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var bil1 : EditText
    private lateinit var bil2 : EditText
    private lateinit var batnmin: Button
    private lateinit var batnplus: Button
    private lateinit var batnkali: Button
    private lateinit var batnbagi: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter : RecyclerView.Adapter<*>
    private lateinit var viewManager : RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bil1 = findViewById(R.id.etbil1)
        bil2 = findViewById(R.id.etbil2)
        batnmin = findViewById(R.id.btnmin)
        batnplus = findViewById(R.id.btnplus)
        batnkali = findViewById(R.id.btnkali)
        batnbagi = findViewById(R.id.btnbagi)

        val data = ArrayList<DataKalku>()
        recyclerView = findViewById(R.id.listdata)

        batnmin.setOnClickListener {
            val kurang = bil1.text.toString().toDouble() - bil2.text.toString().toDouble()
            val hasil = DataKalku(kurang)
            data.add(hasil)
            recyclerAdapter.notifyDataSetChanged()
        }
        batnplus.setOnClickListener {
            val plus = bil1.text.toString().toDouble() + bil2.text.toString().toDouble()
            val hasil = DataKalku(plus)
            data.add(hasil)
            recyclerAdapter.notifyDataSetChanged()
        }
        batnkali.setOnClickListener {
            val kali = bil1.text.toString().toDouble() * bil2.text.toString().toDouble()
            val hasil = DataKalku(kali)
            data.add(hasil)
            recyclerAdapter.notifyDataSetChanged()
        }
        batnbagi.setOnClickListener {
            val bagi = bil1.text.toString().toDouble() / bil2.text.toString().toDouble()
            val hasil = DataKalku(bagi)
            data.add(hasil)
            recyclerAdapter.notifyDataSetChanged()
        }

        recyclerAdapter = Adapater(data)
        viewManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager
    }
}
