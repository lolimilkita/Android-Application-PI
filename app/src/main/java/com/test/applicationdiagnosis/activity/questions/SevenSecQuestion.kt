package com.test.applicationdiagnosis.activity.questions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import com.test.applicationdiagnosis.R

class SevenSecQuestion : AppCompatActivity(), View.OnClickListener {
    private var q12YesChecked = false
    private var setResult: String = "blank"
    private var totalTrue: Int = 0
    private var setTotalQuestion: String = ""

    companion object {
        const val EXTRA_TOTAL = "extra_total"
        const val EXTRA_TOTAL_QUESTION = "extra_total_question"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seven_sec_question)
        supportActionBar?.title = getString(R.string.acbar_question)

        totalTrue = intent.getIntExtra(FiveSecQuestion.EXTRA_TOTAL, 0)
        setTotalQuestion = intent.getStringExtra(FiveSecQuestion.EXTRA_TOTAL_QUESTION).toString()

        val btnNextSec: Button = findViewById(R.id.btn_next_sec7)
        btnNextSec.setOnClickListener(this)
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.id) {
                R.id.btn_yes_question12 ->
                    if (checked) {
                        q12YesChecked = true
                    }
                R.id.btn_no_question12 ->
                    if (checked) {
                        q12YesChecked = false
                    }
            }
            setResult = "notBlank"
        }
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_next_sec7 ->
                when (setResult) {
                    "blank" ->
                        Toast.makeText(this, "Anda harus memilih Ya/Tidak", Toast.LENGTH_SHORT).show()
                    "notBlank" ->
                        if (q12YesChecked) {
                            totalTrue += 1
                            setTotalQuestion += "12"
                            val moveWithDataIntent = Intent(this@SevenSecQuestion, EightSecQuestion::class.java)
                            moveWithDataIntent.putExtra(EightSecQuestion.EXTRA_TOTAL, totalTrue)
                            moveWithDataIntent.putExtra(EightSecQuestion.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (!q12YesChecked) {
                            val moveWithDataIntent = Intent(this@SevenSecQuestion, FourSecQuestion::class.java)
                            moveWithDataIntent.putExtra(FourSecQuestion.EXTRA_TOTAL, totalTrue)
                            moveWithDataIntent.putExtra(FourSecQuestion.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        }
                }
        }
    }
}