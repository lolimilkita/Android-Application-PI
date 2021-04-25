package com.test.applicationdiagnosis.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.applicationdiagnosis.databinding.ActivityTbcInfoBinding

class TbcInfoActivity : AppCompatActivity() {
    private lateinit var bindingTbcInfoBinding: ActivityTbcInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingTbcInfoBinding = ActivityTbcInfoBinding.inflate(layoutInflater)
        setContentView(bindingTbcInfoBinding.root)
    }
}