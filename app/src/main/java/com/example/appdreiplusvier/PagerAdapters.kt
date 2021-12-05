package com.example.appdreiplusvier

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class RGBPagerAdapter(fg: Fragment): FragmentStateAdapter(fg) {

    private val tabsNumber = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> RGBFragment1.newInstance("rgb1", "TAB 1")
            1 -> RGBFragment2.newInstance("rgb2", "TAB 2")
            else -> RGBFragment3.newInstance("rgb3", "TAB 3")
        }
    }

    override fun getItemCount(): Int {
        return tabsNumber
    }
}

class ImagePagerAdapter(fg: Fragment): FragmentStateAdapter(fg) {
    private val imageNumber = 5

    override fun createFragment(position: Int): Fragment {
        return ImageFragment.newInstance(position)
    }

    override fun getItemCount(): Int {
        return imageNumber
    }
}
