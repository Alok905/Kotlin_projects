package com.example.mydrawingapplicationself

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import androidx.constraintlayout.motion.widget.MotionInterpolator

class DrawingView(context: Context, attrs: AttributeSet): View(context, attrs) {

    private var mDrawPath: CustomPath? = null
    private var mPaths = ArrayList<CustomPath>()
    private var mDrawPaint: Paint? = null
    private var mCanvasPaint: Paint? = null
    private var mBrushSize: Float = 0.toFloat()
    private var color = Color.BLACK
    private var canvas: Canvas? = null
    private var mCanvasBitmap: Bitmap? = null

    init{
        setUpDrawing()
    }

    fun setUpDrawing(){

        mDrawPaint = Paint()
        mDrawPaint!!.style = Paint.Style.STROKE
        mDrawPaint!!.strokeWidth = mBrushSize
        mDrawPaint!!.strokeCap = Paint.Cap.ROUND
        mDrawPaint!!.strokeJoin = Paint.Join.ROUND
        mDrawPaint!!.color = color
        mDrawPath = CustomPath(color, mBrushSize)
        mCanvasPaint = Paint(Paint.DITHER_FLAG)

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mCanvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        canvas = Canvas(mCanvasBitmap!!)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        for(path in mPaths){
            mDrawPaint!!.color = path.color
            mDrawPaint!!.strokeWidth = path.brushThickness
            canvas.drawPath(path, mDrawPaint!!)
        }

        if(!mDrawPath!!.isEmpty){
            mDrawPaint!!.color = color
            mDrawPaint!!.strokeWidth = mBrushSize
            canvas.drawPath(mDrawPath!!, mDrawPaint!!)
        }

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        var touchX = event!!.x
        var touchY = event.y
        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                mDrawPath!!.reset()

                mDrawPath!!.color = color
                mDrawPath!!.brushThickness = mBrushSize

                mDrawPath!!.moveTo(touchX, touchY)
            }
            MotionEvent.ACTION_MOVE -> {
                mDrawPath!!.lineTo(touchX, touchY)
            }
            MotionEvent.ACTION_UP -> {
                mPaths.add(mDrawPath!!)
                mDrawPath = CustomPath(color, mBrushSize)
            }
            else -> {
                return false
            }
        }
        invalidate()
        return true
    }

    fun setColor(newColor: String){
        color = Color.parseColor(newColor)
    }

    fun setBrushSize(newSize: Float){
        mBrushSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, newSize, resources.displayMetrics)
    }


    internal inner class CustomPath(var color: Int, var brushThickness: Float): Path() {

    }


}