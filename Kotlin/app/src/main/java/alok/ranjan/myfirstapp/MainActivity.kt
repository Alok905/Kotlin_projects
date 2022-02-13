package alok.ranjan.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnclickme = findViewById<Button>(R.id.mybutton)
        val tvmytextview = findViewById<TextView>(R.id.textView)
        var timesclicked = 0
        btnclickme.setOnClickListener{
            btnclickme.text = "Click Me"
            timesclicked += 1;

            tvmytextview.text = "You clicked " + timesclicked.toString()
        }
    }
}