package com.example.begin.menu

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.example.begin.R

class Background (context: Context, attr: AttributeSet?=null): View(context, attr){
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var oval = RectF(getScreenWidth().toFloat(), getScreenWidth().toFloat(), getScreenWidth()/10F, getScreenWidth()/10F)
    var State = StatusButton.CLOSE
    private var color1 = resources.getColor(R.color.blue)
    private var color2 = resources.getColor(R.color.black)

    fun getScreenWidth(): Int{
        return Resources.getSystem().displayMetrics.widthPixels
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int){
        setMeasuredDimension(getScreenWidth()/2, getScreenWidth()/2)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawArc(canvas, color1)
        }


    var background = findViewById<Background>(R.id.background)

    fun status() {
        State = StatusButton.OPEN
    }

    fun drawArc(canvas: Canvas, color:Int){
        paint.color =  color
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = getScreenWidth().toFloat()/5
        canvas.drawArc(oval, 270F, 360F, true, paint)
    }

}