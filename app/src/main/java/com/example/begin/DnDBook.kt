package com.example.begin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class DnDBook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dn_dbook)
    }

    fun back(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}