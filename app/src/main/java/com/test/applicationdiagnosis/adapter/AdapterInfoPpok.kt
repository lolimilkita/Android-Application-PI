package com.test.applicationdiagnosis.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.applicationdiagnosis.R
import com.test.applicationdiagnosis.data.InfoPpok
import com.test.applicationdiagnosis.databinding.RowInfoBinding

class AdapterInfoPpok(private val listInfo: ArrayList<InfoPpok>): RecyclerView.Adapter<AdapterInfoPpok.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = RowInfoBinding.bind(itemView)
        fun bind(infoPpok: InfoPpok) {
            binding.tvInfo.text = infoPpok.info
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.row_info, parent, false)
        return ViewHolder(mView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listInfo[position])
    }

    override fun getItemCount(): Int = listInfo.size
}