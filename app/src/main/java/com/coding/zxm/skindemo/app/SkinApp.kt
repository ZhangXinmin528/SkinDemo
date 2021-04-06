package com.coding.zxm.skindemo.app

import android.app.Application
import android.content.res.Configuration
import com.coding.zxm.skindemo.skin.SkinManager

/**
 * Created by ZhangXinmin on 2021/04/06.
 * Copyright (c) 4/6/21 . All rights reserved.
 */
class SkinApp : Application() {

    override fun onCreate() {
        super.onCreate()

        SkinManager.getInstance(this)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        //适配系统深色模式
        if ((newConfig.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES) {
            SkinManager.getInstance(this).changeSkin(SkinManager.SKIN_DARK)
        } else if (SkinManager.getInstance(this).getCurrentSkin() == SkinManager.SKIN_DARK) {
            SkinManager.getInstance(this).changeSkin(SkinManager.SKIN_BLUE)
        }
    }
}