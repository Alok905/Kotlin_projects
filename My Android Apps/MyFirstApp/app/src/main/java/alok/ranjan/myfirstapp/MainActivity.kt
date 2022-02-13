package alok.ranjan.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClickMe = findViewById<Button>(R.id.mybutton)
        val tvTextView = findViewById<TextView>(R.id.textview)
        var x=0
        btnClickMe.setOnClickListener{
            x++
            btnClickMe.text = "hahahha"
            tvTextView.text = x.toString()
        }
    }
}