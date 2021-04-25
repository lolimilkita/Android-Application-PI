package com.test.applicationdiagnosis.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.applicationdiagnosis.databinding.ActivityPpokInfoBinding

class PpokInfoActivity : AppCompatActivity() {
    private lateinit var bindingPpokInfoBinding: ActivityPpokInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingPpokInfoBinding = ActivityPpokInfoBinding.inflate(layoutInflater)
        setContentView(bindingPpokInfoBinding.root)
    }
}