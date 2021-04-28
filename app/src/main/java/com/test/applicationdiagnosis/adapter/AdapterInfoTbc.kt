package com.test.applicationdiagnosis.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.applicationdiagnosis.R
import com.test.applicationdiagnosis.data.InfoTbc
import com.test.applicationdiagnosis.databinding.RowInfoBinding

class AdapterInfoTbc(private val listInfo: ArrayList<InfoTbc>): RecyclerView.Adapter<AdapterInfoTbc.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = RowInfoBinding.bind(itemView)
        fun bind(infoTbc: InfoTbc) {
            binding.tvInfo.text = infoTbc.info
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterInfoTbc.ViewHolder {
        val mView =LayoutInflater.from(parent.context).inflate(R.layout.row_info, parent, false)
        return ViewHolder(mView)
    }

    override fun onBindViewHolder(holder: AdapterInfoTbc.ViewHolder, position: Int) {
        holder.bind(listInfo[position])
    }

    override fun getItemCount(): Int = listInfo.size
}