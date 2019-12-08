package com.example.aveditor.gllearning

import android.content.Context
import android.opengl.GLES20
import android.opengl.GLSurfaceView
import com.example.aveditor.gllearning.utils.GLESShaderUtil
import com.example.aveditor.gllearning.utils.ResUtil
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

/**
 * Created by xusheng on 2019-12-08.
 */
class MyTriangleRender(var context: Context) : GLSurfaceView.Renderer {
    private var glProgramId = 0

    override fun onDrawFrame(gl: GL10?) {
    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
        GLES20.glViewport(0, 0, width, height)
    }

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        //0.简单的给窗口填充一种颜色
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f)
        val vertexShaderCode = ResUtil.readShaderCodeFromAsset(context, GLSLFileName.TRIANGLE_VERTEXT_SHADER)
        val fragmentShaderCode = ResUtil.readShaderCodeFromAsset(context, GLSLFileName.TRIANGLE_FRAGMENT_SHADER)

        val vertextShaderId = GLESShaderUtil.compileShaderByType(GLES20.GL_VERTEX_SHADER, vertexShaderCode)
        val fragmentShaderId = GLESShaderUtil.compileShaderByType(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode)
        glProgramId = GLES20.glCreateProgram()
        GLES20.glAttachShader(glProgramId, vertextShaderId)
        GLES20.glAttachShader(glProgramId, fragmentShaderId)

        //启动GL，link program
        GLES20.glLinkProgram(glProgramId)


    }

}