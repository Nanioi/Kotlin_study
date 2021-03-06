package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_pager.*

//fragment 3개
class TabPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)

        tab_layout.addTab(tab_layout.newTab().setText("One"))
        tab_layout.addTab(tab_layout.newTab().setText("Two"))
        tab_layout.addTab(tab_layout.newTab().setText("Three"))

        val pagerAdapter = FragmentPagerAdapter(supportFragmentManager,3)
        view_pager.adapter=pagerAdapter

        //tab과 pager 연동
        tab_layout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager.currentItem = tab!!.position
            } // tab클릭시 pager이동

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        // pager이동시 tab이동시키기
    }
}

class FragmentPagerAdapter(
    fragmentManager: FragmentManager,
    val tabCount:Int
):FragmentStatePagerAdapter(fragmentManager){
    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0->{
                return  Fragmentone()
            }
            1->{
                return Fragmenttwo()
            }
            2->{
                return Fragmentthree()
            }
            else->{
                return  Fragmentone()
            }
        }
    }
}