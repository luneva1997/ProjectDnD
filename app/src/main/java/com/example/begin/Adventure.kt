package com.example.begin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.begin.menu.BigCircle
import com.example.begin.menu.StatusButton
import com.example.begin.presentation.adventures.list.AdventuresListActivity
import kotlinx.coroutines.*


class Adventure : AppCompatActivity() {

    val scope = CoroutineScope(Dispatchers.Main.immediate + SupervisorJob())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adventure)

        var menuCircle = findViewById<BigCircle>(R.id.AddCircle)

        menuCircle.setOnClickListener {
            if (menuCircle.State != StatusButton.OPEN) {
                scope.launch {
                    val l = launch {
                        menuCircle.ClickMenu()
                    }
                }
            }
            if (menuCircle.State == StatusButton.OPEN) {
                scope.coroutineContext.cancelChildren()
                menuCircle.Stable()
            }
        }
    }


    fun back(view: View) {
        val intent = Intent(this, AdventuresListActivity::class.java)
        startActivity(intent)
    }
}
