package alok.ranjan.kidsdrawingapp

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import org.xml.sax.helpers.AttributesImpl
import java.util.jar.Attributes

/*
    Canvas has a method to draw a rectangle, while Paint defines
    whether to fill that rectangle with a color or leave it
    empty. Simply put, Canvas defines shapes that you can draw
    on the screen, while Paint defines the color, style, font,
    and so forth of each shape you draw.
 */


/* when we have to draw something we have to include the View */
class DrawingView(context: Context, attrs: AttributeSet): View(context, attrs){

    /* Paint class stores the styles and colours */
    /* Bitmap is a file type on which we can draw on ...*/
    /* think your hand is canvas, printbrush with paint attached on it is pen and paper where u draw as bitmap*/
    /* canvas holds different methods to draw */

    private var mDrawPath: CustomPath? = null
    /* as path can draw line, circle, rectangle... but we want to create different type of curves as the user draw.. */

    private var mCanvasBitmap: Bitmap? = null
    /* the bitmap where the canvas will execute draw operations */

    private var mCanvasPaint: Paint? = null
    private var mDrawPaint: Paint? = null

    private var mBrushSize: Float = 0.toFloat()
    private var color: Int = Color.BLACK
    private var canvas: Canvas? = null

    init {
        setUpDrawing()
    }

    private fun setUpDrawing(){

        mDrawPaint = Paint()
        mDrawPath = CustomPath(color, mBrushSize)

        mDrawPaint!!.color = color
        mDrawPaint!!.strokeCap = Paint.Cap.ROUND
        mDrawPaint!!.strokeJoin = Paint.Join.ROUND
        mDrawPaint!!.style = Paint.Style.STROKE

        mCanvasPaint = Paint(Paint.DITHER_FLAG)

        mBrushSize = 20.toFloat()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        mCanvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        canvas = Canvas(mCanvasBitmap!!)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawBitmap(mCanvasBitmap!!, 0f, 0f, mCanvasPaint)

        if(!mDrawPath!!.isEmpty) {
            mDrawPaint!!.strokeWidth = mDrawPath!!.b
            canvas.drawPath(mDrawPath!!, mDrawPaint!!)
        }

    }



    internal inner class CustomPath(color: Int, brushThickness: Float): Path() {

    }
}