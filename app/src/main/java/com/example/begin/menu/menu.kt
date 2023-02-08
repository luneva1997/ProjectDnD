package com.example.begin.menu

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import com.example.begin.R

class menu(context: Context,
                      attr: AttributeSet? = null) :ViewGroup (context, attr), View.OnClickListener{
    //Список элементов меню
    private val firstChild: View?get() = if (childCount>0) getChildAt(0) else null
    private val secondChild: View?get() = if(childCount>1) getChildAt(1) else null
    private val thirdChild: View?get() = if(childCount>2) getChildAt(2) else null
    private val forthChild: View?get() = if(childCount>3) getChildAt(3) else null
    private val fifthChild: View?get() = if(childCount>4) getChildAt(4) else null
    private val sixthChild: View?get() = if(childCount>5) getChildAt(5) else null
    private val seventhChild: View?get() = if(childCount>6) getChildAt(6) else null
    private val BC = BigCircle(context, attr)
    private val C = Circle(context, attr)
    private val Cradius =C.CircleRadius
    private var MenuState = StatusButton.CLOSE


    //Узнаем размер экрана
    fun getScreenWidth(): Int{
        return Resources.getSystem().displayMetrics.widthPixels
    }

    //Устанавливаем размер viewgroup
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        checkChildrenCount()
        setMeasuredDimension(getScreenWidth()/2, getScreenWidth()/2)
    }

    //Расставляем маленькие view внутри группы
    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val width = measuredWidth
        val height = measuredHeight
        firstChild?.layout(width-BC.BigCircleDiametr-10,height-BC.BigCircleDiametr-10, measuredWidth-10, measuredHeight-10)
        secondChild?.layout(0,0,width,height)
        thirdChild?.layout((0.096*width).toInt(),height-10-Cradius, width, height)
        forthChild?.layout((0.21*width).toInt(), (0.78*height).toInt()-Cradius, width, height)
        fifthChild?.layout((0.35*width).toInt(), (0.35*height).toInt(), width, height)
        sixthChild?.layout((0.78*width).toInt()-Cradius, (0.21*height).toInt(), width, height)
        seventhChild?.layout(width-10-Cradius, (0.096*height).toInt(), width, height)

    }

    private fun checkChildrenCount(){
        if (childCount > 7) error("CustomViewGroup should not contain more then 7 elements")
    }

    override fun onClick(view: View?) {
        TODO("Not yet implemented")
    }

    fun ClickMenu(){
        var BigCircle = findViewById<BigCircle>(R.id.AddCircle)
        var Background = findViewById<Background>(R.id.background)
        BigCircle.State = StatusButton.OPEN

    }
    fun closeAnimation(){
    }

}