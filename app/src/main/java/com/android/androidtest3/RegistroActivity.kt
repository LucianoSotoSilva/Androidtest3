package com.android.androidtest3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_registro.*
import kotlinx.android.synthetic.main.activity_sing.*
import kotlinx.android.synthetic.main.activity_sing.EmailEditText
import kotlinx.android.synthetic.main.activity_sing.PasswordEditText

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        setup()
    }


    private fun setup(){

        Registrar.setOnClickListener{
            if (Email.text.isNotEmpty() && Pass.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(Email.text.toString(),
                        Pass.text.toString()).addOnCompleteListener {
                        if (it.isSuccessful){
                            startActivity(Intent(this,com.android.androidtest3.SingActivity::class.java))
                            val toast:Unit =Toast.makeText(this,"Cuenta creada con exito",Toast.LENGTH_SHORT).show()

                        }else{
                            showAlert()
                        }
                    }
            }
        }

    }

    private fun showAlert(){
        val builder= AlertDialog.Builder(this)
        builder.setTitle("Error!!")
        builder.setMessage("Se ha producido un error con tus datos ingresados")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email: String,provider: ProviderType) {
        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }



        startActivity(homeIntent)

    }

}