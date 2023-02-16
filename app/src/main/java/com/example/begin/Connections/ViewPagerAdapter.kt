package com.example.begin.Connections

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity!!) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 ->{ItemFragment()}
            1->{ItemFragment()}
            else -> {ItemFragment()}
        }
    }
}