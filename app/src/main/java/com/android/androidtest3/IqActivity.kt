package com.android.androidtest3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_iq.*
import kotlinx.android.synthetic.main.activity_isc.*
import kotlinx.android.synthetic.main.activity_isc.CampoText1

class IqActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iq)

        title = "Ingenieria Quimica"


        alert()

      pasar2()


    }


    fun alert(){
        btn1.setOnClickListener {
            if (CampoText1.text.isEmpty()){
                Toast.makeText(this, "Ingresa texto porfavor", Toast.LENGTH_SHORT).show()
            }else{
                showAlert()


            }

        }

    }

    private fun pasar2(){

        Labelmostrar.text== CampoText2.text
    }


    private fun showAlert(){
        val builder= AlertDialog.Builder(this)
        builder.setTitle("Alerta")
        builder.setMessage("Ing.Quimica--"+CampoText1.text)
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}