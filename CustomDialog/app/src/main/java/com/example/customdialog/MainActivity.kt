package com.example.customdialog

import android.Manifest
import android.app.Dialog
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.media.session.PlaybackState
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_custom.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPermissionRequest.setOnClickListener {
            PermissionFun()
        }

        btnAlert.setOnClickListener{
            alertDialogFunction()
        }

        btnCustom.setOnClickListener{
            customDialogFunction()
        }

        btnCustomProgress.setOnClickListener{
            customProgressDialogFunction()
        }
    }

    private fun alertDialogFunction(){

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("This is Alert box....")
        val btnPos = DialogInterface.OnClickListener{
            dialog, which ->
            Toast.makeText(this, "Yes clicked", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        builder.setPositiveButton("Yes", btnPos)
        builder.setNeutralButton("Cancel") {
                dialog, which ->
            Toast.makeText(this, "Cancel clicked", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        builder.setNegativeButton("No") {
                dialog, which ->
            Toast.makeText(this, "No clicked", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        builder.show()


    }

    private fun customDialogFunction(){
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.dialog_custom)
        customDialog.tv_submit.setOnClickListener {
            Toast.makeText(applicationContext, "Submit clicked", Toast.LENGTH_SHORT).show()
            customDialog.dismiss()
        }
        customDialog.tv_cancel.setOnClickListener {
            Toast.makeText(applicationContext, "Cancel clicked", Toast.LENGTH_SHORT).show()
            customDialog.dismiss()
        }
        customDialog.tv_text.text = "It's custom dialogue message.."
        customDialog.show()
    }

    private fun customProgressDialogFunction(){
        val customProgressDialog = Dialog(this)

        customProgressDialog.setContentView(R.layout.dialog_custom_progress)

        customProgressDialog.show()
    }





    companion object{
        private const val CAMERA_LOCATION_PERMISSION_REQUEST_CODE = 12
        private const val CAMERA_PERMISSION_REQUEST_CODE = 12
    }

    private fun PermissionFun(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
            && ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Permissins already granted...", Toast.LENGTH_SHORT).show()
        }else {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION),
                CAMERA_LOCATION_PERMISSION_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == CAMERA_LOCATION_PERMISSION_REQUEST_CODE){
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Camera permission accepted", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Camera permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

}