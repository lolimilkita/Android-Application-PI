package com.test.applicationdiagnosis.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.applicationdiagnosis.databinding.ActivityBronchitisInfoBinding

class BronchitisInfoActivity : AppCompatActivity() {
    private lateinit var bindingBronchitisInfoBinding: ActivityBronchitisInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingBronchitisInfoBinding = ActivityBronchitisInfoBinding.inflate(layoutInflater)
        setContentView(bindingBronchitisInfoBinding.root)
    }
}