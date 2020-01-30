package com.example.aveditor.utils

import android.app.Activity
import android.content.Context
import android.opengl.ETC1.getWidth
import androidx.core.content.ContextCompat.getSystemService
import android.view.WindowManager
import android.util.DisplayMetrics





/**
 * Created by xusheng on 2020-01-26.
 */
object UIUtils {

    fun getScreenWidth(activity: Activity): Int {
        val manager = activity.windowManager
        val outMetrics = DisplayMetrics()
        manager.defaultDisplay.getMetrics(outMetrics)
        return outMetrics.widthPixels
    }

    fun getScreenHeight(activity: Activity): Int {
        val manager = activity.windowManager
        val outMetrics = DisplayMetrics()
        manager.defaultDisplay.getMetrics(outMetrics)
        return outMetrics.heightPixels
    }
}