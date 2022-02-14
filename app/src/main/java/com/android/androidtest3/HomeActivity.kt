package com.android.androidtest3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*


enum class ProviderType {
    BASIC

}
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        sistemas()
        quimca()
    }


    private  fun sistemas(){
        btnSistemas.setOnClickListener {
            startActivity(Intent(this, IscActivity::class.java))
        }
    }

    private fun quimca(){
        btnQuimica.setOnClickListener {
            startActivity(Intent(this,com.android.androidtest3.IqActivity::class.java))
        }
    }
}