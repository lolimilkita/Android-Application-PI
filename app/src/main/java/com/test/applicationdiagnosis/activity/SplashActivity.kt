package com.test.applicationdiagnosis.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.test.applicationdiagnosis.databinding.ActivitySplashBinding

class
SplashActivity : AppCompatActivity() {
    private lateinit var splashBinding: ActivitySplashBinding
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)
        supportActionBar?.hide()

        handler = Handler(mainLooper)
        handler.postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}