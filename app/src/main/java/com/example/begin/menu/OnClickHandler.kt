package com.example.begin.menu

import android.content.Context
import android.os.Handler
import android.view.View
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.begin.R

class OnClickHandler(context: Context){

    var view = View(context)

    val menu = view.findViewById<BigCircleMenu>(R.id.big_menu)
    val background = view.findViewById<BackgroundMenu>(R.id.background_menu)
    val first = view.findViewById<CircleMenu>(R.id.circle_menu1)
    val second = view.findViewById<CircleMenu>(R.id.circle_menu2)
    val third = view.findViewById<CircleMenu>(R.id.circle_menu3)
    val fourth = view.findViewById<CircleMenu>(R.id.circle_menu4)
    val fifth = view.findViewById<CircleMenu>(R.id.circle_menu5)


    fun menuAction(){
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

    fun firstButton(view: View){
        //val intent = Intent(context, )
        //ContextCompat.startActivity(context, intent, null)
    }

}