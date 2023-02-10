package com.example.begin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.begin.menu.BackgroundMenu
import com.example.begin.menu.BigCircleMenu
import com.example.begin.menu.CircleMenu
import com.example.begin.menu.StatusButton


class Adventure : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adventure)

        val menu = findViewById<BigCircleMenu>(R.id.big_menu)
        val background = findViewById<BackgroundMenu>(R.id.background)
        val first = findViewById<CircleMenu>(R.id.circle_menu1)
        val second = findViewById<CircleMenu>(R.id.circle_menu2)
        val third = findViewById<CircleMenu>(R.id.circle_menu3)
        val fourth = findViewById<CircleMenu>(R.id.circle_menu4)
        val fifth = findViewById<CircleMenu>(R.id.circle_menu5)

        background.alpha = 0F
        background.isInvisible = true
        first.isInvisible = true
        second.isInvisible = true
        third.isInvisible = true
        fourth.isInvisible = true
        fifth.isInvisible = true
    }

        fun back(view: View) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    fun bigCircle (view: View){
        val menu = findViewById<BigCircleMenu>(R.id.big_menu)
        val background = findViewById<BackgroundMenu>(R.id.background_menu)
        val first = findViewById<CircleMenu>(R.id.circle_menu1)
        val second = findViewById<CircleMenu>(R.id.circle_menu2)
        val third = findViewById<CircleMenu>(R.id.circle_menu3)
        val fourth = findViewById<CircleMenu>(R.id.circle_menu4)
        val fifth = findViewById<CircleMenu>(R.id.circle_menu5)

        if (menu.State == StatusButton.CLOSE){
            menu.State = StatusButton.TRANSITION
            menu.invalidate()
            var x = 0
            while (x<100){
                x++
            }
            menu.State = StatusButton.OPEN
            background.animate().setDuration(500)
            background.isVisible = true
            background.animate().alpha(1F)
            menu.invalidate()
            first.isVisible = true
            second.isVisible = true
            third.isVisible = true
            fourth.isVisible = true
            fifth.isVisible = true
            first.foreground = getDrawable(R.drawable.character)
            second.foreground = getDrawable(R.drawable.location)
            third.foreground = getDrawable(R.drawable.npc)
            fourth.foreground = getDrawable(R.drawable.qwest)
            fifth.foreground = getDrawable(R.drawable.note2)
        } else {
            if (menu.State == StatusButton.OPEN) {
                menu.State = StatusButton.TRANSITION
                menu.invalidate()
                var x = 0
                while (x<100){
                    x++
                }
                menu.State = StatusButton.CLOSE
                first.isInvisible = true
                second.isInvisible = true
                third.isInvisible = true
                fourth.isInvisible = true
                fifth.isInvisible = true
                background.animate().setDuration(500)
                background.animate().alpha(0F)
                menu.invalidate()
                if(background.alpha<=0){
                    background.isInvisible = true}
            }
        }
    }

    fun firstTest(view: View){
        val first = findViewById<CircleMenu>(R.id.circle_menu1)
        if (first.State == StatusButton.OPEN){
            first.State = StatusButton.TRANSITION
            first.invalidate()}
        val intent = Intent(this, com.example.begin.Character::class.java)
        startActivity(intent)
    }

    fun secondTest(view: View){
        val second = findViewById<CircleMenu>(R.id.circle_menu2)
        if (second.State == StatusButton.OPEN){
            second.State = StatusButton.TRANSITION
            second.invalidate()}
        val intent = Intent(this, Location::class.java)
        startActivity(intent)
    }

    fun thirdTest(view: View){
        val third = findViewById<CircleMenu>(R.id.circle_menu3)
        if (third.State == StatusButton.OPEN){
            third.State = StatusButton.TRANSITION
            third.invalidate()}
        val intent = Intent(this, NPC::class.java)
        startActivity(intent)
    }

    fun fourthTest(view: View){
        val fourth = findViewById<CircleMenu>(R.id.circle_menu4)
        if (fourth.State == StatusButton.OPEN){
            fourth.State = StatusButton.TRANSITION
            fourth.invalidate()}
        val intent = Intent(this, Qwest::class.java)
        startActivity(intent)
    }

    fun fifthTest(view: View){
        val fifth = findViewById<CircleMenu>(R.id.circle_menu5)
        if (fifth.State == StatusButton.OPEN){
            fifth.State = StatusButton.TRANSITION
            fifth.invalidate()}
        val intent = Intent(this, Note::class.java)
        startActivity(intent)
    }
}
