package com.example.begin.menu

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat.getColor
import com.example.begin.R

class BigCircleMenu (context: Context, attr: AttributeSet? = null):
View(context, attr){
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()
    val devider = 10
    var color1 = getColor(context, R.color.light_grey_green)
    var color2 = getColor(context, R.color.blue)
    var color3 = getColor(context, R.color.green)
    var State =StatusButton.CLOSE

    fun getScreenWidth(): Int{
        return Resources.getSystem().displayMetrics.widthPixels
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(getScreenWidth()/devider*2, getScreenWidth()/devider*2)
    }

    override fun onDraw(canvas: Canvas) {
        path.reset()
        drawCircle(canvas)
    }

    fun drawCircle(canvas: Canvas){
        paint.style = Paint.Style.FILL
        if (State == StatusButton.CLOSE){
            paint.color = color1
            var a = getScreenWidth()/devider.toFloat()
            path.addCircle(a, a, a, Path.Direction.CCW)
            canvas.drawPath(path, paint)
        }
        if (State == StatusButton.TRANSITION){
            paint.color = color3
            var a = getScreenWidth()/devider.toFloat()
            path.addCircle(a, a, a, Path.Direction.CCW)
            canvas.drawPath(path, paint)
        }
        if (State == StatusButton.OPEN){
            paint.color = color2
            val a = getScreenWidth()/(devider*1.1).toFloat()
            val b = getScreenWidth()/devider.toFloat()
            path.addCircle(b, b, a, Path.Direction.CCW)
            canvas.drawPath(path, paint)
        }
    }

}