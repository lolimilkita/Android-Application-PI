package com.test.applicationdiagnosis.activity.questions

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.test.applicationdiagnosis.R

class FourSecQuestion : AppCompatActivity(), View.OnClickListener {
    private var q7YesChecked = false
    private var q8YesChecked = false
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
        supportActionBar?.title = getString(R.string.acbar_question)

        totalTrue = intent.getIntExtra(EXTRA_TOTAL, 0)
        setTotalQuestion = intent.getStringExtra(ThirdSecQuestion.EXTRA_TOTAL_QUESTION).toString()

        val btnNextSec: Button = findViewById(R.id.btn_next_sec4)
        btnNextSec.setOnClickListener(this)
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.id) {
                R.id.btn_yes_question7 ->
                    if (checked) {
                        q7YesChecked = true
                    }
                R.id.btn_no_question7 ->
                    if (checked) {
                        q7YesChecked = false
                    }
                R.id.btn_yes_question8 ->
                    if (checked) {
                        q8YesChecked = true
                    }
                R.id.btn_no_question8 ->
                    if (checked) {
                        q8YesChecked = false
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
                        if (q7YesChecked && q8YesChecked) {
                            setResult = "pass_check4"
                            setTotalQuestion += "78"
                            totalTrue += 2
                            val moveWithDataIntent = Intent(this@FourSecQuestion, ResultDiagnosis::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_RESULT, setResult)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (!q7YesChecked && q8YesChecked) {
                            setResult = "pass_check4"
                            setTotalQuestion += "8"
                            totalTrue += 1
                            val moveWithDataIntent = Intent(this@FourSecQuestion, ResultDiagnosis::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_RESULT, setResult)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (q7YesChecked && !q8YesChecked) {
                            setResult = "pass_check4"
                            setTotalQuestion += "7"
                            totalTrue += 1
                            val moveWithDataIntent = Intent(this@FourSecQuestion, ResultDiagnosis::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_RESULT, setResult)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (!q7YesChecked && !q8YesChecked){
                            setResult = "pass_check4"
                            val moveWithDataIntent = Intent(this@FourSecQuestion, ResultDiagnosis::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL, totalTrue)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            moveWithDataIntent.putExtra(ResultDiagnosis.EXTRA_RESULT, setResult)
                            startActivity(moveWithDataIntent)
                            finish()
                        }
                }
        }
    }
}