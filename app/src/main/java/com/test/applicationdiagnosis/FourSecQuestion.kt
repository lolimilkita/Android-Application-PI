package com.test.applicationdiagnosis

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FourSecQuestion : AppCompatActivity(), View.OnClickListener {
    private var question7_yes_checked = false
    private var question8_yes_checked = false
    private var setResult: String = "blank"
    private var totalTrue: Int = 0
    private var setTotalQuestion: String = ""

    companion object {
        const val EXTRA_TOTAL = "extra_total"
        const val EXTRA_TOTAL_QUESTION = "extra_total_question"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four_sec_question)

        totalTrue = intent.getIntExtra(EXTRA_TOTAL, 0)
        setTotalQuestion = intent.getStringExtra(ThirdSecQuestion.EXTRA_TOTAL_QUESTION).toString()

        val tvTest: TextView = findViewById(R.id.test)
        tvTest.text = setTotalQuestion

        val btnNextSec: Button = findViewById(R.id.btn_next_sec4)
        btnNextSec.setOnClickListener(this)
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.id) {
                R.id.btn_yes_question7 ->
                    if (checked) {
                        question7_yes_checked = true
                    }
                R.id.btn_no_question7 ->
                    if (checked) {
                        question7_yes_checked = false
                    }
                R.id.btn_yes_question8 ->
                    if (checked) {
                        question8_yes_checked = true
                    }
                R.id.btn_no_question8 ->
                    if (checked) {
                        question8_yes_checked = false
                    }
            }
            setResult = "notBlank"
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_next_sec4 ->
                when (setResult) {
                    "blank" ->
                        Toast.makeText(this, "Anda harus memilih Ya/Tidak", Toast.LENGTH_SHORT).show()
                    "notBlank" ->
                        if (question7_yes_checked && question8_yes_checked) {
                            setResult = "pass_check4"
                            setTotalQuestion += "78"
                            totalTrue += 2
                            val moveWithDataIntent = Intent(this@FourSecQuestion, ResultDiagnotic::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_RESULT, setResult)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (!question7_yes_checked && question8_yes_checked) {
                            setResult = "pass_check4"
                            setTotalQuestion += "8"
                            totalTrue += 1
                            val moveWithDataIntent = Intent(this@FourSecQuestion, ResultDiagnotic::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_RESULT, setResult)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (question7_yes_checked && !question8_yes_checked) {
                            setResult = "pass_check4"
                            setTotalQuestion += "7"
                            totalTrue += 1
                            val moveWithDataIntent = Intent(this@FourSecQuestion, ResultDiagnotic::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_RESULT, setResult)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (!question7_yes_checked && !question8_yes_checked){
                            setResult = "pass_check4"
                            val moveWithDataIntent = Intent(this@FourSecQuestion, ResultDiagnotic::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_RESULT, setResult)
                            startActivity(moveWithDataIntent)
                            finish()
                        }
                }
        }
    }
}