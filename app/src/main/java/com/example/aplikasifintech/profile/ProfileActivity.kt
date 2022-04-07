package com.example.aplikasifintech.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.aplikasifintech.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val nama = findViewById<TextView>(R.id.tvnama)
        val nim = findViewById<TextView>(R.id.tvnim)
        val email = findViewById<TextView>(R.id.tvemail)
        val nohp = findViewById<TextView>(R.id.tvnohp)
        val jk = findViewById<TextView>(R.id.tvjk)
        val prodi = findViewById<TextView>(R.id.tvprogramstudi)
        val org = findViewById<TextView>(R.id.tvorganisasi)
        val status = findViewById<TextView>(R.id.tvstatusmhs)

        val openbunlde = intent.extras
        if (openbunlde != null){
            nama.setText(openbunlde.getString("nama"))
            nim.setText(openbunlde.getString("nim"))
            email.setText(openbunlde.getString("email"))
            nohp.setText(openbunlde.getString("nohp"))
            jk.setText(openbunlde.getString("jk"))
            prodi.setText(openbunlde.getString("prodi"))
            org.setText(openbunlde.getString("org"))
            status.setText(openbunlde.getString("status"))
        }
    }
}