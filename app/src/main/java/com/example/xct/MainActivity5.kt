package com.example.xct
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch

import android.content.Intent



class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        var btn_set2 = findViewById<Button>(R.id.settings_menu)
        var btn_au = findViewById<Button>(R.id.btn_au)
        var btn_lkst = findViewById<Button>(R.id.btn_lkst)
        var edt_name = findViewById<EditText>(R.id.name_up)
        var edt_login = findViewById<EditText>(R.id.login_up)
        var edt_pass = findViewById<EditText>(R.id.pass_up)
        var btn_up = findViewById<Button>(R.id.btn_up)


        var intent_set = Intent(this,MainActivity5::class.java)

        var intent_au = Intent(this,MainActivity::class.java)
        var intent_lkad = Intent(this,MainActivity4::class.java)

        btn_set2.setOnClickListener {
            startActivity(intent_set)
        }
        btn_au.setOnClickListener {
            startActivity(intent_au)

        }
        btn_lkst.setOnClickListener {
            startActivity(intent_lkad)
        }





                btn_up.setOnClickListener {
                    var name = edt_name.text.toString()
                    var login = edt_login.text.toString()
                    var pass = edt_pass.text.toString()

                }

            }

            private fun updateDate(name: String, login: String, pass: String){
                lifecycleScope.launch{
                    val client = getClient()
                    var abc = Up(username = name, userlogin = login, userpass = pass)
                    client.postgrest["users"].update()

                }
            }

            private fun getClient(): SupabaseClient {
                return createSupabaseClient(supabaseUrl = "https://twrnebqcmxfljyozuqyp.supabase.co",
                    supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InR3cm5lYnFjbXhmbGp5b3p1cXlwIiwicm9sZSI6ImFub24iLCJpYXQiOjE2OTkyNzMwODYsImV4cCI6MjAxNDg0OTA4Nn0.NKu0iwKego8G5OJOTz2bay3OOsouPvtMjQZee219Ksg")
                {
                    install(Postgrest)
                }
            }

        }

        @kotlinx.serialization.Serializable
        data class Up(
            val id: Int=0,
            val username: String = "",
            val userlogin: String = "",
            val userpass: String = "",
            val power: String=""

        ){
            override fun toString(): String{
                return "${id} ${username} ${userlogin} ${userpass} ${power}"
            }
    }
