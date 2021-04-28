package com.test.applicationdiagnosis.`object`

import com.test.applicationdiagnosis.R
import com.test.applicationdiagnosis.data.Slide

object SlideData{
    private val slideNames = arrayOf("Slide1", "Slide2", "Slide3", "Slide4")

    private val slideImage = intArrayOf(
        R.drawable.ic_slide1,
        R.drawable.ic_slide2,
        R.drawable.ic_slide3,
        R.drawable.ic_slide4
    )

    val listData: ArrayList<Slide>
    get() {
        val list = arrayListOf<Slide>()
        for (position in slideNames.indices) {
            val slide = Slide()
            slide.name = slideNames[position]
            slide.photo = slideImage[position]
            list.add(slide)
        }
        return list
    }
}
