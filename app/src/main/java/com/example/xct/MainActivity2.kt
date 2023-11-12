package com.example.xct

import android.content.Intent
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

class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var edt_log = findViewById<EditText>(R.id.login)
        var edt_pas = findViewById<EditText>(R.id.pass)
        var btn_v = findViewById<Button>(R.id.btn_vxod)

        val intent2 = Intent(this, MainActivity4::class.java)
        val intent3 = Intent(this, MainActivity6::class.java)
        var log = edt_log.text.toString()
        var pas = edt_pas.text.toString()
        btn_v.setOnClickListener {
//startActivity(intent3)
            getData(log,pas,intent3,intent2)

        }
    }
    var a:Int = 0
    private fun getData(log:String,pas:String,intent2:Intent,intent3:Intent ){
        lifecycleScope.launch { val client = getClient()
            val supabaseReponse = client.postgrest["users"].select()
            val data = supabaseReponse.decodeList<users>()
// a=data.size
// var aw:List<String>//
//// aw = listOf(data[a-1].toString())
////
// if(aw[0]==log){// if(){
//// }
// }

// setText(data[0].Test_Name.toString())
            for(b in data){
                if(log in b.toString()==true== pas in b.toString()){ var getdostup=intent.getStringExtra("dostup").toString().trim()

                    startActivity(intent3)
                } }

// for(b in data){// if(log in data.toString()){
// for (u in data){
//// if(pas in data.toString()){
////
// when(getdostup){//
// "0"->startActivity(intent2)//
// "1"->startActivity(intent3)//
// }//
////
//// }
////
//// }
// }//
// }

// if (log == data[0].toString() && pas == data[1].toString()){//
//// when(getdostup){
//// "0"->startActivity(intent2)
//// "1"->startActivity(intent3)
//// }
////
// }
        }
    }

    private fun getClient(): SupabaseClient {
        return createSupabaseClient(supabaseUrl = "https://twrnebqcmxfljyozuqyp.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InR3cm5lYnFjbXhmbGp5b3p1cXlwIiwicm9sZSI6ImFub24iLCJpYXQiOjE2OTkyNzMwODYsImV4cCI6MjAxNDg0OTA4Nn0.NKu0iwKego8G5OJOTz2bay3OOsouPvtMjQZee219Ksg")
        { install(Postgrest)
        } }

    @kotlinx.serialization.Serializable
    data class users( val id: Int=0,
                      val username: String = "", val userlogin: String = "",
                      val userpass: String = "", val power: String=""
    ){
        override fun toString(): String{ return "${id} ${username} ${userlogin} ${userpass} ${power}"

        }
    }
}