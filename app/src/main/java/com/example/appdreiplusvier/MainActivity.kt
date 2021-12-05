package com.example.appdreiplusvier

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val prefs: SharedPreferences = this.getSharedPreferences("com.example.appdreiplusvier", Context.MODE_PRIVATE)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onBackPressed() {
        val btmNav: BottomNavigationView = findViewById(R.id.bottom_nav)
        when(btmNav.selectedItemId) {
            R.id.nav_but_1 -> super.onBackPressed()
            else -> btmNav.selectedItemId = R.id.nav_but_1
        }
    }
}