package com.test.applicationdiagnosis.activity.info

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.test.applicationdiagnosis.`object`.DataInfoBronchitis
import com.test.applicationdiagnosis.activity.MainActivity
import com.test.applicationdiagnosis.adapter.AdapterInfoBronchitis
import com.test.applicationdiagnosis.data.InfoBronchitis
import com.test.applicationdiagnosis.databinding.ActivityBronchitisInfoBinding

class BronchitisInfoActivity : AppCompatActivity() {
    private lateinit var bindingBronchitisInfoBinding: ActivityBronchitisInfoBinding
    private val list: ArrayList<InfoBronchitis> = arrayListOf()

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingBronchitisInfoBinding = ActivityBronchitisInfoBinding.inflate(layoutInflater)
        setContentView(bindingBronchitisInfoBinding.root)

        list.addAll(DataInfoBronchitis.listInfoBronchitis)

        bindingBronchitisInfoBinding.recyclerViewInfo.layoutManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        bindingBronchitisInfoBinding.recyclerViewInfo.adapter = AdapterInfoBronchitis(list)

        bindingBronchitisInfoBinding.btnBackHome.setOnClickListener {
            val moveIntent = Intent(this@BronchitisInfoActivity, MainActivity::class.java)
            moveIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(moveIntent)
            finish()
        }
    }
}