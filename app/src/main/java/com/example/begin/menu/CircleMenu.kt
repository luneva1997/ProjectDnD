package com.example.begin.menu

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.example.begin.R

class CircleMenu (context: Context, attr: AttributeSet?=null): View(context, attr){
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()
    var devider = 17
    var State = StatusButton.TRANSITION
    var first = findViewById<Circle>(R.id.First)
    var second = findViewById<Circle>(R.id.Second)
    var third = findViewById<Circle>(R.id.Third)
    var forth = findViewById<Circle>(R.id.Fourth)
    var fifth = findViewById<Circle>(R.id.Fifth)

    fun getScreenWidth(): Int{
        return Resources.getSystem().displayMetrics.widthPixels
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int){
        setMeasuredDimension(getScreenWidth()/devider*2, getScreenWidth()/devider*2)
    }

    override fun onDraw(canvas: Canvas) {
        path.reset()
        drawCircle(canvas)
    }

    fun drawCircle(canvas: Canvas){
        paint.style = Paint.Style.FILL
        if (State ==StatusButton.OPEN) {
            paint.color = resources.getColor(R.color.green)
            path.addCircle(
                (getScreenWidth() / devider).toFloat(),
                (getScreenWidth() / devider).toFloat(),
                (getScreenWidth() / devider).toFloat(),
                Path.Direction.CCW
            )
            canvas.drawPath(path, paint)
        }
    }

}