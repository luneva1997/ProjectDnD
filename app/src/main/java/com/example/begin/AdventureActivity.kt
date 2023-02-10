package com.example.begin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.begin.presentation.adventures.list.AdventuresListActivity

class AdventureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adventure)
    }

    fun back(view: View){
        val intent = Intent(this, AdventuresListActivity::class.java)
        startActivity(intent)
    }

    companion object {

        private const val ADVENTURE_ID = "adventure_id"

        fun createIntent(context: Context, adventureId: Int): Intent {
            return Intent(context, AdventureActivity::class.java).apply {
                putExtra(ADVENTURE_ID, adventureId)
            }
        }
    }
}