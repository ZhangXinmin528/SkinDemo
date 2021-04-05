package com.coding.zxm.skindemo.ui

import androidx.fragment.app.Fragment
import com.coding.zxm.skindemo.R
import com.coding.zxm.skindemo.base.BaseActivity
import com.coding.zxm.skindemo.ui.fragment.FindFragment
import com.coding.zxm.skindemo.ui.fragment.HomeFragment
import com.coding.zxm.skindemo.ui.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private val fragments = ArrayList<Fragment>()

    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initParamsAndValues() {

        fragments.add(HomeFragment.newInstance())
        fragments.add(FindFragment.newInstance())
        fragments.add(MineFragment.newInstance())
    }

    override fun initViews() {
        vp_home.adapter = HomePageAdapter(fragments, supportFragmentManager)

        //TODO:已禁用Viewpager的横向滑动
//        vp_home.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
//            override fun onPageSelected(position: Int) {
//                bottom_nav.menu.getItem(position).isChecked = true
//            }
//        })

        vp_home.offscreenPageLimit = 2

        bottom_nav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_home -> {
                    vp_home.currentItem = 0
                    true
                }

                R.id.action_gallery -> {
                    vp_home.currentItem = 1
                    true
                }

                R.id.action_mine -> {
                    vp_home.currentItem = 2
                    true

                }
                else -> false
            }
        }
    }
}