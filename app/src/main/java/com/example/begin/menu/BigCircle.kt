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


class BigCircle (context: Context, attr: AttributeSet?=null): View(context, attr) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()
    private var color1 = getColor(context, R.color.light_grey_green)
    private var color2 = getColor(context, R.color.green)
    private var color3 = getColor(context, R.color.black)
    var State = StatusButton.CLOSE
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
        drawButton(canvas)
    }


    private fun drawButton(canvas: Canvas){
        path.reset()
        if (State == StatusButton.CLOSE) {
            drawCircle(canvas, color1, devider.toDouble())
        }
        if (State == StatusButton.TRANSIRIONONE){
            var d = devider
            var dd = 0
            while (d > 0){
                drawCircle(canvas, color1, (d).toDouble())
                d --
            }
            while (dd<devider*1.1){
                drawCircle(canvas, color3, (devider*1.1).toDouble())
                dd ++
            }
        }
        if (State == StatusButton.TRANSITION) {
            drawCircle(canvas, color2, (devider).toDouble())
        }
        //if (State == StatusButton.TRANSITIONTWO){
         //   var d = 0
         //   var dd = devider*1.1
         //   while(dd>0){
         //       drawCircle(canvas, color1, (dd).toDouble())
         //       dd --
         //   }
        //    while (d<devider){
        //        drawCircle(canvas, color3, (d).toDouble())
        //        d ++
        //    }
        //}
        if (State == StatusButton.OPEN) {
            drawCircle(canvas, color3, (devider*1.1).toDouble())
            }
        }



    fun check(){
        if (State == StatusButton.CLOSE){
            State = StatusButton.OPEN
            invalidate()
        }
        if (State == StatusButton.OPEN){
            State = StatusButton.CLOSE
            invalidate()
        }
    }

    fun ClickMenu() {
            State = StatusButton.TRANSITION
            invalidate()
            State = StatusButton.OPEN
            invalidate()
            State = StatusButton.TRANSITION
            invalidate()
            State = StatusButton.CLOSE
            invalidate() }



    fun Stable(){
        State = StatusButton.CLOSE
        invalidate()
    }


    fun drawCircle(canvas: Canvas, color:Int, d: Double){
        paint.color = color
        paint.style = Paint.Style.FILL
        var a = getScreenWidth()/d.toFloat()
        path.addCircle(a, a, a, Path.Direction.CCW)
        canvas.drawPath(path, paint)
    }

    /*fun startAnimation(){
        var colorFrom = getColor(context, R.color.light_grey_green)
        var colorTo = getColor(context, R.color.black)
        var colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), colorFrom, colorTo)
        colorAnimation.setDuration(30L)
        colorAnimation.start()*/
    }
