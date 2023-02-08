package com.example.begin

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.begin.menu.Background
import com.example.begin.menu.BigCircle
import com.example.begin.menu.Circle
import com.example.begin.menu.StatusButton
import kotlinx.coroutines.*


class Adventure : AppCompatActivity() {

    val scope = CoroutineScope(Dispatchers.Main.immediate + SupervisorJob())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adventure)

        var menuCircle = findViewById<BigCircle>(R.id.AddCircle)
        var background = findViewById<Background>(R.id.background)
        var first = findViewById<Circle>(R.id.First)
        var second = findViewById<Circle>(R.id.Second)
        var third = findViewById<Circle>(R.id.Third)
        var fourth = findViewById<Circle>(R.id.Fourth)
        var fifth = findViewById<Circle>(R.id.Fifth)
        background.isInvisible = true
        first.isInvisible = true
        second.isInvisible = true
        third.isInvisible = true
        fourth.isInvisible = true
        fifth.isInvisible = true

        menuCircle.setOnClickListener {
            scope.launch {
                if (menuCircle.State != StatusButton.OPEN) {
                    async {
                        background.isVisible = true
                   //first.isVisible = true
                    //    {second.isVisible = true
                     //       third.isVisible = true
                     //           fourth.isVisible = true
                      //              fifth.isVisible = true
                        menuCircle.ClickMenu()
                    }}
                if (menuCircle.State == StatusButton.OPEN) {
                    async {
                        background.isInvisible = true
                       //first.isInvisible = true
                             //second.isInvisible = true
                                // third.isInvisible = true
                                     //fourth.isInvisible = true
                                        // fifth.isInvisible = true
                        scope.coroutineContext.cancelChildren()
                        menuCircle.Stable()
                    }}
                }
            }


        //first.setOnClickListener {
        //    first.update()
        //    var toast = Toast.makeText(this, "Это первая кнопка", Toast.LENGTH_LONG)
        //    toast.show()
        //}

        //second.setOnClickListener {
        //    second.update()
           //var toast = Toast.makeText(this, "Это вторая кнопка", Toast.LENGTH_LONG)
            //toast.show()
        //}

        //third.setOnClickListener {
        //    third.update()
            //var toast = Toast.makeText(this, "Это третья кнопка", Toast.LENGTH_LONG)
            //toast.show()
        //}

        //fourth.setOnClickListener {
        //    fourth.update()
            //var toast = Toast.makeText(this, "Это четвертая кнопка", Toast.LENGTH_LONG)
            //toast.show()
        //}

        //fifth.setOnClickListener {
        //    fifth.update()
            //var toast = Toast.makeText(this, "Это пятая кнопка", Toast.LENGTH_LONG)
            //toast.show()
        //}
    }

        fun back(view: View) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

}
