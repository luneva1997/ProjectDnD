package com.example.begin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toAdventure(view: View){
        val intent = Intent(this, Adventure::class.java)
        startActivity(intent)
    }

    fun toDnDBook(view: View){
        val intent = Intent(this, DnDBook::class.java)
        startActivity(intent)
    }

    fun toSettings(view: View){
        val intent = Intent(this@MainActivity, Settings::class.java)
        startActivity(intent)
    }
}