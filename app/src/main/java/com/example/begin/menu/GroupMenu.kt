package com.example.begin.menu

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

class GroupMenu (context: Context, attr: AttributeSet? = null): ViewGroup (context, attr) {
    val bidCircle = BigCircleMenu(context, attr)
    val circle = CircleMenu(context, attr)

    private val firstChild: View?get() = if (childCount>0) getChildAt(0) else null
    private val secondChild: View?get() = if (childCount>1) getChildAt(1) else null
    private val thirdChild: View?get() = if (childCount>2) getChildAt(2) else null
    private val fourthChild: View?get() = if (childCount>3) getChildAt(3) else null
    private val fifthChild: View?get() = if (childCount>4) getChildAt(4) else null
    private val sixthChild: View?get() = if (childCount>5) getChildAt(5) else null
    private val seventhChild: View?get() = if (childCount>6) getChildAt(6) else null

    //private val bigCircle =findViewById<BigCircleMenu>(R.id.big_menu)
    //private val background =findViewById<BackgroundMenu>(R.id.background_menu)
    //private val first =findViewById<CircleMenu>(R.id.circle_menu1)
    //private val second =findViewById<CircleMenu>(R.id.circle_menu2)
    //private val third =findViewById<CircleMenu>(R.id.circle_menu3)
    //private val fourth =findViewById<CircleMenu>(R.id.circle_menu4)
    //private val fifth =findViewById<CircleMenu>(R.id.circle_menu5)

    //Узнаем размер экрана
    fun getScreenWidth(): Int{
        return Resources.getSystem().displayMetrics.widthPixels
    }

    //Устанавливаем размер viewgroup
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        checkChildrenCount()
        setMeasuredDimension((getScreenWidth()/2).toInt(), (getScreenWidth()/2).toInt())
    }

    private fun checkChildrenCount(){
        if (childCount > 7) error("CustomViewGroup should not contain more then 7 elements")
    }

    //Расставляем маленькие view внутри группы
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val width = measuredWidth
        val height = measuredHeight
        firstChild?.layout(width-(getScreenWidth()/bidCircle.devider)*2-10,height-(getScreenWidth()/bidCircle.devider)*2-10, width-10, height-10)
        secondChild?.layout(0,0,width,height)
        thirdChild?.layout((0.12*width).toInt(),height-10-(getScreenWidth()/circle.devider)*2, (0.12*width).toInt()+(getScreenWidth()/circle.devider)*2, height)
        fourthChild?.layout((0.15*width).toInt(), (0.75*height).toInt()-(getScreenWidth()/circle.devider)*2, (0.15*width).toInt()+(getScreenWidth()/circle.devider)*2, (0.75*height).toInt())
        fifthChild?.layout((0.27*width).toInt(), (0.27*height).toInt(), (0.27*width).toInt()+(getScreenWidth()/circle.devider)*2, (0.27*height).toInt()+(getScreenWidth()/circle.devider)*2)
        sixthChild?.layout((0.76*width).toInt()-(getScreenWidth()/circle.devider)*2, (0.15*height).toInt(), (0.76*width).toInt(), (0.15*height).toInt()+(getScreenWidth()/circle.devider)*2)
        seventhChild?.layout(width-10-(getScreenWidth()/circle.devider)*2, (0.12*height).toInt(), width, (0.12*height).toInt()+(getScreenWidth()/circle.devider)*2)

    }

}