package com.example.aveditor.gllearning

import android.os.Build
import android.content.pm.ConfigurationInfo
import android.content.Context.ACTIVITY_SERVICE
import androidx.core.content.ContextCompat.getSystemService
import android.app.ActivityManager
import android.content.Context


/**
 * Created by xusheng on 2019-12-08.
 */
object GlUtil {
    /**
     * open gl 2的版本
     */
    private val GLES_VERSION_2 = 0x20000


    /**
     * 判断是否支持es2.0
     *
     * @param context
     * @return
     */
    fun isSupportEs2(context: Context): Boolean {
        //检查是否支持2.0
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        if (activityManager != null) {
            val deviceConfigurationInfo = activityManager.deviceConfigurationInfo
            val reqGlEsVersion = deviceConfigurationInfo.reqGlEsVersion
            return reqGlEsVersion >= GLES_VERSION_2 || Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1 && (Build.FINGERPRINT.startsWith(
                "generic"
            )
                    || Build.FINGERPRINT.startsWith("unknown")
                    || Build.MODEL.contains("google_sdk")
                    || Build.MODEL.contains("Emulator")
                    || Build.MODEL.contains("Android SDK build for x86"))
        } else {
            return false
        }

    }
}