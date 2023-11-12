package com.example.xct

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)
        var btncontin = findViewById<Button>(R.id.contin)
        var btnskip = findViewById<Button>(R.id.skip)

        var intent_contin = Intent(this,MainActivity8::class.java)
        var intent_skip = Intent(this,MainActivity::class.java)
        btncontin.setOnClickListener {
            startActivity(intent_contin)
        }
        btnskip.setOnClickListener {
            startActivity(intent_skip)
        }

    }
}