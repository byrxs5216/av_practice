package com.example.aveditor

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aveditor.gllearning.ui.TestOpenGLActivity
import com.example.aveditor.player.constants.IntentExtra
import com.example.aveditor.player.ui.VideoPlayerActivity
import com.example.aveditor.recorder.ui.VideoRecordActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnTestOpengl.setOnClickListener {
            startActivity(Intent(this, TestOpenGLActivity::class.java))
        }
        btnStartPlay.setOnClickListener {
            val intent = Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra(IntentExtra.KEY_VIDEO_PATH, "")
            startActivity(intent)
        }
        btnStartRecord.setOnClickListener {
            val intent = Intent(this, VideoRecordActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onDestroy() {
        super.onDestroy()

    }

}
