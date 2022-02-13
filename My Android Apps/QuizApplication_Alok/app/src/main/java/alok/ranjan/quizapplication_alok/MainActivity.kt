package alok.ranjan.quizapplication_alok

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var x = Color()

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        btn_start.setOnClickListener {
            if(edit_text.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter your name...", Toast.LENGTH_SHORT).show()
            }else{
                Constants.user_name = edit_text.text.toString()
                val intent = Intent(this, QuestionActivity::class.java)
                startActivity(intent)
            }
        }
    }
}