package com.test.applicationdiagnosis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast

class FiveSecQuestion : AppCompatActivity(), View.OnClickListener {
    private var question9_yes_checked = false
    private var setResult: String = "blank"
    private var totalTrue: Int = 0
    private var setTotalQuestion: String = ""

    companion object {
        const val EXTRA_TOTAL = "extra_total"
        const val EXTRA_TOTAL_QUESTION = "extra_total_question"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_five_sec_question)

        totalTrue = intent.getIntExtra(ThirdSecQuestion.EXTRA_TOTAL, 0)
        setTotalQuestion = intent.getStringExtra(ThirdSecQuestion.EXTRA_TOTAL_QUESTION).toString()

        val btnNextSec: Button = findViewById(R.id.btn_next_sec5)
        btnNextSec.setOnClickListener(this)
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.id) {
                R.id.btn_yes_question9 ->
                    if (checked) {
                        question9_yes_checked = true
                    }
                R.id.btn_no_question9 ->
                    if (checked){
                        question9_yes_checked = false
                    }
            }
            setResult = "notBlank"
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_next_sec5 ->
                when (setResult) {
                    "blank" ->
                        Toast.makeText(this, "Anda harus memilih Ya/Tidak", Toast.LENGTH_SHORT).show()
                    "notBlank" ->
                        if (question9_yes_checked) {
                            setTotalQuestion += "9"
                            totalTrue = totalTrue + 1
                            val moveWithDataIntent = Intent(this@FiveSecQuestion, SixSecQuestion::class.java)
                            moveWithDataIntent.putExtra(SixSecQuestion.EXTRA_TOTAL, totalTrue)
                            moveWithDataIntent.putExtra(SixSecQuestion.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        } else if (!question9_yes_checked) {
                            val moveWithDataIntent = Intent(this@FiveSecQuestion, SevenSecQuestion::class.java)
                            moveWithDataIntent.putExtra(SevenSecQuestion.EXTRA_TOTAL, totalTrue)
                            moveWithDataIntent.putExtra(SevenSecQuestion.EXTRA_TOTAL_QUESTION, setTotalQuestion)
                            startActivity(moveWithDataIntent)
                            finish()
                        }
                }
        }
    }
}