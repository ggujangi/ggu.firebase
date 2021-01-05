package com.ggu.firebase.ui.sample

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ggu.firebase.R
import com.ggu.firebase.data.SampleRepository
import com.ggu.firebase.databinding.ActivitySampleBinding

class SampleActivity : AppCompatActivity() {

    private lateinit var viewModel: SampleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivitySampleBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_sample)

        setSupportActionBar(binding.toolbar)

        setUpViewModel()
    }



    private fun setUpViewModel() {
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return SampleViewModel(SampleRepository()) as T
            }
        }).get(SampleViewModel::class.java)


        viewModel.getUsers(1).observe(this, Observer {
            Log.d("sampleTest", "${it?.data?.size}")
        })
    }


    private fun setUpUI(){

    }

    private fun setUpObservers(){

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_sample, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.refresh(item.itemId)

        Toast.makeText(this, "${item.title}", Toast.LENGTH_LONG).show()

        return super.onOptionsItemSelected(item)
    }
}