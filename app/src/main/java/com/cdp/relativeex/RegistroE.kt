package com.cdp.relativeex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegistroE : AppCompatActivity() {
    private lateinit var regusuario: EditText
    private lateinit var regemail: EditText
    private lateinit var regcontra: EditText
    private lateinit var regcontra2: EditText
    private lateinit var registro1: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro_e)


        regusuario = findViewById(R.id.regusuario)
        regemail = findViewById(R.id.regemail)
        regcontra = findViewById(R.id.regcontra)
        regcontra2 = findViewById(R.id.regcontra2)
        registro1 =   findViewById(R.id.registro1)

        registro1.setOnClickListener {

            val usuar = regusuario.text.toString().trim()
            val email = regemail.text.toString().trim()
            val contra = regcontra.text.toString().trim()
            val contra2 = regcontra2.text.toString().trim()
            if (usuar.isEmpty()){
                regusuario.error = "Usuario Requerido"
                return@setOnClickListener
            }
            else if (email.isEmpty()){
                regemail.error = "Email Requerido"
                return@setOnClickListener
            }
            else if (contra.isEmpty()){
                regcontra.error = "Contraseña Requerida"
                return@setOnClickListener
            }
            else if (contra2.isEmpty()){
                regcontra2.error = "Contraseña Requerida"
                return@setOnClickListener
            }
            else if (contra.equals(contra2)) {
                setContentView(R.layout.inicio)
            }
            else {
                Toast.makeText(this, "Error de registro!!", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) hideSystemUI()
    }

    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN)
    }


}