package alok.ranjan.testing

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_2.*

class Activity_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        btn_submit.setOnClickListener{
            if(et_name.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter your name......", Toast.LENGTH_SHORT).show()
            }else if(et_email.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter your email id...", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent()
                intent.putExtra(MainActivity.NAME, et_name.text.toString())
//                intent.putExtra(MainActivity.EMAIL, et_email.text.toString())
                setResult(Activity.RESULT_OK)
                finish()
            }
        }
    }
}