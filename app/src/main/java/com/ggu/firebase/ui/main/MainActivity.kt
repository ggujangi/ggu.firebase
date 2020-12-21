package com.ggu.firebase.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ggu.firebase.R
import com.ggu.firebase.databinding.ActivityMainBinding
import com.ggu.firebase.ui.login.LoginActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.listener = this

        setSupportActionBar(binding.toolbar)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.fab -> Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_login -> startActivity(Intent(this, LoginActivity::class.java))
        }

        return super.onOptionsItemSelected(item)
    }
}