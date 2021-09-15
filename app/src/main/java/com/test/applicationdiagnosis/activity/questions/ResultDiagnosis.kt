package com.test.applicationdiagnosis.activity.questions

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.test.applicationdiagnosis.R
import com.test.applicationdiagnosis.activity.MainActivity

class ResultDiagnosis : AppCompatActivity(), View.OnClickListener {

    private var totalTrueFromFourSec: Int = 0
    private var totalTrueFromSixSec: Int = 0
    private var totalTrueFromEightSec: Int = 0
    private var totalTrue: Int = 0
    private var persen: Double = 0.0
    private val totalTbc: Int = 8
    private val totalBronchitis: Int = 8
    private val totalPpok: Int = 9
    private var setTotalQuestion: String = ""

    companion object {
        const val EXTRA_RESULT = "extra_result"
        const val EXTRA_TOTAL = "extra_total"
        const val EXTRA_TOTAL_SIX = "extra_total_six"
        const val EXTRA_TOTAL_EIGHT = "extra_total_eight"
        const val EXTRA_TOTAL_QUESTION = "extra_total_question"
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_diagnotic)
        supportActionBar?.title = getString(R.string.acbar_result)

        totalTrue = intent.getIntExtra(FourSecQuestion.EXTRA_TOTAL, 0)
        totalTrueFromSixSec = intent.getIntExtra(SixSecQuestion.EXTRA_TOTAL_SIX, 0)
        totalTrueFromEightSec = intent.getIntExtra(EightSecQuestion.EXTRA_TOTAL_EIGHT, 0)
        setTotalQuestion = intent.getStringExtra(FourSecQuestion.EXTRA_TOTAL_QUESTION).toString()

        totalTrueFromFourSec = totalTrue

        val btnBackHome: Button = findViewById(R.id.btn_back_home)

        val tvDataResult: TextView = findViewById(R.id.tv_result_diagnotic)

        val tvQuestionSelected: TextView = findViewById(R.id.tv_question_selected)

        when (intent.getStringExtra(EXTRA_RESULT)) {
            "false_diagnosis" -> {
                tvDataResult.text = getString(R.string.result_false_diagnosis)
                val imgView: ImageView = findViewById(R.id.img_people2)
                imgView.setImageResource(R.drawable.ic_positive_vote1)
                when (setTotalQuestion) {
                    "1" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)}"
                    }
                    "2" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms2)}"
                    }
                    "3" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms3)}"
                    }
                    "12" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)}"
                    }
                    "13" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms3)}"
                    }
                    "23" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms2)} \n" +
                                "2. ${getString(R.string.symptoms3)}"
                    }
                    "null" -> {
                        tvQuestionSelected.text = "Tidak Ada Gejala"
                    }
                }
            }
            "false_diagnosis2" -> {
                tvDataResult.text = getString(R.string.result_false_diagnosis_two)
                val imgView: ImageView = findViewById(R.id.img_people2)
                imgView.setImageResource(R.drawable.ic_positive_vote)
                when (setTotalQuestion) {
                    "1234" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms4)}"
                    }
                    "123" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)}"
                    }
                }
            }
            "pass_check4" -> {
                when (setTotalQuestion) {
                    "12345678" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms4)} \n" +
                                "5. ${getString(R.string.symptoms5)} \n" +
                                "6. ${getString(R.string.symptoms6)} \n" +
                                "7. ${getString(R.string.symptoms7)} \n" +
                                "8. ${getString(R.string.symptoms8)}"
                    }
                    "1235678" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms5)} \n" +
                                "5. ${getString(R.string.symptoms6)} \n" +
                                "6. ${getString(R.string.symptoms7)} \n" +
                                "7. ${getString(R.string.symptoms8)}"
                    }
                    "123567" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms5)} \n" +
                                "5. ${getString(R.string.symptoms6)} \n" +
                                "6. ${getString(R.string.symptoms7)}"
                    }
                    "123568" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms5)} \n" +
                                "5. ${getString(R.string.symptoms6)} \n" +
                                "6. ${getString(R.string.symptoms8)}"
                    }
                    "12356" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms5)} \n" +
                                "5. ${getString(R.string.symptoms6)}"
                    }
                    "1235" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms5)}"
                    }
                    "1234578" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms4)} \n" +
                                "5. ${getString(R.string.symptoms5)} \n" +
                                "6. ${getString(R.string.symptoms7)} \n" +
                                "7. ${getString(R.string.symptoms8)}"
                    }
                    "123457" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms4)} \n" +
                                "5. ${getString(R.string.symptoms5)} \n" +
                                "6. ${getString(R.string.symptoms7)}"
                    }
                    "12345" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms4)} \n" +
                                "5. ${getString(R.string.symptoms5)}"
                    }
                    "123456" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms4)} \n" +
                                "5. ${getString(R.string.symptoms5)} \n" +
                                "6. ${getString(R.string.symptoms6)}"
                    }
                    "1234568" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms4)} \n" +
                                "5. ${getString(R.string.symptoms5)} \n" +
                                "6. ${getString(R.string.symptoms6)} \n" +
                                "7. ${getString(R.string.symptoms8)}"
                    }
                    "1234567" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms4)} \n" +
                                "5. ${getString(R.string.symptoms5)} \n" +
                                "6. ${getString(R.string.symptoms6)} \n" +
                                "7. ${getString(R.string.symptoms7)}"
                    }
                    "123578" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms5)} \n" +
                                "5. ${getString(R.string.symptoms7)} \n" +
                                "6. ${getString(R.string.symptoms8)}"
                    }
                    "12357" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms5)} \n" +
                                "5. ${getString(R.string.symptoms7)}"
                    }
                    "12358" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms5)} \n" +
                                "5. ${getString(R.string.symptoms8)}"
                    }
                }
                for (i in 8 downTo 4) {
                    if (totalTrueFromFourSec == i) {
                        persen = ((totalTrueFromFourSec.toDouble() / totalTbc.toDouble()) * 100)
                        val resultTbc = "Dari gejala-gejala yang Anda pilih, hasil diagnosa Anda adalah\n" +
                                "Tuberkolusis (TBC) sebesar $persen % \n" +
                                "Segera periksakan diri ke dokter untuk mendapatkan penanganan lebih lanjut."
                        tvDataResult.text = resultTbc
                        val imgView: ImageView = findViewById(R.id.img_people2)
                        imgView.setImageResource(R.drawable.ic_infected)
                    }
                }
            }
            "pass_check6" -> {
                when (setTotalQuestion) {
                    "1234591011" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms4)} \n" +
                                "5. ${getString(R.string.symptoms5)} \n" +
                                "6. ${getString(R.string.symptoms9)} \n" +
                                "7. ${getString(R.string.symptoms10)} \n" +
                                "8. ${getString(R.string.symptoms11)}"
                    }
                    "123591011" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms5)} \n" +
                                "5. ${getString(R.string.symptoms9)} \n" +
                                "6. ${getString(R.string.symptoms10)} \n" +
                                "7. ${getString(R.string.symptoms11)}"
                    }
                    "1235911" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms5)} \n" +
                                "5. ${getString(R.string.symptoms9)} \n" +
                                "6. ${getString(R.string.symptoms11)}"
                    }
                    "1235910" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms5)} \n" +
                                "5. ${getString(R.string.symptoms9)} \n" +
                                "6. ${getString(R.string.symptoms10)}"
                    }
                    "12345911" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms4)} \n" +
                                "5. ${getString(R.string.symptoms5)} \n" +
                                "6. ${getString(R.string.symptoms9)} \n" +
                                "7. ${getString(R.string.symptoms11)}"
                    }
                    "12345910" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms4)} \n" +
                                "5. ${getString(R.string.symptoms5)} \n" +
                                "6. ${getString(R.string.symptoms9)} \n" +
                                "7. ${getString(R.string.symptoms10)}"
                    }
                    "123459" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms4)} \n" +
                                "5. ${getString(R.string.symptoms5)} \n" +
                                "6. ${getString(R.string.symptoms9)}"
                    }
                    "12359" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms5)} \n" +
                                "5. ${getString(R.string.symptoms9)}"
                    }
                }
                for (i in 8 downTo 5) {
                    if (totalTrueFromSixSec == i) {
                        persen = ((totalTrueFromSixSec.toDouble() / totalBronchitis.toDouble()) * 100)
                        val rounded = String.format("%.2f", persen)
                        val finalResult = "Dari gejala-gejala yang Anda pilih, hasil diagnosa Anda adalah\n" +
                                "Bronkitis sebesar $rounded % \n" +
                                "Segera periksakan diri ke dokter untuk mendapatkan penanganan lebih lanjut."
                        tvDataResult.text = finalResult
                        val imgView: ImageView = findViewById(R.id.img_people2)
                        imgView.setImageResource(R.drawable.ic_infected)
                    }
                }
            }
            "pass_check8" -> {
                when (setTotalQuestion) {
                    "1234512131415" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms4)} \n" +
                                "5. ${getString(R.string.symptoms5)} \n" +
                                "6. ${getString(R.string.symptoms12)} \n" +
                                "7. ${getString(R.string.symptoms13)} \n" +
                                "8. ${getString(R.string.symptoms14)} \n" +
                                "9. ${getString(R.string.symptoms15)}"
                    }
                    "123512131415" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms5)} \n" +
                                "5. ${getString(R.string.symptoms12)} \n" +
                                "6. ${getString(R.string.symptoms13)} \n" +
                                "7. ${getString(R.string.symptoms14)} \n" +
                                "8. ${getString(R.string.symptoms15)}"
                    }
                    "1235121415" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms5)} \n" +
                                "5. ${getString(R.string.symptoms12)} \n" +
                                "6. ${getString(R.string.symptoms14)} \n" +
                                "7. ${getString(R.string.symptoms15)}"
                    }
                    "12351215" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms5)} \n" +
                                "5. ${getString(R.string.symptoms12)} \n" +
                                "6. ${getString(R.string.symptoms15)}"
                    }
                    "12351214" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms5)} \n" +
                                "5. ${getString(R.string.symptoms12)} \n" +
                                "6. ${getString(R.string.symptoms14)} \n"
                    }
                    "12351213" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms5)} \n" +
                                "5. ${getString(R.string.symptoms12)} \n" +
                                "6. ${getString(R.string.symptoms13)} \n"
                    }
                    "1235121314" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms5)} \n" +
                                "5. ${getString(R.string.symptoms12)} \n" +
                                "6. ${getString(R.string.symptoms13)} \n" +
                                "7. ${getString(R.string.symptoms14)}"
                    }
                    "1235121315" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms5)} \n" +
                                "5. ${getString(R.string.symptoms12)} \n" +
                                "6. ${getString(R.string.symptoms13)} \n" +
                                "7. ${getString(R.string.symptoms15)}"
                    }
                    "123512" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms5)} \n" +
                                "5. ${getString(R.string.symptoms12)}"
                    }
                    "1234512" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms4)} \n" +
                                "5. ${getString(R.string.symptoms5)} \n" +
                                "6. ${getString(R.string.symptoms12)}"
                    }
                    "123451213" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms4)} \n" +
                                "5. ${getString(R.string.symptoms5)} \n" +
                                "6. ${getString(R.string.symptoms12)} \n" +
                                "7. ${getString(R.string.symptoms13)}"
                    }
                    "123451214" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms4)} \n" +
                                "5. ${getString(R.string.symptoms5)} \n" +
                                "6. ${getString(R.string.symptoms12)} \n" +
                                "7. ${getString(R.string.symptoms14)}"
                    }
                    "123451215" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms4)} \n" +
                                "5. ${getString(R.string.symptoms5)} \n" +
                                "6. ${getString(R.string.symptoms12)} \n" +
                                "9. ${getString(R.string.symptoms15)}"
                    }
                    "12345121314" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms4)} \n" +
                                "5. ${getString(R.string.symptoms5)} \n" +
                                "6. ${getString(R.string.symptoms12)} \n" +
                                "7. ${getString(R.string.symptoms13)} \n" +
                                "8. ${getString(R.string.symptoms14)}"
                    }
                    "12345121315" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms4)} \n" +
                                "5. ${getString(R.string.symptoms5)} \n" +
                                "6. ${getString(R.string.symptoms12)} \n" +
                                "7. ${getString(R.string.symptoms13)} \n" +
                                "8. ${getString(R.string.symptoms15)}"
                    }
                    "12345121415" -> {
                        tvQuestionSelected.text = "1. ${getString(R.string.symptoms1)} \n" +
                                "2. ${getString(R.string.symptoms2)} \n" +
                                "3. ${getString(R.string.symptoms3)} \n" +
                                "4. ${getString(R.string.symptoms4)} \n" +
                                "5. ${getString(R.string.symptoms5)} \n" +
                                "6. ${getString(R.string.symptoms12)} \n" +
                                "7. ${getString(R.string.symptoms14)} \n" +
                                "8. ${getString(R.string.symptoms15)}"
                    }
                }
                for (i in 9 downTo 5) {
                    if (totalTrueFromEightSec == i) {
                        persen = ((totalTrueFromEightSec.toDouble() / totalPpok.toDouble()) * 100)
                        val rounded = String.format("%.2f", persen)
                        val finalResult = "Dari gejala-gejala yang Anda pilih, hasil diagnosa Anda adalah\n" +
                                "PPOK (Penyakit Paru Obstruktif Kronis sebesar $rounded % \n" +
                                "Segera periksakan diri ke dokter untuk mendapatkan penanganan lebih lanjut."
                        tvDataResult.text = finalResult
                        val imgView: ImageView = findViewById(R.id.img_people2)
                        imgView.setImageResource(R.drawable.ic_infected)
                    }
                }
            }
        }
        btnBackHome.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_back_home -> {
                val moveIntent = Intent(this@ResultDiagnosis, MainActivity::class.java)
                moveIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(moveIntent)
                finish()
            }
        }
    }

}