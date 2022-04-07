package com.example.aplikasifintech.setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.aplikasifintech.R
import com.example.aplikasifintech.profile.ProfileActivity
import java.util.regex.Pattern

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        title = "Menu Setting"
        val btnsimpan = findViewById<Button>(R.id.btnsimpan)
        val nama = findViewById<EditText>(R.id.etnamalkp)
        val nim = findViewById<EditText>(R.id.etnim)
        val email = findViewById<EditText>(R.id.etemail)
        val nohp = findViewById<EditText>(R.id.etnohp)
        val password = findViewById<EditText>(R.id.etpassword)
        val rgjk = findViewById<RadioGroup>(R.id.rgkel)
        val spinner = findViewById<Spinner>(R.id.spinnerProgramStudi)
        val amcc = findViewById<CheckBox>(R.id.amcc)
        val himssi = findViewById<CheckBox>(R.id.himssi)
        val bem = findViewById<CheckBox>(R.id.bem)
        val togglebtn = findViewById<ToggleButton>(R.id.togglebtn)

        btnsimpan.setOnClickListener {
            val cekjk = rgjk.checkedRadioButtonId
            val jk = findViewById<RadioButton>(cekjk)

            val org = StringBuilder()
            if (amcc.isChecked){
                org.append("AMCC\n")
            }
            if (himssi.isChecked){
                org.append("HIMSSI\n")
            }
            if (bem.isChecked){
                org.append("BEM AMIKOM\n")
            }

            val bundle = Bundle()
            bundle.putString("nama",nama.text.toString())
            bundle.putString("nim",nim.text.toString())
            bundle.putString("email",email.text.toString())
            bundle.putString("nohp",nohp.text.toString())
            bundle.putString("jk","${jk.text}")
            bundle.putString("prodi",spinner.selectedItem.toString())
            bundle.putString("org",org.toString())
            bundle.putString("status",togglebtn.text.toString())

            if (!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
                email.error = "Masukan Email dengan Benar"
            }
            else if (password.length()==0){
                password.error = "Password tidak boleh kosong"
            }
            else{
                val alertDialogBuilder = AlertDialog.Builder(this)
                alertDialogBuilder.setTitle("Peringatan...!!!")
                alertDialogBuilder.setMessage("Apakah Data Anda Sudah Benar..?")
                    .setCancelable(false)
                    .setPositiveButton("Yes"){
                            dialogInterface, i ->
                        val intent = Intent(this,ProfileActivity::class.java)
                        intent.putExtras(bundle)
                        startActivity(intent)
                        Toast.makeText(this,"Data Profil Berhasil Tersimpan",Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("No"){
                        dialogInterface, i -> dialogInterface.cancel()
                    }
                val alertDialog = alertDialogBuilder.create()
                alertDialog.show()
            }
        }
    }
}