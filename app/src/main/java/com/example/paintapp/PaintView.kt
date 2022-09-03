package com.example.paintapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.example.paintapp.MainActivity.Companion.paintBrush
import com.example.paintapp.MainActivity.Companion.path

class PaintView: View {

    var params:ViewGroup.LayoutParams?=null        // It specify the dimension of the Layout wrt parent

    companion object{
        var pathList=ArrayList<Path>()              // to store the paths drawn by the brush
        var colorList=ArrayList<Int>()              // As the Color return the int so it stores in the List
        var currentBrush=Color.BLACK
    }
    constructor(context: Context) : this(context, null){

        init()
    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0){

        init()
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {

        init()
    }

    private fun init(){
        paintBrush.isAntiAlias=true              // gives a good texture to the brush
        paintBrush.color= currentBrush
        paintBrush.style=Paint.Style.STROKE
        paintBrush.strokeJoin=Paint.Join.ROUND
        paintBrush.strokeWidth=8f

        params=ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        var x=event.x
        var y=event.y

        when(event.action){                       // WHEN ACT AS A SWITCH
            MotionEvent.ACTION_DOWN->{
                path.moveTo(x,y)
                return true
            }
            MotionEvent.ACTION_MOVE->{
                path.lineTo(x,y)
                pathList.add(path)
                colorList.add(currentBrush)
            }
            else->return false
        }
        postInvalidate()                // it tells the no-ui thread that there is a change in ui
        return false
    }

    override fun onDraw(canvas: Canvas) {

        // iterate through the PathList
        for(i in pathList.indices){
            paintBrush.setColor(colorList[i])
            canvas.drawPath(pathList[i], paintBrush)
            invalidate()                   // does the same work as Invalidate
        }
    }
}