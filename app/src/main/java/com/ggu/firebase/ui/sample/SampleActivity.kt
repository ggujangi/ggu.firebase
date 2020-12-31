package com.ggu.firebase.ui.sample

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ggu.firebase.R
import com.ggu.firebase.data.SampleRepository
import com.ggu.firebase.databinding.ActivitySampleBinding

class SampleActivity : AppCompatActivity() {

    val viewModel: SampleViewModel =
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return SampleViewModel(SampleRepository()) as T
            }
        }).get(SampleViewModel::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivitySampleBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_sample)

        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_sample, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}