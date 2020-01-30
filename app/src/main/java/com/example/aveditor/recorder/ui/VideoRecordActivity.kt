package com.example.aveditor.recorder.ui

import android.hardware.Camera
import android.os.Bundle
import android.view.SurfaceHolder
import androidx.appcompat.app.AppCompatActivity
import com.example.aveditor.R
import com.example.aveditor.recorder.camera.CameraPreviewHandler
import com.example.aveditor.recorder.camera.IPreviewHandler
import kotlinx.android.synthetic.main.activity_video_record.*

/**
 * Created by xusheng on 2020-01-26.
 */
class VideoRecordActivity : AppCompatActivity() {
    private var previewHandler: IPreviewHandler? = null
    private var cameraFaceId = Camera.CameraInfo.CAMERA_FACING_FRONT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_record)
        initSurfaceView()
    }

    private fun initSurfaceView() {
        previewHandler = CameraPreviewHandler(surfaceView, this)
        surfaceView.holder.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceChanged(
                holder: SurfaceHolder?,
                format: Int,
                width: Int,
                height: Int
            ) {

            }

            override fun surfaceDestroyed(holder: SurfaceHolder?) {
            }

            override fun surfaceCreated(holder: SurfaceHolder?) {
                var surface = holder?.surface
                previewHandler?.initEglEnvironment(surface, surfaceView.width, surfaceView.height, cameraFaceId)
            }

        })
        surfaceView.holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}