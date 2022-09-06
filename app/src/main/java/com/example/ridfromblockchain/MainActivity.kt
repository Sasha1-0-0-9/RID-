package com.example.ridfromblockchain

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "Firebase connection success", Toast.LENGTH_LONG).show()
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        val signUpBtn = findViewById<TextView>(R.id.sign_up)
        signUpBtn.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@MainActivity, SignUp::class.java))
        })

        val login = findViewById<TextView>(R.id.login_btn)
        login.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@MainActivity, main_frame::class.java))
        })

        myRef.setValue("RID from Blockchain app is successfully connected to Firebase!")
    }

    //TODO sign up redirect
}