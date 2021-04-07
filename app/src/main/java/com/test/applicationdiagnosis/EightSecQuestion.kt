package com.test.applicationdiagnosis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast

class EightSecQuestion : AppCompatActivity(), View.OnClickListener {
    private var question13_yes_checked = false
    private var question14_yes_checked = false
    private var question15_yes_checked = false
    private var setResult: String = "blank"
    private var totalTrue: Int = 0
    private var setTotalQuestion: String = ""

    companion object {
        const val EXTRA_TOTAL = "extra_total"
        const val EXTRA_TOTAL_EIGHT = "extra_total_eight"
        const val EXTRA_TOTAL_QUESTION = "extra_total_question"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eight_sec_question)

        totalTrue = intent.getIntExtra(SevenSecQuestion.EXTRA_TOTAL, 0)
        setTotalQuestion = intent.getStringExtra(SevenSecQuestion.EXTRA_TOTAL_QUESTION).toString()

        val btnNextSec: Button = findViewById(R.id.btn_next_sec8)
        btnNextSec.setOnClickListener(this)
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.id) {
                R.id.btn_yes_question13 ->
                    if (checked) {
                        question13_yes_checked = true
                    }
                R.id.btn_no_question13 ->
                    if (checked) {
                        question13_yes_checked = false
                    }
                R.id.btn_yes_question14 ->
                    if (checked) {
                        question14_yes_checked = true
                    }
                R.id.btn_no_question14 ->
                    if (checked) {
                        question14_yes_checked = false
                    }
                R.id.btn_yes_question15 ->
                    if (checked) {
                        question15_yes_checked = true
                    }
                R.id.btn_no_question15 ->
                    if (checked) {
                        question15_yes_checked = false
                    }
            }
            setResult = "notBlank"
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_next_sec8 ->
                when (setResult) {
                    "blank" ->
                        Toast.makeText(this, "Anda harus memilih Ya/Tidak", Toast.LENGTH_SHORT).show()
                    "notBlank" ->
                        if (question13_yes_checked && question14_yes_checked && question15_yes_checked) {
                            totalTrue += 3
                            setResult = "pass_check8"
                            setTotalQuestion += "131415"
                            val moveWithDataIntent = Intent(this@EightSecQuestion, ResultDiagnotic::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_EIGHT, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (!question13_yes_checked && !question14_yes_checked && !question15_yes_checked) {
                            setResult = "pass_check8"
                            val moveWithDataIntent = Intent(this@EightSecQuestion, ResultDiagnotic::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_EIGHT, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (question13_yes_checked && question14_yes_checked && !question15_yes_checked) {
                            totalTrue += 2
                            setTotalQuestion += "1314"
                            setResult = "pass_check8"
                            val moveWithDataIntent = Intent(this@EightSecQuestion, ResultDiagnotic::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_EIGHT, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (question13_yes_checked && !question14_yes_checked && !question15_yes_checked) {
                            totalTrue += 1
                            setTotalQuestion += "13"
                            setResult = "pass_check8"
                            val moveWithDataIntent = Intent(this@EightSecQuestion, ResultDiagnotic::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_EIGHT, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (question13_yes_checked && !question14_yes_checked && question15_yes_checked) {
                            totalTrue += 2
                            setTotalQuestion += "1315"
                            setResult = "pass_check8"
                            val moveWithDataIntent = Intent(this@EightSecQuestion, ResultDiagnotic::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_EIGHT, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (!question13_yes_checked && question14_yes_checked && question15_yes_checked) {
                            totalTrue += 2
                            setTotalQuestion += "1415"
                            setResult = "pass_check8"
                            val moveWithDataIntent = Intent(this@EightSecQuestion, ResultDiagnotic::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_EIGHT, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (!question13_yes_checked && question14_yes_checked && !question15_yes_checked) {
                            totalTrue += 1
                            setTotalQuestion += "14"
                            setResult = "pass_check8"
                            val moveWithDataIntent = Intent(this@EightSecQuestion, ResultDiagnotic::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_EIGHT, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (!question13_yes_checked && !question14_yes_checked && question15_yes_checked) {
                            totalTrue += 1
                            setTotalQuestion += "15"
                            setResult = "pass_check8"
                            val moveWithDataIntent = Intent(this@EightSecQuestion, ResultDiagnotic::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_EIGHT, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        }
                }
        }
    }
}