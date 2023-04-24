package com.example.tzrikmstrs

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tzrikmstrs.ui.cameras.CamerasFragment
import com.example.tzrikmstrs.ui.doors.DoorsFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CamerasFragment()
            else -> DoorsFragment()
        }
    }

}