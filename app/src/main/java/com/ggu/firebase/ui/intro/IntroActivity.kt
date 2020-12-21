package com.ggu.firebase.ui.intro

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ggu.firebase.R
import com.ggu.firebase.databinding.ActivityIntroBinding
import com.ggu.firebase.ui.main.MainActivity

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityIntroBinding = DataBindingUtil.setContentView(this, R.layout.activity_intro)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 500)
    }
}