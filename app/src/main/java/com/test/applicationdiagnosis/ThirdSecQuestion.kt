package com.test.applicationdiagnosis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class ThirdSecQuestion : AppCompatActivity(), View.OnClickListener {
    private var question6_yes_checked = false
    private var setResult: String = "blank"
    private var totalTrue: Int = 0
    private var setTotalQuestion: String = ""

    companion object {
        const val EXTRA_TOTAL = "extra_total"
        const val EXTRA_TOTAL_QUESTION = "extra_total_question"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_sec_question)

        totalTrue = intent.getIntExtra(SecondSecQuestion.EXTRA_TOTAL, 0)
        setTotalQuestion = intent.getStringExtra(SecondSecQuestion.EXTRA_TOTAL_QUESTION).toString()

        val tvTest: TextView = findViewById(R.id.test)
        tvTest.text = setTotalQuestion

        val btnNextSec: Button = findViewById(R.id.btn_next_sec3)
        btnNextSec.setOnClickListener(this)
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.id) {
                R.id.btn_yes_question6 ->
                    if (checked) {
                        question6_yes_checked = true
                    }
                R.id.btn_no_question6 ->
                    if (checked) {
                        question6_yes_checked = false
                    }
            }
            setResult = "notBlank"
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_next_sec3 ->
                when (setResult) {
                    "blank" ->
                        Toast.makeText(this, "Anda harus memilih Ya/Tidak", Toast.LENGTH_SHORT).show()
                    "notBlank" ->
                        if (question6_yes_checked) {
                            setTotalQuestion += "6"
                            totalTrue += 1
                            val moveWithDataIntent = Intent(this@ThirdSecQuestion, FourSecQuestion::class.java)
                            moveWithDataIntent.putExtra(FourSecQuestion.EXTRA_TOTAL, totalTrue)
                            moveWithDataIntent.putExtra(FourSecQuestion.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (!question6_yes_checked) {
                            val moveWithDataIntent = Intent(this@ThirdSecQuestion, FiveSecQuestion::class.java)
                            moveWithDataIntent.putExtra(FiveSecQuestion.EXTRA_TOTAL, totalTrue)
                            moveWithDataIntent.putExtra(FiveSecQuestion.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        }

                }
        }
    }
}