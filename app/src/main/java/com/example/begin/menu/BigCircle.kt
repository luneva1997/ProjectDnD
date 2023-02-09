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
import kotlinx.coroutines.*


class BigCircle (context: Context, attr: AttributeSet?=null): View(context, attr){
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()
    private var color1 = getColor(context, R.color.light_grey_green)
    private var color2 = getColor(context, R.color.green)
    private var color3 = getColor(context, R.color.blue)
    var State = StatusButton.CLOSE
    private var devider = 10
    var BigCircleDiametr = getScreenWidth()/devider*2
    val scope = CoroutineScope(Dispatchers.IO)

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
        if (State == StatusButton.TRANSITION) {
            drawCircle(canvas, color2, (devider).toDouble())
        }
        if (State == StatusButton.OPEN) {
            drawCircle(canvas, color3, (devider*1.1).toDouble())
            }
        }
    var BigCircle = findViewById<BigCircle>(R.id.AddCircle)

    suspend fun ClickMenu() = coroutineScope{
        async {
            BigCircle.State = StatusButton.TRANSITION
            BigCircle.invalidate()
            delay(100)
            BigCircle.State = StatusButton.OPEN
            BigCircle.invalidate()
            delay(3000)
            BigCircle.State = StatusButton.TRANSITION
            BigCircle.invalidate()
            delay(100)
            BigCircle.State = StatusButton.CLOSE
            BigCircle.invalidate()
            return@async
    }}



    fun Stable(){
        BigCircle.State = StatusButton.CLOSE
        BigCircle.invalidate()
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
