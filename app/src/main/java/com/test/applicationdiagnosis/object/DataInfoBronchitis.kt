package com.test.applicationdiagnosis.`object`

import com.test.applicationdiagnosis.data.InfoBronchitis
import com.test.applicationdiagnosis.data.InfoTbc

object DataInfoBronchitis {
    private val infoNames = arrayOf("info1", "info2", "info3", "info4", "info5", "info6", "info7", "info8", "info9", "info10", "info11", "info12", "info13", "info14", "info15")

    private val infoData = arrayOf("Bronkitis adalah peradangan yang terjadi pada saluran utama pernapasan atau bronkus. Bronkus berfungsi sebagai saluran yang membawa udara dari dan menuju paru-paru. Seseorang yang menderita bronkitis biasanya ditandai dengan munculnya gejala batuk yang berlangsung selama satu minggu atau lebih.",
            "Secara umum, bronkitis terbagi menjadi dua tipe, yakni\n" +
                    "\nBronkitis Akut\n" +
                    "\nBronkitis Kronis",
            "Bronkitis akut. Kondisi ini umumnya dialami oleh anak berusia di bawah 5 tahun. Bronkitis tipe akut biasanya pulih dengan sendirinya dalam waktu satu minggu hingga 10 hari. Namun, batuk yang dialami dapat berlangsung lebih lama.",
            "Bronkitis kronis. Bronkitis tipe ini biasanya dialami oleh orang dewasa berusia 40 tahun ke atas. Bronkitis kronis dapat berlangsung hingga 2 bulan, dan merupakan salah satu penyakit paru obstruktif kronis (PPOK).",
            "GELAJA",
            "Gejala yang paling umum muncul pada penderita bronkitis adalah batuk. Batuk yang dialami dapat berupa batuk kering atau berdahak. Pada batuk berdahak, dahak yang dikeluarkan biasanya berwarna putih, kuning keabuan, atau hijau. Selain batuk, penderita bronkitis juga dapat merasakan gejala lain, seperti",
            "1. Lemas.\n" +
                    "2. Demam.\n" +
                    "3. Sesak napas.\n" +
                    "4. Sakit tenggorokan.\n" +
                    "5. Sakit kepala.\n" +
                    "6. Hidung tersumbat.\n" +
                    "7. Badan terasa pegal-pegal.",
            "Gejala-gejala selain batuk biasanya mereda dalam kurun waktu seminggu, sedangkan batuk dapat tetap berlangsung hingga beberapa minggu bahkan beberapa bulan setelahnya. Segera temui dokter jika gejala yang dialami berupa",
            "1. Batuk berlangsung lebih dari 3 minggu, atau menimbulkan rasa nyeri pada dada.\n" +
                    "2. Batuk mengeluarkan darah atau dahak berwarna gelap.\n" +
                    "3. Batuk terjadi terus-menerus (30 kali batuk dalam satu menit), bahkan hingga menimbulkan suara kasar dan mengganggu jam tidur.\n" +
                    "4. Berat badan menurun.\n" +
                    "5. Penurunan kesadaran.",
            "PENGOBATAN",
            "Penanganan bronkitis pada tiap pasien dapat berbeda, tergantung keparahan dan kondisi pasien secara menyeluruh. Pada bronkitis akut atau yang tergolong ringan, gejala yang muncul akan mereda dengan sendirinya dalam beberapa minggu. Namun, jika bronkitis berlangsung berlarut-larut atau terasa sangat mengganggu, dokter biasanya akan meresepkan obat-obatan atau terapi yang bertujuan untuk meredakan gejala.",
            "Untuk meredakan gejala batuk, obat yang diberikan dapat berupa antitusif atau ekspektoran. Beberapa obat pereda batuk yang dapat digunakan meliputi",
            "1. Dextromethorpan\n" +
                    "2. Guaifenesin\n" +
                    "3. Codeine\n" +
                    "4. Noscapine\n" +
                    "5. Erdosteine",
            "Lalu, untuk meredakan gejala sesak napas, metode penanganannya dapat berupa",
            "1. Penggunaan bronkodilator.\n" +
                    "2. Pemberian kortikosteroid. Obat ini digunakan ketika bronkodilator tidak efektif. Dokter dapat memberikan kortikosteroid dalam bentuk tablet atau dihirup.\n" +
                    "3. Rehabilitasi paru. Metode ini mengandalkan komitmen pasien dalam berolahraga, menjaga pola makan, dan melatih pernapasan.",
            "Selain pemberian obat dan terapi khusus, pasien juga dapat melakukan perawatan mandiri di rumah untuk meredakan gejala. Beberapa upaya yang dapat dilakukan meliputi",
            "1. Minum air putih sebanyak 8-12 gelas perhari.\n" +
                    "2. Istirahat yang cukup.\n" +
                    "3. Menghirup uap air hangat. Hal ini dapat meredakan batuk dan mengencerkan lendir di saluran pernapasan sehingga mudah dibuang.\n" +
                    "4. Menghindari asap rokok.\n" +
                    "5. Menggunakan masker ketika melakukan aktivitas di luar rumah, untuk menghindari paparan zat berbahaya.\n" +
                    "6. Menggunakan masker khusus, jika batuk dan sesak napas semakin meningkat ketika terpapar udara dingin."

    )

    val listInfoBronchitis: ArrayList<InfoBronchitis>
    get() {
        val list = arrayListOf<InfoBronchitis>()
        for (position in infoNames.indices) {
            val item = InfoBronchitis()
            item.name = infoNames[position]
            item.info = infoData[position]
            list.add(item)
        }
        return list
    }
}
