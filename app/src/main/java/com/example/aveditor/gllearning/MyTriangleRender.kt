package com.example.aveditor.gllearning

import android.content.Context
import android.opengl.GLES20
import android.opengl.GLSurfaceView
import android.util.Log
import com.example.aveditor.gllearning.utils.GLESShaderUtil
import com.example.aveditor.gllearning.utils.ResUtil
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

/**
 * Created by xusheng on 2019-12-08.
 */
class MyTriangleRender(var context: Context) : GLSurfaceView.Renderer {
    private var glProgramId = 0
    private var textureId: Int = -1

    private var vertextCoors = floatArrayOf(
        -1f, -1f,
        1f, -1f,
        0f, 1f
    )  //顶点坐标 (世界坐标)

    private var textureCoors = floatArrayOf(
        0f, 1f,
        1f, 1f,
        0.5f, 0f
    )  //纹理坐标(安卓坐标系 范围是0-1)

    private var vertextBuffer: FloatBuffer
    private var textureBuffer: FloatBuffer

    private var vertextPosHandler: Int = -1
    private var texturePosHandler: Int = -1

    init {
        //将坐标数据转换为FloatBuffer，用以传入给OpenGL ES程序
        vertextBuffer = ByteBuffer
            .allocateDirect(vertextCoors.size * 4)
            .order(ByteOrder.nativeOrder())
            .asFloatBuffer()
            .put(vertextCoors)
        vertextBuffer.position(0)

        textureBuffer = ByteBuffer
            .allocateDirect(textureCoors.size * 4)
            .order(ByteOrder.nativeOrder())
            .asFloatBuffer()
            .put(textureCoors)
        textureBuffer.position(0)
    }

    override fun onDrawFrame(gl: GL10?) {
        //绘制
        draw()
    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
        GLES20.glViewport(0, 0, width, height)
    }

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        //0.简单的给窗口填充一种颜色
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f)
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT)

        //生成纹理
        genTexture()
        //编译链接着色器
        compileShaderAndLinkProgram()
    }



    fun release() {
        GLES20.glDisableVertexAttribArray(vertextPosHandler)
        GLES20.glDisableVertexAttribArray(texturePosHandler)
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, 0)
        GLES20.glDeleteTextures(1, intArrayOf(textureId), 0)
        GLES20.glDeleteProgram(glProgramId)
    }

    private fun draw() {
        vertextPosHandler = GLES20.glGetAttribLocation(glProgramId, "aPosition")
        texturePosHandler = GLES20.glGetAttribLocation(glProgramId, "aCoordinate")
        //启用顶点的句柄
        GLES20.glEnableVertexAttribArray(vertextPosHandler)
        GLES20.glEnableVertexAttribArray(texturePosHandler)

        //设置着色器参数
        GLES20.glVertexAttribPointer(vertextPosHandler, 2, GLES20.GL_FLOAT, false, 0, vertextBuffer)
        GLES20.glVertexAttribPointer(texturePosHandler, 2, GLES20.GL_FLOAT, false, 0, textureBuffer)
        //开始绘制
        GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP, 0, 4)

    }

    private fun compileShaderAndLinkProgram() {
        if (textureId != -1) {
            var vertexShaderCode =
                ResUtil.readShaderCodeFromAsset(context, GLSLFileName.TRIANGLE_VERTEXT_SHADER)
            var fragmentShaderCode =
                ResUtil.readShaderCodeFromAsset(context, GLSLFileName.TRIANGLE_FRAGMENT_SHADER)
            Log.e("xusheng", "vertexShaderCode: $vertexShaderCode")
            Log.e("xusheng", "fragmentShaderCode: $fragmentShaderCode")
            //编译顶点着色器和片元着色器
            val vertextShaderId =
                GLESShaderUtil.compileShaderByType(GLES20.GL_VERTEX_SHADER, vertexShaderCode)
            val fragmentShaderId =
                GLESShaderUtil.compileShaderByType(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode)
            //链接到着色器程序
            glProgramId = GLES20.glCreateProgram()
            GLES20.glAttachShader(glProgramId, vertextShaderId)
            GLES20.glAttachShader(glProgramId, fragmentShaderId)
            GLES20.glLinkProgram(glProgramId)
            GLES20.glUseProgram(glProgramId)
        }
    }

    private fun genTexture() {
        val texture = IntArray(1)
        GLES20.glGenTextures(1, texture, 0)
        textureId = texture[0]
        Log.e("xusheng", "textureId: $textureId")
    }

}