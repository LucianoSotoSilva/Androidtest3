package com.android.androidtest3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_isc.*

class IscActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isc)

        pasar()
        mostrar()
        title = "Ingenieria Sitemas Computacionales"
    }


    fun pasar(){
        btncapturar.setOnClickListener {
            if (CampoText1.text.isEmpty()){
                Toast.makeText(this, "Ingresa texto porfavor", Toast.LENGTH_SHORT).show()
            }else{
                Label1.text= (CampoText1.text)
            }

        }

    }

    fun mostrar(){
        btnAlert.setOnClickListener {
            showAlert()
        }
    }


    private fun showAlert(){
        val builder= AlertDialog.Builder(this)
        builder.setTitle("Alerta")
        builder.setMessage("ISC")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}