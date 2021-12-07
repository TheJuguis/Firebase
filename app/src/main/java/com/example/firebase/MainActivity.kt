package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

private lateinit var database:DatabaseReference
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDB= FirebaseDatabase.getInstance()
        database = myDB.reference
        writeNewUser("002","nombreuno","uno@gmail.com")


    }


    fun writeNewUser(userId: String, name: String, email: String){
        val user = User(name, email)
        database.child("usuarios").child(userId).setValue(user)
    }
}

class User(name: String, email: String){
    val nombre = name
    val correo = email

}