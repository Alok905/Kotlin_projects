package alok.ranjan.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(Constants.USER_NAME)
        tv_username.text = username
        val totalQuestions = intent.getStringExtra(Constants.TOTAL_QUESTIONS)
        val corretAnswer= intent.getStringExtra(Constants.CORRECT_ANSWERS)

        tv_score.text = "Your score is $corretAnswer out of $totalQuestions"

        btn_finish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}