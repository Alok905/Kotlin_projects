package com.example.mydrawingapplicationself

import android.app.Dialog
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContentInfo
import android.view.View
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.brush_size_dialog.*

class MainActivity : AppCompatActivity() {

    var mChoosenColor: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawing_view.setBrushSize(10f)

        mChoosenColor = ll_color_palate[0] as ImageButton

        ib_brush_size.setOnClickListener {
            setBrushSizeDialog()
        }
    }

    fun setBrushSizeDialog(){
        val brushSizePicker = Dialog(this)
        brushSizePicker.setContentView(R.layout.brush_size_dialog)
        brushSizePicker.show()
        val small_brush = brushSizePicker.ib_small_brush
        val medium_brush = brushSizePicker.ib_medium_brush
        val large_brush = brushSizePicker.ib_large_brush
        small_brush.setOnClickListener {
            drawing_view.setBrushSize(10f)
            brushSizePicker.dismiss()
        }
        medium_brush.setOnClickListener {
            drawing_view.setBrushSize(20f)
            brushSizePicker.dismiss()
        }
        large_brush.setOnClickListener {
            drawing_view.setBrushSize(30f)
            brushSizePicker.dismiss()
        }

    }

    fun OnColorPalateChoose(view: View){

        val selectedNewColor = view as ImageButton

        if(mChoosenColor != selectedNewColor){
            drawing_view.setColor(selectedNewColor.tag.toString())

            mChoosenColor!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.paint_default))
            mChoosenColor = selectedNewColor
            mChoosenColor!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.paint_pressed))
        }

    }
}