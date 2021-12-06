package com.example.appdreiplusvier

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supActBar = supportActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    override fun onBackPressed() {
        val btmNav: BottomNavigationView = findViewById(R.id.bottom_nav)
        when(btmNav.selectedItemId) {
            R.id.nav_but_1 -> super.onBackPressed()
            else -> btmNav.selectedItemId = R.id.nav_but_1
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    companion object {
        var supActBar: ActionBar? = null
    }
}