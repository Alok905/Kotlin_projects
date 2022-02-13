package alok.ranjan.quizapplication_alok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        outer_linres.background = ContextCompat.getDrawable(this, R.drawable.outer_lin)
        res_linear.background = ContextCompat.getDrawable(this, R.drawable.result_bg)
        tv_user_name.text = Constants.user_name
        tv_score.text = "Your score is ${Constants.score} out of ${Constants.total_question}"


        btn_finish.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}