package com.test.applicationdiagnosis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class SixSecQuestion : AppCompatActivity(), View.OnClickListener {
    private var question10_yes_checked = false
    private var question11_yes_checked = false
    private var setResult: String = "blank"
    private var totalTrue: Int = 0
    private var setTotalQuestion: String = ""

    companion object {
        const val EXTRA_TOTAL = "extra_total"
        const val EXTRA_TOTAL_SIX = "extra_total_six"
        const val EXTRA_TOTAL_QUESTION = "extra_total_question"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_six_sec_question)

        totalTrue = intent.getIntExtra(FiveSecQuestion.EXTRA_TOTAL, 0)
        setTotalQuestion = intent.getStringExtra(FiveSecQuestion.EXTRA_TOTAL_QUESTION).toString()

        val btnNextSec: Button = findViewById(R.id.btn_next_sec6)
        btnNextSec.setOnClickListener(this)
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.id) {
                R.id.btn_yes_question10 ->
                    if (checked) {
                        question10_yes_checked = true
                    }
                R.id.btn_no_question10 ->
                    if (checked) {
                        question10_yes_checked = false
                    }
                R.id.btn_yes_question11 ->
                    if (checked) {
                        question11_yes_checked = true
                    }
                R.id.btn_no_question11 ->
                    if (checked) {
                        question11_yes_checked = false
                    }
            }
            setResult = "notBlank"
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_next_sec6 ->
                when (setResult) {
                    "blank" ->
                        Toast.makeText(this, "Anda harus memilih Ya/Tidak", Toast.LENGTH_SHORT).show()
                    "notBlank" ->
                        if (question10_yes_checked && question11_yes_checked) {
                            setResult = "pass_check6"
                            setTotalQuestion += "1011"
                            totalTrue = totalTrue + 2
                            val moveWithDataIntent = Intent(this@SixSecQuestion, ResultDiagnotic::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_SIX, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (!question10_yes_checked && !question11_yes_checked) {
                            setResult = "pass_check6"
                            val moveWithDataIntent = Intent(this@SixSecQuestion, ResultDiagnotic::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_SIX, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (!question10_yes_checked && question11_yes_checked) {
                            setResult = "pass_check6"
                            setTotalQuestion += "11"
                            totalTrue = totalTrue + 1
                            val moveWithDataIntent = Intent(this@SixSecQuestion, ResultDiagnotic::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_SIX, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (question10_yes_checked && !question11_yes_checked) {
                            setResult = "pass_check6"
                            setTotalQuestion += "10"
                            totalTrue = totalTrue + 1
                            val moveWithDataIntent = Intent(this@SixSecQuestion, ResultDiagnotic::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_SIX, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_RESULT, setResult)
                            startActivity(moveWithDataIntent)
                            finish()
                        }
                }
        }
    }
}