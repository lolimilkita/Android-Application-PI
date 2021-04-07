package com.test.applicationdiagnosis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isInvisible
import java.text.DecimalFormat

class ResultDiagnotic : AppCompatActivity(), View.OnClickListener {

    private val result_false_diagnotic: String = "Anda tidak memiliki penyakit TBC, Bronchitis, PPOK. Tetap jaga kesehatan YA :)"
    private val result_false_diagnotic2: String = "Anda tidak memiliki penyakit TBC, Bronchitis, PPOK. Namun jika batuk anda tidak kunjung sembuh, kami menyarankan untuk periksa kedokter. Tetap semangat menghadapi penyakit YA!"
    private val question1: String = "Anda merasakan gejala Demam"
    private val question2: String = "Anda merasakan gejala Lemas, Letih, Lesu"
    private val question3: String= "Anda merasakan gejala Batuk yang berlangsung lebih dari 14 hari"
    private val question4: String= "Anda merasakan gejala Batuk tidak kunjung sembuh yang dapat disertai dahak"
    private val question5: String = "Anda merasakan gejala Nyeri dada ketika batuk"
    private val question6: String = "Anda merasakan gejala Keringat dingin waktu malam hari"
    private val question7: String = "Anda merasakan gejala Tidak Nafsu Makan"
    private val question8: String = "Anda merasakan gejala Berat badan menurun"
    private val question9: String = "Anda merasakan gejala Mual dan muntah"
    private val question10: String = "Anda merasakan gejala Diare"
    private val question11: String = "Anda merasakan gejala Linglung, atau terjadi penurunan kesadaran"
    private val question12: String = "Anda merasakan gejala Susah bernafas ketika melakukan aktivitas fisik"
    private val question13: String = "Anda merasakan gejala Pembengkakan di tungkai dan kaki"
    private val question14: String = "Anda merasakan gejala Mengi"
    private val question15: String = "Anda merasakan gejala Nafas tersengal sampai tidak bisa berbicara"

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_diagnotic)

        totalTrue = intent.getIntExtra(FourSecQuestion.EXTRA_TOTAL, 0)
        totalTrueFromSixSec = intent.getIntExtra(SixSecQuestion.EXTRA_TOTAL_SIX, 0)
        totalTrueFromEightSec = intent.getIntExtra(EightSecQuestion.EXTRA_TOTAL_EIGHT, 0)
        setTotalQuestion = intent.getStringExtra(FourSecQuestion.EXTRA_TOTAL_QUESTION).toString()

        val tvTest: TextView = findViewById(R.id.test)
        tvTest.text = setTotalQuestion

        totalTrueFromFourSec = totalTrue

        val btnBackHome: Button = findViewById(R.id.btn_back_home)

        val tvDataResult: TextView = findViewById(R.id.tv_result_diagnotic)

        val tv_question1: TextView = findViewById(R.id.tv_question1)


        val result = intent.getStringExtra(EXTRA_RESULT)
        when (result) {
            "false_diagnotic" -> {
                tvDataResult.text = result_false_diagnotic
                val imgView: ImageView = findViewById(R.id.img_people2)
                imgView.setImageResource(R.drawable.positive_vote1)
            }
            "false_diagnotic2" -> {
                tvDataResult.text = result_false_diagnotic2
                val imgView: ImageView = findViewById(R.id.img_people2)
                imgView.setImageResource(R.drawable.positive_vote)
            }
            "pass_check4" -> {
                when (setTotalQuestion) {
                    "12345678" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question4 \n" +
                                "5. $question5 \n" +
                                "6. $question6 \n" +
                                "7. $question7 \n" +
                                "8. $question8"
                    }
                    "1235678" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question5 \n" +
                                "5. $question6 \n" +
                                "6. $question7 \n" +
                                "7. $question8"
                    }
                    "123567" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question5 \n" +
                                "5. $question6 \n" +
                                "6. $question7"
                    }
                    "123568" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question5 \n" +
                                "5. $question6 \n" +
                                "6. $question8"
                    }
                    "12356" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question5 \n" +
                                "5. $question6"
                    }
                    "1235" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question5"
                    }
                    "1234578" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question4 \n" +
                                "5. $question5 \n" +
                                "6. $question7 \n" +
                                "7. $question8"
                    }
                    "123457" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question4 \n" +
                                "5. $question5 \n" +
                                "6. $question7"
                    }
                    "12345" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question4 \n" +
                                "5. $question5"
                    }
                    "123456" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question4 \n" +
                                "5. $question5 \n" +
                                "6. $question6"
                    }
                    "1234568" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question4 \n" +
                                "5. $question5 \n" +
                                "6. $question6 \n" +
                                "7. $question8"
                    }
                    "1234567" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question4 \n" +
                                "5. $question5 \n" +
                                "6. $question6 \n" +
                                "7. $question7"
                    }
                }
                for (i in 8 downTo 4) {
                    if (totalTrueFromFourSec == i) {
                        persen = ((totalTrueFromFourSec.toDouble() / totalTbc.toDouble()) * 100)
                        val resultTbc = "Dari gejala-gejala yang Anda pilih, hasil diagnosa Anda adalah\nTuberkolusis (TBC) sebesar $persen %"
                        tvDataResult.text = resultTbc
                        val imgView: ImageView = findViewById(R.id.img_people2)
                        imgView.setImageResource(R.drawable.ic_infected)
                    }
                }
            }
            "pass_check6" -> {
                when (setTotalQuestion) {
                    "1234591011" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question4 \n" +
                                "5. $question5 \n" +
                                "6. $question9 \n" +
                                "7. $question10 \n" +
                                "8. $question11"
                    }
                    "123591011" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question5 \n" +
                                "5. $question9 \n" +
                                "6. $question10 \n" +
                                "7. $question11"
                    }
                    "1235911" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question5 \n" +
                                "5. $question9 \n" +
                                "6. $question11"
                    }
                    "1235910" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question5 \n" +
                                "5. $question9 \n" +
                                "6. $question10"
                    }
                    "12345911" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question4 \n" +
                                "5. $question5 \n" +
                                "6. $question9 \n" +
                                "7. $question11"
                    }
                    "12345910" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question4 \n" +
                                "5. $question5 \n" +
                                "6. $question9 \n" +
                                "7. $question10"
                    }
                }
                for (i in 8 downTo 5) {
                    if (totalTrueFromSixSec == i) {
                        persen = ((totalTrueFromSixSec.toDouble() / totalBronchitis.toDouble()) * 100)
                        val rounded = String.format("%.2f", persen)
                        val finalResult = "Dari gejala-gejala yang Anda pilih, hasil diagnosa Anda adalah\nBronkitis sebesar $rounded %"
                        tvDataResult.text = finalResult
                        val imgView: ImageView = findViewById(R.id.img_people2)
                        imgView.setImageResource(R.drawable.ic_infected)
                    }
                }
            }
            "pass_check8" -> {
                when (setTotalQuestion) {
                    "1234512131415" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question4 \n" +
                                "5. $question5 \n" +
                                "6. $question12 \n" +
                                "7. $question13 \n" +
                                "8. $question14 \n" +
                                "9. $question15"
                    }
                    "123512131415" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question5 \n" +
                                "5. $question12 \n" +
                                "6. $question13 \n" +
                                "7. $question14 \n" +
                                "8. $question15"
                    }
                    "1235121415" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question5 \n" +
                                "5. $question12 \n" +
                                "6. $question14 \n" +
                                "7. $question15"
                    }
                    "12351215" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question5 \n" +
                                "5. $question12 \n" +
                                "6. $question15"
                    }
                    "12351214" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question5 \n" +
                                "5. $question12 \n" +
                                "6. $question14"
                    }
                    "12351213" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question5 \n" +
                                "5. $question12 \n" +
                                "6. $question13"
                    }
                    "1235121314" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question5 \n" +
                                "5. $question12 \n" +
                                "6. $question13 \n" +
                                "7. $question14"
                    }
                    "1235121315" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question5 \n" +
                                "5. $question12 \n" +
                                "6. $question13 \n" +
                                "7. $question15"
                    }
                    "123512" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question5 \n" +
                                "5. $question12"
                    }
                    "1234512" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question4 \n" +
                                "5. $question5 \n" +
                                "6. $question12"
                    }
                    "123451213" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question4 \n" +
                                "5. $question5 \n" +
                                "6. $question12 \n" +
                                "7. $question13"
                    }
                    "123451214" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question4 \n" +
                                "5. $question5 \n" +
                                "6. $question12 \n" +
                                "7. $question14"
                    }
                    "123451215" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question4 \n" +
                                "5. $question5 \n" +
                                "6. $question12 \n" +
                                "7. $question15"
                    }
                    "12345121314" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question4 \n" +
                                "5. $question5 \n" +
                                "6. $question12 \n" +
                                "7. $question13 \n" +
                                "8. $question14"
                    }
                    "12345121315" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question4 \n" +
                                "5. $question5 \n" +
                                "6. $question12 \n" +
                                "7. $question13 \n" +
                                "8. $question15"
                    }
                    "12345121415" -> {
                        tv_question1.text = "1. $question1 \n" +
                                "2. $question2 \n" +
                                "3. $question3 \n" +
                                "4. $question4 \n" +
                                "5. $question5 \n" +
                                "6. $question12 \n" +
                                "7. $question14 \n" +
                                "8. $question15"
                    }
                }
                for (i in 9 downTo 5) {
                    if (totalTrueFromEightSec == i) {
                        persen = ((totalTrueFromEightSec.toDouble() / totalPpok.toDouble()) * 100)
                        val rounded = String.format("%.2f", persen)
                        val finalResult = "Dari gejala-gejala yang Anda pilih, hasil diagnosa Anda adalah\nPPOK (Penyakit Paru Obstruktif Kronis sebesar $rounded %"
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
                val moveIntent = Intent(this@ResultDiagnotic, MainActivity::class.java)
                startActivity(moveIntent)
                finish()
            }
        }
    }

    override fun onBackPressed() {
        // doing nothing on pressing back key
        return
    }
}