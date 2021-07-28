package com.test.applicationdiagnosis.activity.info

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.test.applicationdiagnosis.R
import com.test.applicationdiagnosis.`object`.DataInfoPpok
import com.test.applicationdiagnosis.activity.AboutAppActivity
import com.test.applicationdiagnosis.activity.MainActivity
import com.test.applicationdiagnosis.adapter.AdapterInfoPpok
import com.test.applicationdiagnosis.data.InfoPpok
import com.test.applicationdiagnosis.databinding.ActivityPpokInfoBinding

class PpokInfoActivity : AppCompatActivity() {
    private lateinit var bindingPpokInfoBinding: ActivityPpokInfoBinding
    private val list: ArrayList<InfoPpok> = arrayListOf()

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingPpokInfoBinding = ActivityPpokInfoBinding.inflate(layoutInflater)
        setContentView(bindingPpokInfoBinding.root)
        supportActionBar?.hide()

        list.addAll(DataInfoPpok.listInfoPpok)

        bindingPpokInfoBinding.recyclerViewInfo.layoutManager = LinearLayoutManager(this,OrientationHelper.HORIZONTAL, false)
        bindingPpokInfoBinding.recyclerViewInfo.adapter = AdapterInfoPpok(list)

        bindingPpokInfoBinding.btnBackHome.setOnClickListener {
            val moveIntent = Intent(this@PpokInfoActivity, MainActivity::class.java)
            moveIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(moveIntent)
            finish()
        }

        bindingPpokInfoBinding.btnBack.setOnClickListener {
            val moveIntent = Intent(this@PpokInfoActivity, MainActivity::class.java)
            moveIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(moveIntent)
            finish()
        }

        bindingPpokInfoBinding.btnDeviceInfo.setOnClickListener {
            val moveIntent = Intent(this@PpokInfoActivity, AboutAppActivity::class.java)
            moveIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(moveIntent)
            finish()
        }
    }
}