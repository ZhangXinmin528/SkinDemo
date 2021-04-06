package com.coding.zxm.skindemo.skin

import android.content.Context
import android.content.res.Configuration
import com.coding.zxm.skindemo.R
import com.qmuiteam.qmui.skin.QMUISkinManager
import com.zxm.utils.core.sp.SharedPreferencesUtil

/**
 * Created by ZhangXinmin on 2021/04/06.
 * Copyright (c) 4/6/21 . All rights reserved.
 */
class SkinManager private constructor(val context: Context) {

    companion object {
        const val SKIN_BLUE = 1
        const val SKIN_DARK = 2
        const val SKIN_WHITE = 3

        private var sInstance: SkinManager? = null

        fun getInstance(context: Context): SkinManager {
            if (sInstance == null) {
                sInstance = SkinManager(context)
                install(context)
            }
            return sInstance!!
        }

        private fun install(context: Context) {
            val skinManager = QMUISkinManager.defaultInstance(context)
            skinManager.addSkin(SKIN_BLUE, R.style.app_skin_blue)
            skinManager.addSkin(SKIN_DARK, R.style.app_skin_dark)
            skinManager.addSkin(SKIN_WHITE, R.style.app_skin_white)

            val isDarkMode =
                (context.resources.configuration.uiMode
                        and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES

            val skinIndex = SharedPreferencesUtil.get(context, SkinSPConstants.SKIN_INDEX, 1) as Int
            if (isDarkMode && skinIndex != SKIN_DARK) {
                skinManager.changeSkin(SKIN_DARK)
            } else if (!isDarkMode && skinIndex == SKIN_DARK) {
                skinManager.changeSkin(SKIN_BLUE)
            } else {
                skinManager.changeSkin(skinIndex)
            }
        }

    }

    fun changeSkin(index: Int) {
        QMUISkinManager.defaultInstance(context).changeSkin(index)
        SharedPreferencesUtil.put(context, SkinSPConstants.SKIN_INDEX, index)
    }

    fun getCurrentSkin(): Int {
        return QMUISkinManager.defaultInstance(context).currentSkin
    }

}