package com.example.aveditor.recorder.view

import android.content.Context
import android.util.AttributeSet
import android.view.SurfaceView

/**
 * Created by xusheng on 2020-01-26.
 */
class MySurfaceView: SurfaceView {

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
    }

}