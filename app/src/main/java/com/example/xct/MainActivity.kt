package com.example.xct

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.ktor.http.HttpHeaders.Authorization
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var startap = findViewById<Button>(R.id.startap)
        var btns = findViewById<ImageView>(R.id.btnsimg)
        var point = findViewById<Button>(R.id.point)


        var edt_name = findViewById<EditText>(R.id.name)
        var edt_login = findViewById<EditText>(R.id.login)
        var edt_pass = findViewById<EditText>(R.id.pass)
        var aut = findViewById<Button>(R.id.aut)
        var btn = findViewById<Button>(R.id.btn)

        var intent_au = Intent(this,MainActivity2::class.java)

        var dostuup: String=""
        startap.setOnClickListener (){
            dostuup="0"
//           btns.setImageDrawable(R.drawable.startupred)

        }
        point.setOnClickListener (){ dostuup="1"


        }

        aut.setOnClickListener {
            startActivity(intent_au)



        }

        btn.setOnClickListener {
            var name = edt_name.text.toString()
            var login = edt_login.text.toString()
            var pass = edt_pass.text.toString()
            insertData(name, login, pass, dostuup)
            val intent = Intent(this, Authorization::class.java)

            intent.putExtra("dostup", dostuup)

            startActivity(intent_au)
        }

    }



    private fun insertData(name: String, login: String, pass: String, dostup: String){
        lifecycleScope.launch{
            val client = getClient()
            var abc = Testing(username = name, userlogin = login, userpass = pass, power = dostup)
            client.postgrest["users"].insert(value = abc)

        }
    }

    private fun getClient(): SupabaseClient{
        return createSupabaseClient(supabaseUrl = "https://twrnebqcmxfljyozuqyp.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InR3cm5lYnFjbXhmbGp5b3p1cXlwIiwicm9sZSI6ImFub24iLCJpYXQiOjE2OTkyNzMwODYsImV4cCI6MjAxNDg0OTA4Nn0.NKu0iwKego8G5OJOTz2bay3OOsouPvtMjQZee219Ksg")
        {
            install(Postgrest)
        }
    }

}



@kotlinx.serialization.Serializable
data class Testing(
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


