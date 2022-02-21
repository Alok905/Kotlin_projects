package com.example.drawappself

import android.app.Dialog
import android.graphics.Color
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.brush_size_picker_dialog.*

class MainActivity : AppCompatActivity() {

    var mSelectedColorIcon: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSelectedColorIcon = ll_color[0] as ImageButton

        ib_brush.setOnClickListener {
            brushSizeChooser()
        }
    }

    fun colorIconClicked(view: View){
        if(view != mSelectedColorIcon){
            val selectedColor = Color.parseColor(view.tag.toString())
            drawing_view.setColor(selectedColor)

            mSelectedColorIcon!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.color_palate_default))
            mSelectedColorIcon = view as ImageButton
            mSelectedColorIcon!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.color_palate_selected))
        }
    }

    fun brushSizeChooser(){
        val brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.brush_size_picker_dialog)
        brushDialog.setTitle("Select brush size...")

        brushDialog.ib_smallBrush.setOnClickListener {
            drawing_view.setBrushSize(10.toFloat())
            brushDialog.dismiss()
        }
        brushDialog.ib_mediumBrush.setOnClickListener {
            drawing_view.setBrushSize(20.toFloat())
            brushDialog.dismiss()
        }
        brushDialog.ib_largeBrush.setOnClickListener {
            drawing_view.setBrushSize(30.toFloat())
            brushDialog.dismiss()
        }

        brushDialog.show()
    }


}