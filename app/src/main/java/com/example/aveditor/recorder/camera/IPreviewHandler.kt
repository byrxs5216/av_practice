package com.example.aveditor.recorder.camera

import android.view.Surface

/**
 * Created by xusheng on 2020-01-26.
 */
interface IPreviewHandler {
    fun initEglEnvironment(surface: Surface?, width: Int, height: Int, cameraFacingId: Int)
}