package com.example.apptestenumero38.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apptestenumero38.R
import com.example.apptestenumero38.activity.HomeFeed
import kotlinx.android.synthetic.main.dados_main_service.view.*
import org.jetbrains.anko.image

class MainAdapter(val homeFeed: HomeFeed, val context: Context): RecyclerView.Adapter<CustomViewHolder>() {
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

        if ( true ) holder?.view?.iconStatus.image = context.getDrawable(R.drawable.icon_status_serve_true)
    }
}

class CustomViewHolder(val view : View) : RecyclerView.ViewHolder(view)