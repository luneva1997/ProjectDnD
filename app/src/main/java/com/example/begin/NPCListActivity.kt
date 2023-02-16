package com.example.begin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.begin.menu.BackgroundMenu
import com.example.begin.menu.BigCircleMenu
import com.example.begin.menu.CircleMenu
import com.example.begin.menu.StatusButton
import com.example.begin.presentation.adventures.list.AdventuresListActivity

class NPCListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_npclist)
        val menu = findViewById<BigCircleMenu>(R.id.big_menu)
        val background = findViewById<BackgroundMenu>(R.id.background_menu)
        val circle = CircleMenu(this, null)
        val first = findViewById<CircleMenu>(R.id.circle_menu1)
        val second = findViewById<CircleMenu>(R.id.circle_menu2)
        val third = findViewById<CircleMenu>(R.id.circle_menu3)
        val fourth = findViewById<CircleMenu>(R.id.circle_menu4)
        val fifth = findViewById<CircleMenu>(R.id.circle_menu5)

        menu.setPicture(R.drawable.npc)
        circle.setPictures(R.drawable.adventure, R.drawable.character, R.drawable.location, R.drawable.qwest, R.drawable.note2)
        first.invalidate()
        second.invalidate()
        third.invalidate()
        fourth.invalidate()
        fifth.invalidate()
        background.alpha = 0F
        background.isInvisible = true
        first.isInvisible = true
        second.isInvisible = true
        third.isInvisible = true
        fourth.isInvisible = true
        fifth.isInvisible = true

        menu.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View){
                menuAction()
            } })

        first.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View){
                firstNavigation()
            } })

        second.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View){
                secondNavigation()
            } })

        third.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View){
                thirdNavigation()
            } })

        fourth.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View){
                fourthNavigation()
            } })

        fifth.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View){
                fifthNavigation()
            } })
    }

    fun back(view: View){
        val intent = Intent(this, AdventuresListActivity::class.java)
        startActivity(intent)
    }

    fun menuAction(){
        val menu = findViewById<BigCircleMenu>(R.id.big_menu)
        val background = findViewById<BackgroundMenu>(R.id.background_menu)
        val first = findViewById<CircleMenu>(R.id.circle_menu1)
        val second = findViewById<CircleMenu>(R.id.circle_menu2)
        val third = findViewById<CircleMenu>(R.id.circle_menu3)
        val fourth = findViewById<CircleMenu>(R.id.circle_menu4)
        val fifth = findViewById<CircleMenu>(R.id.circle_menu5)

        var handler = Handler()
        background.animate().setDuration(1000)
        first.animate().setDuration(1000)
        second.animate().setDuration(1000)
        third.animate().setDuration(1000)
        fourth.animate().setDuration(1000)
        fifth.animate().setDuration(1000)

        var runnable = Runnable(){
            first.isVisible = true
            second.isVisible = true
            third.isVisible = true
            fourth.isVisible = true
            fifth.isVisible = true
        }

        var runnableOpen = Runnable {
            menu.State = StatusButton.OPEN
            background.isVisible = true
            background.animate().alpha(1F)
            handler.postDelayed(runnable, 400L)
            menu.invalidate()
        }

        var runnableClose = Runnable {
            menu.State = StatusButton.CLOSE
            background.animate().alpha(0F)
            menu.invalidate()
            first.isInvisible = true
            second.isInvisible = true
            third.isInvisible = true
            fourth.isInvisible = true
            fifth.isInvisible = true
            if (background.alpha <= 0) {
                background.isInvisible = true
            }
        }

        if (menu.State == StatusButton.CLOSE) {
            menu.State = StatusButton.TRANSITION
            menu.invalidate()
            handler.postDelayed(runnableOpen, 100L)
        } else if (menu.State == StatusButton.OPEN){
            menu.State = StatusButton.TRANSITION
            menu.invalidate()
            handler.postDelayed(runnableClose, 100L)

        }
    }

    fun firstNavigation(){
        val intent = Intent(this, com.example.begin.AdventureActivity::class.java)
        ContextCompat.startActivity(this, intent, null)
    }

    fun secondNavigation(){
        val intent = Intent(this, CharacterListActivity::class.java)
        ContextCompat.startActivity(this, intent, null)
    }

    fun thirdNavigation(){
        val intent = Intent(this, LocationListActivity::class.java)
        ContextCompat.startActivity(this, intent, null)
    }

    fun fourthNavigation(){
        val intent = Intent(this, QwestListActivity::class.java)
        ContextCompat.startActivity(this, intent, null)
    }

    fun fifthNavigation(){
        val intent = Intent(this, NoteListActivity::class.java)
        ContextCompat.startActivity(this, intent, null)
    }
}