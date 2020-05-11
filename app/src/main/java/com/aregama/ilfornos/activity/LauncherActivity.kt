package com.aregama.ilfornos.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import com.aregama.ilfornos.R
import kotlinx.android.synthetic.main.activity_launcher.*

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        val videoPath="android.resource://"+packageName+"/"+R.raw.ad_video;

        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.start()

        videoView.setOnCompletionListener { mp ->
            videoView.start()
        }
    }


    override fun onRestart() {
        super.onRestart()

        videoView.start()
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN->{
                videoView.stopPlayback()
                startActivity(Intent(this@LauncherActivity,MainActivity::class.java))
                finish()
            }
        }

        return true
    }
}
