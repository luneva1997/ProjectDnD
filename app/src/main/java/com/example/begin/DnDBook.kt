package com.example.begin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.begin.menu.CircleMenu
import com.example.begin.menu.StatusButton
import com.example.begin.presentation.adventures.list.AdventuresListActivity

class DnDBook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dn_dbook)
    }

    public fun thirdTest(view: View) {
        val third = findViewById<CircleMenu>(R.id.circle_menu3)
        if (third.State == StatusButton.OPEN) {
            third.State = StatusButton.TRANSITION
            third.invalidate()
        }
        val intent = Intent(this, NPCActivity::class.java)
        ContextCompat.startActivity(this, intent, null)
    }

    fun back(view: View) {
        val intent = Intent(this, AdventuresListActivity::class.java)
        startActivity(intent)
    }

}

