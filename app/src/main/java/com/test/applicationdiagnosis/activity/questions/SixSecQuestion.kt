package com.test.applicationdiagnosis.activity.questions

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import com.test.applicationdiagnosis.R

class SixSecQuestion : AppCompatActivity(), View.OnClickListener {
    private var q10YesChecked = false
    private var q11YesChecked = false
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
        supportActionBar?.title = getString(R.string.acbar_question)

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
                        q10YesChecked = true
                    }
                R.id.btn_no_question10 ->
                    if (checked) {
                        q10YesChecked = false
                    }
                R.id.btn_yes_question11 ->
                    if (checked) {
                        q11YesChecked = true
                    }
                R.id.btn_no_question11 ->
                    if (checked) {
                        q11YesChecked = false
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
                        if (q10YesChecked && q11YesChecked) {
                            setResult = "pass_check6"
                            setTotalQuestion += "1011"
                            totalTrue = totalTrue + 2
                            val moveWithDataIntent = Intent(this@SixSecQuestion, ResultDiagnosis::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_SIX, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (!q10YesChecked && !q11YesChecked) {
                            setResult = "pass_check6"
                            val moveWithDataIntent = Intent(this@SixSecQuestion, ResultDiagnosis::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_SIX, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (!q10YesChecked && q11YesChecked) {
                            setResult = "pass_check6"
                            setTotalQuestion += "11"
                            totalTrue = totalTrue + 1
                            val moveWithDataIntent = Intent(this@SixSecQuestion, ResultDiagnosis::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_SIX, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (q10YesChecked && !q11YesChecked) {
                            setResult = "pass_check6"
                            setTotalQuestion += "10"
                            totalTrue = totalTrue + 1
                            val moveWithDataIntent = Intent(this@SixSecQuestion, ResultDiagnosis::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_SIX, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_RESULT, setResult)
                            startActivity(moveWithDataIntent)
                            finish()
                        }
                }
        }
    }
}