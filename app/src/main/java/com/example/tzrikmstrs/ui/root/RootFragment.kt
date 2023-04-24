package com.example.tzrikmstrs.ui.root

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.tzrikmstrs.R
import com.example.tzrikmstrs.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class RootFragment : Fragment() {

    private var ctx: Context ?= null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_root, container, false)

        val tab = view.findViewById<TabLayout>(R.id.tab_layout)
        tab.tabIconTint = null
        val pager = view.findViewById<ViewPager2>(R.id.view_pager)
        pager.adapter = ViewPagerAdapter(ctx as FragmentActivity)

        TabLayoutMediator(tab, pager) {
            tb, pos ->
            when (pos) {
                0 -> {
                    tb.setText("Камеры")
                }
                1 -> {
                    tb.setText("Двери")
                }
            }
        }.attach()
        return view
    }
}