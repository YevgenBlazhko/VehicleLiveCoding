package com.example.swivllivecoding.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.swivllivecoding.R

class RvAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var vehicleList: List<Vehicle>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_vehicle, parent, false)
        return VehicleViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as VehicleViewHolder).bind(position)
    }

    override fun getItemCount(): Int {
        return vehicleList?.size ?: 0
    }

    fun updateRv(vehicleList: List<Vehicle>) {
        this.vehicleList = vehicleList
        notifyDataSetChanged()
    }

    inner class VehicleViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        private val name: TextView = view.findViewById(R.id.tv_vehicle_name)
        private val yearIssue: TextView = view.findViewById(R.id.tv_vehicle_year_issue)
        private val price: TextView = view.findViewById(R.id.tv_vehicle_price)

        fun bind(position: Int) {
            name.text = vehicleList?.get(position)?.name
            yearIssue.text = vehicleList?.get(position)?.yearIssue.toString()
            price.text = vehicleList?.get(position)?.price.toString()
        }
    }
}