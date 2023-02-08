package com.example.begin.menu

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.View
import com.example.begin.R

class Circle (context: Context, attr: AttributeSet?=null): View(context, attr){
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()
    private var devider = 17
    var CircleRadius = getScreenWidth()/devider*2
    var State = StatusButton.CLOSE

    fun getScreenWidth(): Int{
        return Resources.getSystem().displayMetrics.widthPixels
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int){
        setMeasuredDimension(getScreenWidth()/devider*2, getScreenWidth()/devider*2)
    }

    override fun onDraw(canvas: Canvas){
        super.onDraw(canvas)
        paint.color = resources.getColor(R.color.black)
        paint.style = Paint.Style.FILL
        path.addCircle((getScreenWidth()/devider).toFloat(), (getScreenWidth()/devider).toFloat(), (getScreenWidth()/devider).toFloat(), Path.Direction.CCW)
        canvas.drawPath(path, paint)
    }

    fun ClickMenu() {
        var Circle = findViewById<Circle>(com.example.begin.R.id.AddCircle)
        Circle.State = StatusButton.OPEN
        Circle.invalidate()
        Handler(Looper.getMainLooper()).postDelayed(
            {
                Circle.State = StatusButton.CLOSE
                Circle.invalidate()
            },
            100
        )
    }
}