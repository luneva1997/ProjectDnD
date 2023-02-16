package com.example.begin.menu

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat.getColor
import androidx.core.content.ContextCompat.getDrawable
import androidx.core.graphics.drawable.toBitmap
import com.example.begin.R


class BigCircleMenu (context: Context, attr: AttributeSet? = null):
View(context, attr){
    private val Firstpaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val devider = 10
    var devider2 = 12
    private val path = Path()
    var State =StatusButton.CLOSE
    private var picture = getDrawable(context, R.drawable.adventure)!!.toBitmap()
    private var pictureScaled:Bitmap = Bitmap.createScaledBitmap(picture, getScreenWidth()/devider*2, getScreenWidth()/devider*2, true)
    private var pictureScaled2:Bitmap = Bitmap.createScaledBitmap(picture, getScreenWidth()/devider2*2, getScreenWidth()/devider2*2, true)

    fun getScreenWidth(): Int{
        return Resources.getSystem().displayMetrics.widthPixels
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (State == StatusButton.CLOSE){
            setMeasuredDimension(getScreenWidth()/devider*2, getScreenWidth()/devider*2)
        }
        if (State == StatusButton.OPEN){
            setMeasuredDimension(getScreenWidth()/devider2*2, getScreenWidth()/devider2*2)
        }
    }

    fun setPicture (id: Int){
        picture = getDrawable(context, id)!!.toBitmap()
        pictureScaled = Bitmap.createScaledBitmap(picture, getScreenWidth()/(devider+1)*2, getScreenWidth()/(devider+1)*2, true)
        pictureScaled2 = Bitmap.createScaledBitmap(picture, getScreenWidth()/(devider2+1)*2, getScreenWidth()/(devider2+1)*2, true)
    }

    override fun onDraw(canvas: Canvas) {
        path.reset()
        paint.setXfermode(PorterDuffXfermode(PorterDuff.Mode.SRC_OVER))
        drawCircle(canvas)
        if (State == StatusButton.CLOSE){
            canvas.drawBitmap(pictureScaled,0F, 0F, paint)}
        else if (State == StatusButton.OPEN){
            canvas.drawBitmap(pictureScaled2,20F, 20F, paint)
        }
    }

    fun drawCircle(canvas: Canvas){
        Firstpaint.style = Paint.Style.FILL
        if (State == StatusButton.CLOSE){
            Firstpaint.color = getColor(context, R.color.light_grey_green)
            var a = getScreenWidth()/devider.toFloat()
            path.addCircle(a, a, a, Path.Direction.CCW)
            canvas.drawPath(path, Firstpaint)
        }
        else if (State == StatusButton.TRANSITION){
            Firstpaint.color = getColor(context, R.color.green)
            val a = getScreenWidth()/(devider).toFloat()
            path.addCircle(a, a, a, Path.Direction.CCW)
            canvas.drawPath(path, Firstpaint)
        }
        else if (State == StatusButton.OPEN){
            Firstpaint.color = getColor(context, R.color.blue)
            val a = getScreenWidth()/(devider2).toFloat()
            val b = getScreenWidth()/devider.toFloat()
            path.addCircle(b, b, a, Path.Direction.CCW)
            canvas.drawPath(path, Firstpaint)
        }
    }

}