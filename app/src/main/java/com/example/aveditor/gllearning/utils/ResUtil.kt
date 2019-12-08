package com.example.aveditor.gllearning.utils

import android.content.Context
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

/**
 * Created by xusheng on 2019-12-08.
 */
object ResUtil {

    /**
     * 从Assert中读取ShaderCode
     *
     * @param context        context
     * @param shaderCodeName shader file name
     * @return shaderCodeString
     */
    fun readShaderCodeFromAsset(context: Context, shaderCodeName: String): String {
        val body = StringBuilder()
        var open: InputStream? = null
        try {
            open = context.assets.open(shaderCodeName)
            val bufferedReader = BufferedReader(InputStreamReader(open))
            var line: String? = null
            bufferedReader.readLine()?.let { line ->
                body.append(line)
                body.append("\n")
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return body.toString()
    }

}