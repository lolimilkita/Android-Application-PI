package com.test.applicationdiagnosis.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.test.applicationdiagnosis.`object`.SlideData
import com.test.applicationdiagnosis.activity.*
import com.test.applicationdiagnosis.activity.info.BronchitisInfoActivity
import com.test.applicationdiagnosis.activity.info.PpokInfoActivity
import com.test.applicationdiagnosis.activity.info.TbcInfoActivity
import com.test.applicationdiagnosis.activity.questions.FirstSecQuestion
import com.test.applicationdiagnosis.adapter.AdapterSlideView
import com.test.applicationdiagnosis.data.Slide
import com.test.applicationdiagnosis.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingActivityMainBinding: ActivityMainBinding
    private val list: ArrayList<Slide> = arrayListOf()

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingActivityMainBinding.root)
        supportActionBar?.hide()

        list.addAll(SlideData.listData)

        bindingActivityMainBinding.recyclerViewSlide.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        bindingActivityMainBinding.recyclerViewSlide.adapter = AdapterSlideView(list)

        bindingActivityMainBinding.btnStartDetection.setOnClickListener {
            val moveIntent = Intent(this@MainActivity, FirstSecQuestion::class.java)
            startActivity(moveIntent)
        }

        bindingActivityMainBinding.btnInformationTbc.setOnClickListener {
            val moveIntent = Intent(this@MainActivity, TbcInfoActivity::class.java)
            startActivity(moveIntent)
        }

        bindingActivityMainBinding.btnInformationBronchitis.setOnClickListener {
            val moveIntent = Intent(this@MainActivity, BronchitisInfoActivity::class.java)
            startActivity(moveIntent)
        }

        bindingActivityMainBinding.btnInformationPpok.setOnClickListener {
            val moveIntent = Intent(this@MainActivity, PpokInfoActivity::class.java)
            startActivity(moveIntent)
        }

        bindingActivityMainBinding.btnDeviceInfo.setOnClickListener {
            val moveIntent = Intent(this@MainActivity, AboutAppActivity::class.java)
            startActivity(moveIntent)
        }
    }
}