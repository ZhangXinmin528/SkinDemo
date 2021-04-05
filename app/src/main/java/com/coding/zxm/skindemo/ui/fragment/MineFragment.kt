package com.coding.zxm.skindemo.ui.fragment

import android.view.View
import com.coding.zxm.skindemo.R
import com.coding.zxm.skindemo.base.BaseFragment

/**
 * Created by ZhangXinmin on 2021/04/05.
 * Copyright (c) 4/5/21 . All rights reserved.
 */
class MineFragment : BaseFragment() {
    companion object {
        fun newInstance(): MineFragment {
            return MineFragment()
        }
    }

    override fun setLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initParamsAndValues() {

    }

    override fun initViews(rootView: View) {

    }
}