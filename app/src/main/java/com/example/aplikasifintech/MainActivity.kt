package com.example.aplikasifintech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.aplikasifintech.home.HomeFragment
import com.example.aplikasifintech.profile.ProfileFragment
import com.example.aplikasifintech.setting.SettingFragment

class MainActivity : AppCompatActivity() {

    private lateinit var  btn_home : Button
    private lateinit var btn_setting : Button
    private lateinit var btn_profile : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_home = findViewById(R.id.btn_home)
        btn_profile = findViewById(R.id.btn_profile)
        btn_setting = findViewById(R.id.btn_setting)

        btn_home.setOnClickListener {
            loadfrragment(HomeFragment())
        }

        btn_profile.setOnClickListener {
            loadfrragment(ProfileFragment())
        }

        btn_setting.setOnClickListener {
            loadfrragment(SettingFragment())
        }



    }

    private fun loadfrragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container,fragment)
            .commitNow()
    }
}