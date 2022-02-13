package alok.ranjan.drawingapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class DrawPath(context: Context, attrs: AttributeSet): View(context, attrs) {

    private var path: Path? = null
    private var path1: Path? = null
    private var paint: Paint? = null
    var ptPath: paintPath? = null
    private val pathList = ArrayList<Path>()
    val pathUndo: ArrayList<paintPath> = ArrayList()



    init {
        paint = Paint()
        path = Path()
        paint!!.style = Paint.Style.STROKE
        paint!!.color = Color.BLACK
        paint!!.isAntiAlias = true
        paint!!.strokeCap = Paint.Cap.ROUND
        paint!!.strokeJoin = Paint.Join.ROUND
        paint!!.strokeWidth = 15f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        for(pth in pathList){
            canvas.drawPath(pth, paint!!)
        }
        canvas.drawPath(path!!, paint!!)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val posX = event!!.x
        val posY = event.y
        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                path!!.moveTo(posX, posY)
                invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                path!!.lineTo(posX, posY)
                invalidate()
            }
            MotionEvent.ACTION_UP -> {
                path!!.lineTo(posX, posY)
                add()
                path!!.reset()
                invalidate()
            }
            else -> {
                return false
            }
        }
        return true
    }

    fun add(){


    }
}