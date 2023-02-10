package com.example.begin.menu

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import com.example.begin.R

class GroupMenu (context: Context, attr: AttributeSet? = null): ViewGroup (context, attr) {
    private val firstChild: View?get() = if (childCount>0) getChildAt(0) else null
    private val secondChild: View?get() = if (childCount>1) getChildAt(1) else null
    private val thirdChild: View?get() = if (childCount>2) getChildAt(2) else null
    private val fourthChild: View?get() = if (childCount>3) getChildAt(3) else null
    private val fifthChild: View?get() = if (childCount>4) getChildAt(4) else null
    private val sixthChild: View?get() = if (childCount>5) getChildAt(5) else null
    private val seventhChild: View?get() = if (childCount>6) getChildAt(6) else null

    private val bigCircle =findViewById<BigCircleMenu>(R.id.big_menu)
    private val background =findViewById<BackgroundMenu>(R.id.background_menu)
    private val first =findViewById<CircleMenu>(R.id.circle_menu1)
    private val second =findViewById<CircleMenu>(R.id.circle_menu2)
    private val third =findViewById<CircleMenu>(R.id.circle_menu3)
    private val fourth =findViewById<CircleMenu>(R.id.circle_menu4)
    private val fifth =findViewById<CircleMenu>(R.id.circle_menu5)

    //Узнаем размер экрана
    fun getScreenWidth(): Int{
        return Resources.getSystem().displayMetrics.widthPixels
    }

    //Устанавливаем размер viewgroup
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        checkChildrenCount()
        setMeasuredDimension((getScreenWidth()/1.9).toInt(), (getScreenWidth()/1.9).toInt())
    }

    private fun checkChildrenCount(){
        if (childCount > 7) error("CustomViewGroup should not contain more then 7 elements")
    }

    //Расставляем маленькие view внутри группы
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val width = measuredWidth
        val height = measuredHeight
        firstChild?.layout(width-bigCircle.getScreenWidth()/bigCircle.devider*2-10,height-bigCircle.getScreenWidth()/bigCircle.devider*2-10, measuredWidth-10, measuredHeight-10)
        secondChild?.layout(0,0,width,height)
        thirdChild?.layout((0.096*width).toInt(),height-10-first.getScreenWidth()/first.devider, width, height)
        fourthChild?.layout((0.21*width).toInt(), (0.78*height).toInt()-second.getScreenWidth()/second.devider, width, height)
        fifthChild?.layout((0.35*width).toInt(), (0.35*height).toInt(), width, height)
        sixthChild?.layout((0.78*width).toInt()-fourth.getScreenWidth()/fourth.devider, (0.21*height).toInt(), width, height)
        seventhChild?.layout(width-10-fifth.getScreenWidth()/fifth.devider, (0.096*height).toInt(), width, height)

    }

}