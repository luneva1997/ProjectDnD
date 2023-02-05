package com.example.begin.menu

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.example.begin.R

class BigCircle (context: Context, attr: AttributeSet?=null): View(context, attr){
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()
    private var devider = 10
    var BigCircleDiametr = getScreenWidth()/devider*2

    fun getScreenWidth(): Int{
        return Resources.getSystem().displayMetrics.widthPixels
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int){
        setMeasuredDimension(getScreenWidth()/devider*2, getScreenWidth()/devider*2)
    }

    override fun onDraw(canvas: Canvas){
        super.onDraw(canvas)
        paint.color = resources.getColor(R.color.light_grey_green)
        paint.style = Paint.Style.FILL
        path.addCircle((getScreenWidth()/devider).toFloat(), (getScreenWidth()/devider).toFloat(), (getScreenWidth()/devider).toFloat(), Path.Direction.CCW)
        canvas.drawPath(path, paint)
    }

    //override fun onClick(){}
}