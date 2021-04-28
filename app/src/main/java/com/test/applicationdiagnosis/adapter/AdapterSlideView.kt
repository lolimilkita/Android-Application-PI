package com.test.applicationdiagnosis.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.applicationdiagnosis.activity.MainActivity
import com.test.applicationdiagnosis.R
import com.test.applicationdiagnosis.data.Slide
import com.test.applicationdiagnosis.activity.info.BronchitisInfoActivity
import com.test.applicationdiagnosis.activity.info.PpokInfoActivity
import com.test.applicationdiagnosis.activity.info.TbcInfoActivity
import com.test.applicationdiagnosis.activity.questions.FirstSecQuestion
import com.test.applicationdiagnosis.databinding.RowItemBinding

class AdapterSlideView(private val listSlide: ArrayList<Slide>): RecyclerView.Adapter<AdapterSlideView.ViewHolder>() {
    companion object{
        private val TAG = MainActivity::class.java.simpleName
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
//        var nameSlide: TextView = itemView.findViewById(R.id.name)
        private val binding = RowItemBinding.bind(itemView)
        fun bind(slide: Slide) {
            Glide.with(itemView)
                .load(slide.photo)
                .into(binding.imgItemSlide)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return ViewHolder(mView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listSlide[position])

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            Log.d(TAG, listSlide[position].name)
            when (listSlide[position].name) {
                "Slide1" -> {
                    val moveIntent = Intent(mContext, FirstSecQuestion::class.java)
                    mContext.startActivity(moveIntent)
                }
                "Slide2" -> {
                    val moveIntent = Intent(mContext, TbcInfoActivity::class.java)
                    mContext.startActivity(moveIntent)
                }
                "Slide3" -> {
                    val moveIntent = Intent(mContext, BronchitisInfoActivity::class.java)
                    mContext.startActivity(moveIntent)
                }
                "Slide4" -> {
                    val moveIntent = Intent(mContext, PpokInfoActivity::class.java)
                    mContext.startActivity(moveIntent)
                }
            }
        }

    }

    override fun getItemCount(): Int = listSlide.size
}