package com.example.xct

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import com.example.xct.R
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.launch

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var name_p = findViewById<EditText>(R.id.name_p)
        var sername_p = findViewById<EditText>(R.id.sername_p)
        var description_p = findViewById<EditText>(R.id.description_p)
        var projectname_p = findViewById<EditText>(R.id.projectname)
        var target_p = findViewById<EditText>(R.id.target)
        var task_p = findViewById<EditText>(R.id.task)

        var add = findViewById<Button>(R.id.add)
        var btn_lkst = findViewById<Button>(R.id.btn_lkst)


        var btn_set2 = findViewById<Button>(R.id.settings_menu)
        var btn_au = findViewById<Button>(R.id.btn_au)


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

        add.setOnClickListener {
            var name = name_p.text.toString()
            var sername = sername_p.text.toString()
            var description = description_p.text.toString()
            var projectname = projectname_p.text.toString()
            var target = target_p.text.toString()
            var task = task_p.text.toString()
            insertData(name, sername, description, projectname, target, task)
        }



    }


    private fun insertData(name: String, sername: String, description: String, projectname: String, target: String, task: String){
        lifecycleScope.launch{
            val client = getClient()
            var abc = Test(username_p = name, sername = sername, description_p = description, projectname = projectname, target = target, task = task)
            client.postgrest["project"].insert(value = abc)

        }
    }

    private fun getClient(): SupabaseClient {
        return createSupabaseClient(
            supabaseUrl = "https://twrnebqcmxfljyozuqyp.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InR3cm5lYnFjbXhmbGp5b3p1cXlwIiwicm9sZSI6ImFub24iLCJpYXQiOjE2OTkyNzMwODYsImV4cCI6MjAxNDg0OTA4Nn0.NKu0iwKego8G5OJOTz2bay3OOsouPvtMjQZee219Ksg"
        )
        {
            install(Postgrest)
        }

    }
}


@kotlinx.serialization.Serializable
data class Test(
    val id: Int=0,
    val username_p: String = "",
    val sername: String = "",
    val description_p: String = "",
    val projectname: String = "",
    val target: String = "",
    val task: String = "",

    ){
    override fun toString(): String{
        return "${id} ${username_p} ${sername} ${description_p} ${projectname} ${target} ${task}"
  }
}