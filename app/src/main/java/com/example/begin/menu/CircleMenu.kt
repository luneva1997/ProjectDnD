package com.example.begin.menu

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat.getDrawable
import androidx.core.graphics.drawable.toBitmap
import com.example.begin.R

class CircleMenu (context: Context, attr: AttributeSet?=null): View(context, attr){
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paint2 = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()
    var devider = 17
    var w = getScreenWidth()/(devider+1)*2
    var first = getDrawable(resources, R.drawable.character, null)!!.toBitmap()
    var second = resources.getDrawable(R.drawable.location)!!.toBitmap()
    var third = ContextCompat.getDrawable(context, R.drawable.npc)!!.toBitmap()
    var fourth = ContextCompat.getDrawable(context, R.drawable.qwest)!!.toBitmap()
    var fifth = ContextCompat.getDrawable(context, R.drawable.note2)!!.toBitmap()
    var firstScaled = Bitmap.createScaledBitmap(first, w, w, true)
    var secondScaled = Bitmap.createScaledBitmap(second, w, w, true)
    var thirdScaled = Bitmap.createScaledBitmap(third, w, w, true)
    var fourthScaled = Bitmap.createScaledBitmap(fourth, w, w, true)
    var fifthScaled = Bitmap.createScaledBitmap(fifth, w, w, true)


    var State = StatusButton.CLOSE
    fun getScreenWidth(): Int{
        return Resources.getSystem().displayMetrics.widthPixels
    }

    fun setPictures(id1: Int, id2: Int, id3: Int, id4: Int, id5: Int){
         first = ContextCompat.getDrawable(context, id1)!!.toBitmap()
         second = ContextCompat.getDrawable(context, id2)!!.toBitmap()
         third = ContextCompat.getDrawable(context, id3)!!.toBitmap()
         fourth = ContextCompat.getDrawable(context, id4)!!.toBitmap()
         fifth = ContextCompat.getDrawable(context, id5)!!.toBitmap()
         firstScaled = Bitmap.createScaledBitmap(first, w, w, true)
         secondScaled = Bitmap.createScaledBitmap(second, w, w, true)
         thirdScaled = Bitmap.createScaledBitmap(third, w, w, true)
         fourthScaled = Bitmap.createScaledBitmap(fourth, w, w, true)
         fifthScaled = Bitmap.createScaledBitmap(fifth, w, w, true)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        setMeasuredDimension(getScreenWidth()/devider*2, getScreenWidth()/devider*2)
    }

    override fun onDraw(canvas: Canvas) {
        path.reset()
        //drawCircle(canvas)
        //paint2.setXfermode(PorterDuffXfermode(PorterDuff.Mode.DST_OVER))
        when (id){
            R.id.circle_menu1 -> canvas.drawBitmap(firstScaled,0F, 0F, paint2)
            R.id.circle_menu2 -> canvas.drawBitmap(secondScaled,0F, 0F, paint2)
            R.id.circle_menu3 -> canvas.drawBitmap(thirdScaled,0F, 0F, paint2)
            R.id.circle_menu4 -> canvas.drawBitmap(fourthScaled,0F, 0F, paint2)
            R.id.circle_menu5 -> canvas.drawBitmap(fifthScaled,0F, 0F, paint2)
        }
    }

    fun drawCircle(canvas: Canvas){
        paint.style = Paint.Style.FILL
        if (State == StatusButton.CLOSE){
            paint.color = resources.getColor(R.color.blue)
            path.addCircle(
                (getScreenWidth() / devider).toFloat(),
                (getScreenWidth() / devider).toFloat(),
                (getScreenWidth() / devider).toFloat(),
                Path.Direction.CCW
            )
            canvas.drawPath(path, paint)
        }
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