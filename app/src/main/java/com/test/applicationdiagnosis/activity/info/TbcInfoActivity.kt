package com.test.applicationdiagnosis.activity.info

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.test.applicationdiagnosis.`object`.DataInfoTbc
import com.test.applicationdiagnosis.activity.MainActivity
import com.test.applicationdiagnosis.data.InfoTbc
import com.test.applicationdiagnosis.adapter.AdapterInfoTbc
import com.test.applicationdiagnosis.databinding.ActivityTbcInfoBinding

class TbcInfoActivity : AppCompatActivity() {
    private lateinit var bindingTbcInfoBinding: ActivityTbcInfoBinding
    private val list: ArrayList<InfoTbc> = arrayListOf()

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingTbcInfoBinding = ActivityTbcInfoBinding.inflate(layoutInflater)
        setContentView(bindingTbcInfoBinding.root)

        list.addAll(DataInfoTbc.listInfoTbc)

        bindingTbcInfoBinding.recyclerViewInfo.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        bindingTbcInfoBinding.recyclerViewInfo.adapter = AdapterInfoTbc(list)

        bindingTbcInfoBinding.btnBackHome.setOnClickListener {
            val moveIntent = Intent(this@TbcInfoActivity, MainActivity::class.java)
            moveIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(moveIntent)
            finish()
        }
    }
}