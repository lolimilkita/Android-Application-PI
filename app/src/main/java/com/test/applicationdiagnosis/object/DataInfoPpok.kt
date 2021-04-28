package com.test.applicationdiagnosis.`object`

import com.test.applicationdiagnosis.data.InfoPpok
import com.test.applicationdiagnosis.data.InfoTbc

object DataInfoPpok {
    private val infoNames = arrayOf("info1", "info2", "info3", "info4", "info5", "info6", "info7", "info8", "info9", "info10", "info11", "info12", "info13", "info14", "info15", "info16", "info17", "info18", "info19", "info20", "info21", "info22", "info23", "info24", "info25")

    private val infoData = arrayOf("Penyakit paru obstruktif kronis (PPOK) adalah peradangan pada paru-paru yang berkembang dalam jangka panjang. PPOK umumnya ditandai dengan sulit bernapas, batuk berdahak, dan mengi.",
            "Dua kondisi yang paling sering berkembang menjadi PPOK adalah bronkitis kronis dan emfisema. Pada bronkitis kronis, kerusakan terjadi pada saluran bronkus, sedangkan pada emfisema kerusakan terjadi pada alveolus.",
            "PPOK lebih sering menyerang orang berusia paruh baya yang merokok. Seiring waktu, penyakit ini akan makin memburuk dan berisiko menyebabkan penderitanya mengalami penyakit jantung dan kanker paru-paru.",
            "Selain itu, penyakit paru obstruktif kronis juga bisa meningkatkan risiko penderitanya terkena COVID-19. Menurut sebuah penelitian, orang yang menderita PPOK memiliki risiko 5 kali lipat lebih tinggi terkena COVID-19 dibandingkan dengan orang yang tidak menderita PPOK.",
            "Penyakit paru obstruktif kronis terjadi ketika saluran pernapasan dan paru-paru rusak serta mengalami peradangan. Beberapa kondisi yang dapat meningkatkan risiko seseorang menderita penyakit ini adalah",
            "1. Memiliki kebiasaan merokok atau sering terpapar asap rokok (perokok pasif)\n" +
                    "2. Terpapar polusi udara, misalnya dari debu jalanan, asap dari kendaraan, atau asap pabrik dan industri\n" +
                    "3. Menderita penyakit asma, tuberkulosis, infeksi HIV, dan kelainan genetik yang menyebabkan kekurangan protein alpha-1-antitrypsin (AAt)\n" +
                    "4. Memiliki keluarga dengan riwayat PPOK\n" +
                    "5. Berusia 40 tahun ke atas\n" +
                    "6. Berjenis kelamin wanita",
            "GEJALA",
            "PPOK berkembang secara perlahan dan tidak menunjukkan gejala khusus pada tahap awal. Gejalanya baru muncul setelah bertahun-tahun, ketika sudah terjadi kerusakan yang signifikan pada paru-paru. Sejumlah gejala yang biasanya dialami oleh penderita PPOK adalah",
            "1. Batuk tidak kunjung sembuh yang dapat disertai dahak\n" +
                    "2. Napas tersengal-sengal, terutama saat melakukan aktivitas fisik\n" +
                    "3. Berat badan menurun\n" +
                    "4. Nyeri dada\n" +
                    "5. Mengi\n" +
                    "6. Pembengkakan di tungkai dan kaki\n" +
                    "7. Lemas",
            "Segera lakukan pemeriksaan ke dokter apabila mengalami gejala tadi, terutama jika disertai dengan keluhan berikut",
            "1. Demam\n" +
                    "2. Jantung berdebar\n" +
                    "3. Bibir dan ujung jari berwarna kebiruan\\n\" +\n" +
                    "4. Napas tersengal sampai tidak bisa berbicara\\n\" +\n" +
                    "5. Linglung dan sulit berkonsentrasi",
            "PENGOBATAN",
            "Sampai saat ini, penyakit paru obstruktif kronis belum bisa disembuhkan sepenuhnya. Namun, pengobatan dapat membantu meredakan gejala dan menghambat perkembangan penyakit ini, sehingga pasien dapat menjalani aktivitas dengan normal. Berikut ini adalah beberapa metode penanganan PPOK",
            "Obat-obatan",
            "Obat yang biasanya digunakan untuk meredakan gejala PPOK adalah obat hirup (inhaler). Tergantung pada kondisi pasien, dokter dapat meresepkan obat-obatan di atas sebagai obat tunggal atau obat kombinasi. Jika obat hirup belum dapat meredakan gejala PPOK, dokter akan meresepkan obat minum berupa kapsul atau tablet.",
            "Terapi",
            "Terapi ini bertujuan untuk memberikan pasokan oksigen ke paru-paru. Pasien bisa menggunakan tabung oksigen portabel yang bisa dibawa ke mana saja.",
            "Rehabilitas paru-paru",
            "Rehabilitasi paru-paru atau fisioterapi dada bertujuan untuk mengajarkan pasien terapi fisik yang sesuai dengan kondisinya, pola makan yang tepat, serta untuk memberikan dukungan secara emosional dan psikologis.",
            "Alat bantu napas",
            "Jika gejalanya cukup serius, pasien harus menggunakan alat bantu napas yaitu mesin ventilator. Ventilator adalah mesin pemompa udara yang akan membantu pasien bernapas. Ventilator terhubung dengan saluran pernapasan pasien lewat selang yang dimasukkan hingga ke trakea dengan cara intubasi.",
            "Operasi",
            "Operasi dilakukan pada pasien yang gejalanya tidak dapat diredakan dengan obat-obatan atau terapi.",
            "Selain penanganan di atas, ada beberapa langkah yang harus dilakukan oleh pasien untuk memperlambat kerusakan pada paru-paru, yaitu",
            "1. Menghentikan kebiasaan merokok dan menghindari paparan asap rokok\n" +
                    "2. Menghindari polusi udara, seperti asap kendaraan atau pembakaran\n" +
                    "3. Menggunakan pelembap udara ruangan (air humidifier)\n" +
                    "4. Menjaga pola makan yang sehat, banyak minum, dan berolahraga secara rutin\n" +
                    "5. Menjalani vaksinasi secara rutin, seperti vaksin flu dan pneumokokus\n" +
                    "6. Memeriksakan diri ke dokter secara berkala agar kondisi kesehatan terpantau"
    )

    val listInfoPpok: ArrayList<InfoPpok>
        get() {
            val list = arrayListOf<InfoPpok>()
            for (position in infoNames.indices) {
                val item = InfoPpok()
                item.name = infoNames[position]
                item.info = infoData[position]
                list.add(item)
            }
            return list
        }
}