package com.example.mac.studykotlin

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.widget.TextView
import kotlinx.android.synthetic.main.layout.view.*


/**
 * Created by MAC on 2017/8/11.
 */


class ForecastListAdapter(map: DomainClasses.myResult, val itemClick: ForecastListAdapter.OnItemClickListener) : RecyclerView.Adapter<ForecastListAdapter.MyViewHolder>() {
    public interface OnItemClickListener {
        operator fun invoke(forecast: DomainClasses.Future)

    }

    var map: DomainClasses.myResult? = null

    init {
        this.map = map
    }

    override fun getItemCount(): Int {

        return map!!.size()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val inflate = LayoutInflater.from(parent!!.context).inflate(R.layout.layout, null)

        return MyViewHolder(inflate, itemClick)
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder!!.bindForecast(this.map!!.get(position))
    }

    class MyViewHolder(view: View,val itemClick: OnItemClickListener) : ViewHolder(view) {
        init {
        }

        fun bindForecast(future: DomainClasses.Future) {
            itemView.temperature.text=future.temperature
            itemView.setOnClickListener { itemClick(future) }
        }


    }
}


