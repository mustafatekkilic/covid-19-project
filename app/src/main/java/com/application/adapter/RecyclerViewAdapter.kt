package com.application.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.covid_19.R
import com.application.model.IBaseModel
import com.application.viewholder.BaseViewHolder
import com.application.viewholder.PreventionViewHolder

/*
  Created by Muhammed Yusuf ÇİL
  19.04.2020 - 18:37    
  myusufcl7@gmail.com
*/

class RecyclerViewAdapter(
    var items: MutableList<IBaseModel>,
    var recyclerViewClickListener: IRecyclerViewClickListener
) : RecyclerView.Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            IBaseModel.TYPE_COVİD_VIRUSES_BY_COUNTRIES ->
                //TODO not done yet
                PreventionViewHolder(
                    layoutInflater.inflate(
                        R.layout.item_prevention,
                        parent,
                        false
                    )
                )
            else ->
                throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (items[position].type) {
            IBaseModel.TYPE_COVİD_VIRUSES_BY_COUNTRIES ->
                (holder as PreventionViewHolder).bindView(
                    items[position],
                    position,
                    recyclerViewClickListener
                )
        }
    }

    override fun getItemViewType(position: Int): Int { //  !!!Burayı sor!!!
        return items[position].type
    }
}