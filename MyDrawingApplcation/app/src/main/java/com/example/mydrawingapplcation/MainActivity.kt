package com.example.mydrawingapplcation

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.view.contentcapture.ContentCaptureSession
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialogue_brush_size.*


class MainActivity : AppCompatActivity() {

    private var mImageButtonCurrentPaint: ImageButton? = null

    val openGalleryLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if(result.resultCode == RESULT_OK && result.data != null){
                iv_background.setImageURI(result.data?.data)
            }
        }

    val requestPermission: ActivityResultLauncher<Array<String>> =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){
                permissions ->

            permissions.entries.forEach {

                val permissionName = it.key
                val isGranted = it.value

                if(isGranted){

                    Toast.makeText(this, "Storage permission already granted", Toast.LENGTH_SHORT).show()


                    val pickIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    openGalleryLauncher.launch(pickIntent)

                }else{
                    if (permissionName == Manifest.permission.READ_EXTERNAL_STORAGE){
                        Toast.makeText(this, "Ooops u just denied the permission", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }





    /* --------------------------------------------------------------------------------------- */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawing_view.setSizeForBrush(20f)

        mImageButtonCurrentPaint = ll_paint_colors[0] as ImageButton  /* LinearLayout can be used as an ArrayLIst */
        mImageButtonCurrentPaint!!.setImageDrawable(
            ContextCompat.getDrawable(this, R.drawable.palate_pressed)
        )

        ib_brush.setOnClickListener {
            showBrushSizeChooserDialog()
        }

        ib_gallery.setOnClickListener {
            requestStoragePermission()
        }

        ib_undo.setOnClickListener {
            drawing_view.onClickUndo()
        }
        ib_redo.setOnClickListener {
            drawing_view.onClickRedo()
        }

    }
    /* --------------------------------------------------------------------------------------- */





    private fun showBrushSizeChooserDialog(){
        val brushDialogue = Dialog(this)
        brushDialogue.setContentView(R.layout.dialogue_brush_size)
        brushDialogue.setTitle("Brush Size: ")
        val smallBtn = brushDialogue.ib_small_brush
        smallBtn.setOnClickListener{
            drawing_view.setSizeForBrush(10f)
            brushDialogue.dismiss()
        }
        val mediumBtn = brushDialogue.ib_medium_brush
        mediumBtn.setOnClickListener {
            drawing_view.setSizeForBrush(20f)
            brushDialogue.dismiss()
        }
        val largeBtn = brushDialogue.ib_large_brush
        largeBtn.setOnClickListener {
            drawing_view.setSizeForBrush(30f)
            brushDialogue.dismiss()
        }
        brushDialogue.show()
    }

    fun paintClicked(view: View){
        if(view != mImageButtonCurrentPaint){
            val imageButton = view as ImageButton

            val colorTag = imageButton.tag.toString()
            drawing_view.setColor(colorTag)

            mImageButtonCurrentPaint!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.palate_normal))

            mImageButtonCurrentPaint = imageButton
            mImageButtonCurrentPaint!!.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.palate_pressed))
        }
    }



    private fun requestStoragePermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)){
            showRationaleDialog("Kids Drawing App",
                "Kids Drawing App " + "needs to access your external storage")
        }else{
            requestPermission.launch(
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
                // TODO - Add writing external storage permission
            )
        }
    }


    private fun showRationaleDialog(
        title: String,
        message: String
    ){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
            .setMessage(message)
            .setPositiveButton("Cancel"){
                dialog, _ ->
                Toast.makeText(this, "Cancel clicked", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        builder.create().show()
    }

}