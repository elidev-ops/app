package com.example.apptestenumero38

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.dados_main_service.view.*

class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {
    override fun getItemCount(): Int {
        return homeFeed.data.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        var layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.dados_main_service, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val resposta = homeFeed.data.get(position)
        holder?.view?.code?.text = resposta.email
        holder?.view?.produto?.text = resposta.first_name
        holder?.view?.cliente?.text = resposta.last_name
    }
}

class CustomViewHolder(val view : View) : RecyclerView.ViewHolder(view)