package com.example.aveditor.recorder.camera

import android.view.Surface
import android.view.SurfaceView
import androidx.appcompat.app.AppCompatActivity
import com.example.aveditor.utils.UIUtils

/**
 * Created by xusheng on 2020-01-26.
 */
class CameraPreviewHandler(surfaceView: SurfaceView, activity: AppCompatActivity) :
    IPreviewHandler {
    private var isFirstPreview = true
    private var isSurfaceExists = false
    private var hasStoped = false

    init {
        surfaceView.layoutParams.width = UIUtils.getScreenWidth(activity)
        surfaceView.layoutParams.height = UIUtils.getScreenHeight(activity)
    }

    override fun initEglEnvironment(
        surface: Surface?,
        width: Int,
        height: Int,
        cameraFacingId: Int
    ) {
        if (isFirstPreview) {
            initEGLContext(surface, width, height, cameraFacingId)
            isFirstPreview = false
        } else {
            createWindowSurface(surface)
        }
        isSurfaceExists = true
    }

    private external fun initEGLContext(
        surface: Surface?,
        width: Int,
        height: Int,
        cameraFacingId: Int
    )

    private external fun createWindowSurface(surface: Surface?)


}