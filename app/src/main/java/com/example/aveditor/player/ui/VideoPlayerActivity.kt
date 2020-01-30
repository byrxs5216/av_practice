package com.example.aveditor.player.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aveditor.R
import com.example.aveditor.player.constants.IntentExtra

/**
 * Created by xusheng on 2020-01-26.
 */
class VideoPlayerActivity : AppCompatActivity() {
    private var videoPath: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)
        videoPath = intent.getStringExtra(IntentExtra.KEY_VIDEO_PATH)
    }
}