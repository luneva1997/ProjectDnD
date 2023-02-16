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
    private var color1 = resources.getColor(R.color.blue)
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
        paint.strokeWidth = getScreenWidth()/5.toFloat()
        path.addArc(getScreenWidth().toFloat()/10+30, getScreenWidth().toFloat()/10+30, getScreenWidth()/1.6.toFloat(), getScreenWidth()/1.6.toFloat(), 90F, 270F) //, Path.Direction.CCW
        canvas.drawPath(path, paint)
    }
}