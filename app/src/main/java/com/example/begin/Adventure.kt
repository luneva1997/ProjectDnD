package com.example.begin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.begin.presentation.adventures.list.AdventuresListActivity

class Adventure : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adventure)

    }

    fun back(view: View) {
        val intent = Intent(this, AdventuresListActivity::class.java)
        startActivity(intent)
    }
}
