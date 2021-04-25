package com.test.applicationdiagnosis.activity.questions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import com.test.applicationdiagnosis.R

class EightSecQuestion : AppCompatActivity(), View.OnClickListener {
    private var q13YesChecked = false
    private var q14YesChecked = false
    private var q15YesChecked = false
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
        supportActionBar?.title = getString(R.string.acbar_question)

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
                        q13YesChecked = true
                    }
                R.id.btn_no_question13 ->
                    if (checked) {
                        q13YesChecked = false
                    }
                R.id.btn_yes_question14 ->
                    if (checked) {
                        q14YesChecked = true
                    }
                R.id.btn_no_question14 ->
                    if (checked) {
                        q14YesChecked = false
                    }
                R.id.btn_yes_question15 ->
                    if (checked) {
                        q15YesChecked = true
                    }
                R.id.btn_no_question15 ->
                    if (checked) {
                        q15YesChecked = false
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
                        if (q13YesChecked && q14YesChecked && q15YesChecked) {
                            totalTrue += 3
                            setResult = "pass_check8"
                            setTotalQuestion += "131415"
                            val moveWithDataIntent = Intent(this@EightSecQuestion, ResultDiagnosis::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_EIGHT, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (!q13YesChecked && !q14YesChecked && !q15YesChecked) {
                            setResult = "pass_check8"
                            val moveWithDataIntent = Intent(this@EightSecQuestion, ResultDiagnosis::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_EIGHT, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (q13YesChecked && q14YesChecked && !q15YesChecked) {
                            totalTrue += 2
                            setTotalQuestion += "1314"
                            setResult = "pass_check8"
                            val moveWithDataIntent = Intent(this@EightSecQuestion, ResultDiagnosis::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_EIGHT, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (q13YesChecked && !q14YesChecked && !q15YesChecked) {
                            totalTrue += 1
                            setTotalQuestion += "13"
                            setResult = "pass_check8"
                            val moveWithDataIntent = Intent(this@EightSecQuestion, ResultDiagnosis::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_EIGHT, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (q13YesChecked && !q14YesChecked && q15YesChecked) {
                            totalTrue += 2
                            setTotalQuestion += "1315"
                            setResult = "pass_check8"
                            val moveWithDataIntent = Intent(this@EightSecQuestion, ResultDiagnosis::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_EIGHT, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (!q13YesChecked && q14YesChecked && q15YesChecked) {
                            totalTrue += 2
                            setTotalQuestion += "1415"
                            setResult = "pass_check8"
                            val moveWithDataIntent = Intent(this@EightSecQuestion, ResultDiagnosis::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_EIGHT, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (!q13YesChecked && q14YesChecked && !q15YesChecked) {
                            totalTrue += 1
                            setTotalQuestion += "14"
                            setResult = "pass_check8"
                            val moveWithDataIntent = Intent(this@EightSecQuestion, ResultDiagnosis::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_EIGHT, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (!q13YesChecked && !q14YesChecked && q15YesChecked) {
                            totalTrue += 1
                            setTotalQuestion += "15"
                            setResult = "pass_check8"
                            val moveWithDataIntent = Intent(this@EightSecQuestion, ResultDiagnosis::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_EIGHT, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        }
                }
        }
    }
}