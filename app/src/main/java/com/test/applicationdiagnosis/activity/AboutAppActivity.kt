package com.test.applicationdiagnosis.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.test.applicationdiagnosis.R
import com.test.applicationdiagnosis.databinding.ActivityAboutAppBinding

class AboutAppActivity : AppCompatActivity() {
    private lateinit var bindingActivityAboutAppBinding: ActivityAboutAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingActivityAboutAppBinding = ActivityAboutAppBinding.inflate(layoutInflater)
        setContentView(bindingActivityAboutAppBinding.root)
        supportActionBar?.hide()

        bindingActivityAboutAppBinding.btnBack.setOnClickListener {
            val moveIntent = Intent(this@AboutAppActivity, MainActivity::class.java)
            moveIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(moveIntent)
            finish()
        }
    }
}