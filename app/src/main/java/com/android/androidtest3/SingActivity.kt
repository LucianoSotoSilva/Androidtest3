package com.android.androidtest3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sing.*
import com.android.androidtest3.RegistroActivity as RegistroActivity1

class SingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing)

       val analytics : FirebaseAnalytics =FirebaseAnalytics.getInstance(this)
        val bundle=Bundle()
        bundle.putString("mesage","Integracion de Firebase completa")
        analytics.logEvent("InitScreen", bundle)

        setup()
    }

    private fun setup(){
        title = "Autenticacion"
        btnRegistrar.setOnClickListener{
           startActivity(Intent(this,com.android.androidtest3.RegistroActivity::class.java))
        }

        acceder.setOnClickListener{
            if (EmailEditText.text.isNotEmpty() && PasswordEditText.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(EmailEditText.text.toString(),
                        PasswordEditText.text.toString()).addOnCompleteListener {
                        if (it.isSuccessful){
                            showHome(it.result?.user?.email ?:"",ProviderType.BASIC)

                        }else{
                            showAlert()
                        }
                    }
            }
        }




    }

    private fun showAlert(){
        val builder= AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticamdo al usuario")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email: String,provider: ProviderType){
        val homeIntent = Intent(this,HomeActivity::class.java ).apply {
            putExtra("email", email)
            putExtra("provider",provider.name)
        }



        startActivity(homeIntent)


    }
}