package com.example.drawappself

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View

class DrawingView(context: Context, attrs: AttributeSet): View(context, attrs) {

    private var mCustomPath: CustomPath? = null
    private val mPaths: ArrayList<CustomPath> = ArrayList()
    private var paint: Paint? = null
    private var color: Int = Color.BLACK
    private var mBrushSize: Float = 0.toFloat()

    init {
        setUpDrawing()
    }

    private fun setUpDrawing(){
        mCustomPath = CustomPath(color, mBrushSize)

        setBrushSize(20.toFloat())

        paint = Paint()
        paint!!.color = color
        paint!!.style = Paint.Style.STROKE
        paint!!.strokeWidth = mBrushSize
        paint!!.strokeJoin = Paint.Join.ROUND
        paint!!.strokeCap = Paint.Cap.ROUND
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        for(path in mPaths){
            paint!!.color = path.color
            paint!!.strokeWidth = path.brushThickness
            canvas!!.drawPath(path, paint!!)
        }
        if(mCustomPath != null){
            paint!!.color = color
            paint!!.strokeWidth = mBrushSize
            canvas!!.drawPath(mCustomPath!!, paint!!)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val touchX = event!!.x
        val touchY = event.y
        when(event.action){

            MotionEvent.ACTION_DOWN -> {
                mCustomPath!!.brushThickness = mBrushSize
                mCustomPath!!.color = color
                mCustomPath!!.moveTo(touchX, touchY)
            }
            MotionEvent.ACTION_MOVE -> {
                mCustomPath!!.lineTo(touchX, touchY)
            }
            MotionEvent.ACTION_UP -> {
                mCustomPath!!.lineTo(touchX, touchY)
                mPaths.add(mCustomPath!!)
                mCustomPath = CustomPath(color, mBrushSize)
            }
            else -> {
                return false
            }

        }

        invalidate()

        return true
    }

    fun setColor(selectedColor: Int){
        color = selectedColor
    }

    fun setBrushSize(selectedBrushSize: Float){
        mBrushSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, selectedBrushSize, resources.displayMetrics)
    }

    internal inner class CustomPath(var color: Int, var brushThickness: Float): Path() {

    }
}