package com.example.calc_testing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener{
            if(et_name.text!!.isEmpty()){
                Toast.makeText(this, "Please enter your name...", Toast.LENGTH_SHORT).show()
            }else {
                val intent = Intent(this, QuizQuestionActivity::class.java)
                startActivity(intent)
            }
        }
    }
}