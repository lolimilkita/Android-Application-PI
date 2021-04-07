package com.test.applicationdiagnosis

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FirstSecQuestion : AppCompatActivity(), View.OnClickListener {
    private var q1YesCheck = false
    private var q2YesCheck = false
    private var q3YesCheck = false
    private var setResult: String = "blank"
    private var setTotalQuestion: String = ""
    private var totalTrue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_sec_question)

        val btnNextSec1: Button = findViewById(R.id.btn_next_sec1)
        btnNextSec1.setOnClickListener(this)
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.id) {
                R.id.btn_yes_question1 ->
                    if (checked) {
                        q1YesCheck = true
                    }
                R.id.btn_no_question1 ->
                    if (checked) {
                        q1YesCheck = false
                    }
                R.id.btn_yes_question2 ->
                    if (checked) {
                        q2YesCheck = true
                    }
                R.id.btn_no_question2 ->
                    if (checked) {
                        q2YesCheck = false
                    }
                R.id.btn_yes_question3 ->
                    if (checked) {
                        q3YesCheck = true
                    }
                R.id.btn_no_question3 ->
                    if (checked) {
                        q3YesCheck = false
                    }
            }
            setResult = "notBlank"
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_next_sec1 -> {
                when (setResult) {
                    "blank" ->
                        Toast.makeText(this, "Anda harus memilih Ya/Tidak", Toast.LENGTH_SHORT).show()
                    "notBlank" ->
                        if (q1YesCheck && q2YesCheck && q3YesCheck) {
                            setTotalQuestion = "123"
                            totalTrue += 3
                            val moveWithDataIntent = Intent(this@FirstSecQuestion, SecondSecQuestion::class.java)
                            moveWithDataIntent.putExtra(SecondSecQuestion.EXTRA_TOTAL, totalTrue)
                            moveWithDataIntent.putExtra(SecondSecQuestion.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else {
                            setResult = "false_diagnotic"
                            val moveWithDataIntent = Intent(this@FirstSecQuestion, ResultDiagnotic::class.java)
                            moveWithDataIntent.putExtra(ResultDiagnotic.EXTRA_RESULT, setResult)
                            startActivity(moveWithDataIntent)
                            finish()
                        }
                }
            }
        }
    }
}