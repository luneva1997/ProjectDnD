package com.example.begin.menu

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.example.begin.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Circle (context: Context, attr: AttributeSet?=null): View(context, attr){
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()
    private var devider = 17
    var CircleRadius = getScreenWidth()/devider*2
    var State = StatusButton.OPEN
    var color1 = resources.getColor(R.color.black)
    var color2 = resources.getColor(R.color.green)
    var first = findViewById<Circle>(R.id.First)
    var second = findViewById<Circle>(R.id.Second)
    var third = findViewById<Circle>(R.id.Third)
    var forth = findViewById<Circle>(R.id.Fourth)
    var fifth = findViewById<Circle>(R.id.Fifth)
    var circle = View(context)

    fun getScreenWidth(): Int{
        return Resources.getSystem().displayMetrics.widthPixels
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int){
        setMeasuredDimension(getScreenWidth()/devider*2, getScreenWidth()/devider*2)
    }

    override fun onDraw(canvas: Canvas){
        super.onDraw(canvas)
        path.reset()
        if (State == StatusButton.OPEN){
            drawCircle(canvas, color1)}
        if (State ==StatusButton.TRANSITION){
            drawCircle(canvas, color2)
        }
    }

    fun update(){
        runBlocking {
            launch{
                State = StatusButton.TRANSITION
                circle.invalidate()
                delay(3000)
                State = StatusButton.OPEN
                circle.invalidate()
            }
    }
    }

    fun drawCircle(canvas: Canvas, color: Int){
        paint.style = Paint.Style.FILL
        paint.color = color
        path.addCircle((getScreenWidth()/devider).toFloat(), (getScreenWidth()/devider).toFloat(), (getScreenWidth()/devider).toFloat(), Path.Direction.CCW)
        canvas.drawPath(path, paint)
    }

}