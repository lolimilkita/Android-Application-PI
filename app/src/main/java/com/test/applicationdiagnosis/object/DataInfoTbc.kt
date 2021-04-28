package com.test.applicationdiagnosis.`object`

import com.test.applicationdiagnosis.data.InfoTbc

object DataInfoTbc {
    private val infoNames = arrayOf("info1", "info2", "info3", "info4", "info5", "info6", "info7", "info8", "info9", "info10", "info11", "info12", "info13")

    private val infoData = arrayOf("TBC (Tuberkulosis) yang juga dikenal dengan TB adalah penyakit paru-paru akibat kuman Mycobacterium tuberculosis. TBC akan menimbulkan gejala berupa batuk yang berlangsung lama (lebih dari 3 minggu), biasanya berdahak, dan terkadang mengeluarkan darah.",
            "Kuman TBC tidak hanya menyerang paru-paru, tetapi juga bisa menyerang tulang, usus, atau kelenjar. Penyakit ini ditularkan dari percikan ludah yang keluar penderita TBC, ketika berbicara, batuk, atau bersin. Penyakit ini lebih rentan terkena pada seseorang yang kekebalan tubuhnya rendah, misalnya penderita HIV.",
            "GEJALA",
            "Selain menimbulkan gejala berupa batuk yang berlangsung lama, penderita TBC juga akan merasakan beberapa gejala lain, seperti",
            "1. Batuk yang berlangsung lama (3 minggu atau lebih), biasanya berdahak.\n" +
                    "2. Batuk mengeluarkan darah.\n" +
                    "3. Berkeringat pada malam hari.\n" +
                    "4. Penurunan berat badan.\n" +
                    "5. Demam dan menggigil.\n" +
                    "6. Lemas.\n" +
                    "7. Nyeri dada saat bernapas atau batuk.\n" +
                    "8. Tidak nafsu makan.\n" +
                    "9. Lemas.",
            "PENGOBATAN",
            "Penyakit ini dapat disembuhkan dan jarang berakibat fatal jika penderita mengikuti saran dari dokter. Prinsip utama pengobatan TBC (tuberkulosis) adalah patuh untuk minum obat selama jangka waktu yang dianjurkan oleh dokter (minimal 6 bulan).",
            "Apabila berhenti meminum obat sebelum waktu yang dianjurkan, penyakit TBC yang Anda derita berpotensi menjadi kebal terhadap obat-obat yang biasa diberikan. Jika hal ini terjadi, TBC menjadi lebih berbahaya dan sulit diobati.",
            "Obat yang diminum merupakan kombinasi dari isoniazid, rifampicin, pyrazinamide dan ethambutol. Sama seperti semua obat, obat TBC juga memiliki efek samping, antara lain",
            "1. Warna urine menjadi kemerahan\n" +
                    "2. Menurunnya efektivitas pil KB, KB suntik, atau susuk\n" +
                    "3. Gangguan penglihatan\n" +
                    "4. Gangguan saraf\n" +
                    "5. Gangguan fungsi hati",
            "Karena efek samping yang mungkin terjadi, kombinasi obat dan dosisnya bisa berbeda pada beberapa kasus spesial, misalnya tuberkulosis pada anak dan ibu hamil.",
            "Untuk penderita yang sudah kebal dengan kombinasi obat tersebut, akan menjalani pengobatan dengan kombinasi obat yang lebih banyak dan lebih lama. Lama pengobatan dapat mencapai 18–24 bulan.",
            "Selama pengobatan, penderita TBC harus rutin menjalani pemeriksaan dahak untuk memantau keberhasilannya."
    )

    val listInfoTbc: ArrayList<InfoTbc>
    get() {
        val list = arrayListOf<InfoTbc>()
        for (position in infoNames.indices) {
            val item = InfoTbc()
            item.name = infoNames[position]
            item.info = infoData[position]
            list.add(item)
        }
        return list
    }
}