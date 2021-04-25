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

class SecondSecQuestion : AppCompatActivity(), View.OnClickListener {
    private var q4YesCheck = false
    private var q5YesCheck = false
    private var setResult: String = "blank"
    private var totalTrue: Int = 0
    private var setTotalQuestion: String = ""

    companion object {
        const val EXTRA_TOTAL = "extra_total"
        const val EXTRA_TOTAL_QUESTION = "extra_total_question"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_sec_question)
        supportActionBar?.title = getString(R.string.acbar_question)

        totalTrue = intent.getIntExtra(EXTRA_TOTAL, 0)
        setTotalQuestion = intent.getStringExtra(EXTRA_TOTAL_QUESTION).toString()

        val btnNextSec1: Button = findViewById(R.id.btn_next_sec2)
        btnNextSec1.setOnClickListener(this)
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.id) {
                R.id.btn_yes_question4 ->
                    if (checked) {
                        q4YesCheck = true
                    }
                R.id.btn_no_question4 ->
                    if (checked) {
                        q4YesCheck = false
                    }
                R.id.btn_yes_question5 ->
                    if (checked) {
                        q5YesCheck = true
                    }
                R.id.btn_no_question5 ->
                    if (checked) {
                        q5YesCheck = false
                    }
            }
            setResult = "notBlank"
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_next_sec2 ->
                when (setResult) {
                    "blank" ->
                        Toast.makeText(this, "Anda harus memilih Ya/Tidak", Toast.LENGTH_SHORT).show()
                    "notBlank" ->
                        if (q4YesCheck && q5YesCheck) {
                            setTotalQuestion += "45"
                            totalTrue += 2
                            val moveWithDataIntent = Intent(this@SecondSecQuestion, ThirdSecQuestion::class.java)
                            moveWithDataIntent.putExtra(ThirdSecQuestion.EXTRA_TOTAL, totalTrue)
                            moveWithDataIntent.putExtra(ThirdSecQuestion.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (!q4YesCheck && q5YesCheck) {
                            setTotalQuestion += "5"
                            totalTrue += 1
                            val moveWithDataIntent = Intent(this@SecondSecQuestion, ThirdSecQuestion::class.java)
                            moveWithDataIntent.putExtra(ThirdSecQuestion.EXTRA_TOTAL, totalTrue)
                            moveWithDataIntent.putExtra(ThirdSecQuestion.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (q4YesCheck && !q5YesCheck){
                            setResult = "false_diagnosis2"
                            setTotalQuestion = "4"
                            val moveWithDataIntent = Intent(this@SecondSecQuestion, ResultDiagnosis::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (!q4YesCheck && !q5YesCheck) {
                            setResult = "false_diagnosis"
                            setTotalQuestion = "123"
                            val moveWithDataIntent = Intent(this@SecondSecQuestion, ResultDiagnosis::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_RESULT, setResult)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        }
                }
        }
    }
}