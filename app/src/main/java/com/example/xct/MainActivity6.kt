package com.example.xct

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        var btn_set = findViewById<Button>(R.id.settings)
        var btn_set2 = findViewById<Button>(R.id.settings_menu)
        var btn_au = findViewById<Button>(R.id.btn_au)
        var btn_lkst = findViewById<Button>(R.id.btn_lkst)

        var intent_set = Intent(this,MainActivity5::class.java)
        var intent_au = Intent(this,MainActivity::class.java)
        var intent_lkad = Intent(this,MainActivity4::class.java)
        btn_set.setOnClickListener {
            startActivity(intent_set)
        }
        btn_set2.setOnClickListener {
            startActivity(intent_set)
        }

        btn_au.setOnClickListener {
            startActivity(intent_au)

        }
        btn_lkst.setOnClickListener {
            startActivity(intent_lkad)
        }
    }
}