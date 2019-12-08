package com.example.aveditor.gllearning.utils

import android.opengl.GLES20

/**
 * Created by xusheng on 2019-12-08.
 */
object GLESShaderUtil {

    fun compileShaderByType(type:Int, shaderCode: String): Int {
        val shaderObjId = GLES20.glCreateShader(type)
        if (shaderObjId != 0) { //不为0 表示可用
            //上传代码
            GLES20.glShaderSource(shaderObjId, shaderCode)
            //编译着色器代码
            GLES20.glCompileShader(shaderObjId)
            //获取编译状态
            val compileStatus = IntArray(1)
            GLES20.glGetShaderiv(shaderObjId, GLES20.GL_COMPILE_STATUS, compileStatus, 0)
            compileStatus?.let { status ->
                if (status[0] == 0) {
                    GLES20.glDeleteShader(shaderObjId)
                    return 0
                }
            }
        }
        return shaderObjId
    }


}