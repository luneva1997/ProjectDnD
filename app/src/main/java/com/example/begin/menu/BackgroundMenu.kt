package com.example.begin.menu

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.example.begin.R

class BackgroundMenu (context: Context, attr: AttributeSet?=null): View(context, attr){
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var State = StatusButton.CLOSE
    private var color1 = resources.getColor(R.color.blue)
    private var color2 = resources.getColor(R.color.black)
    private val path = Path()


    fun getScreenWidth(): Int{
        return Resources.getSystem().displayMetrics.widthPixels
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int){
        setMeasuredDimension((getScreenWidth()/1.7).toInt(), (getScreenWidth()/1.7).toInt())
    }

    override fun onDraw(canvas: Canvas) {
        drawArc(canvas)
    }

    fun drawArc(canvas: Canvas){
        paint.color =  color1
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = getScreenWidth().toFloat()/5
        path.addOval(getScreenWidth().toFloat()/10, getScreenWidth().toFloat()/10, getScreenWidth().toFloat(), getScreenWidth().toFloat(), Path.Direction.CCW)
        //path.addArc(oval, 270F, 360F)
        canvas.drawPath(path, paint)
    }
}