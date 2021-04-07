package com.test.applicationdiagnosis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStartDiagno: Button = findViewById(R.id.btn_start_detection)
        btnStartDiagno.setOnClickListener (this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_start_detection -> {
                val moveIntent = Intent(this@MainActivity, FirstSecQuestion::class.java)
                startActivity(moveIntent)
            }
        }
    }
}