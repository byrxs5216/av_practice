package com.example.aveditor.gllearning.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aveditor.R
import com.example.aveditor.gllearning.MyTriangleRender
import kotlinx.android.synthetic.main.activity_testopengl.*

/**
 * Created by xusheng on 2020-01-26.
 */
class TestOpenGLActivity: AppCompatActivity() {

    private var triangleRender: MyTriangleRender? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testopengl)
        triangleRender = MyTriangleRender(this)
        glSurfaceView?.apply {
            setEGLContextClientVersion(2)
            setRenderer(triangleRender)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        triangleRender?.release()
    }
}