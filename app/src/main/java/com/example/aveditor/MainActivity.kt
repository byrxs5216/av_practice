package com.example.aveditor

import android.opengl.GLSurfaceView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aveditor.gllearning.MyTriangleRender
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var triangleRender: MyTriangleRender? = null
    private var glSurfaceView: GLSurfaceView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        glSurfaceView = findViewById(R.id.gl_surface_view)
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

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
