package alok.ranjan.testing

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var i: Int = 0
    var j: Int = 0
    companion object{
        private const val FIRST_ACTIVITY_REQUEST_CODE = 1
        private const val SECOND_ACTIVITY_REQUEST_CODE = 2
        const val NAME: String = "name"
        const val EMAIL: String = "abc@example.com"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_first.setOnClickListener{
            val intent = Intent(this, Activity_1::class.java)
            startActivityForResult(intent, FIRST_ACTIVITY_REQUEST_CODE)
        }
        btn_second.setOnClickListener{
            val intent = Intent(this, Activity_2::class.java)
            startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == FIRST_ACTIVITY_REQUEST_CODE) {
                i++
                tv_first_activity_result.text = "First Activity finished successfully $i"
            }else if(requestCode == SECOND_ACTIVITY_REQUEST_CODE){
//                j++
//                tv_second_activity_result.text = "Second activity $j"
                if(data != null) {
                    val name = data.getStringExtra(NAME)
                    tv_second_activity_result.text = "$name"
                }
            }
        }else{
            Toast.makeText(this, "Activity cancelled...", Toast.LENGTH_SHORT).show()
        }
    }


}