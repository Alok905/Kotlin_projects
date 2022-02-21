package com.example.permissionexample

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* 1:  button clicked */

        btnCameraPermission.setOnClickListener{
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission already granted....", Toast.LENGTH_SHORT).show()
            }else{
                //request permission
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION),
                    CAMERA_AND_FINE_LOCATION_PERMISION_CODE)
                /* 2:  allow deny dialog will be displayed */
            }
        }
    }

    /* 3: after clicking allow or deny.. this function will be called */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == CAMERA_REQUEST_CODE){
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Camera granted..", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Camera Denied...", Toast.LENGTH_SHORT).show()
            }
        }else if(requestCode == FINE_LOCATION_PERMISSION_CODE){
            if(grantResults.isNotEmpty() && grantResults[1] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Location granted....", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Location denied...", Toast.LENGTH_SHORT).show()
            }
        }

    }

    companion object{
        private const val CAMERA_REQUEST_CODE = 1
        private const val FINE_LOCATION_PERMISSION_CODE = 2
        private const val CAMERA_AND_FINE_LOCATION_PERMISION_CODE = 12
    }


}