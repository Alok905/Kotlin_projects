package alok.ranjan.quizapplication

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    var myQuestionList: ArrayList<Questions>? = null
    var mySelectedOption: Int = 0
    var myCurrentPage: Int = 1
    var que: Questions? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        myQuestionList = Constants.getQuestions()

        setQuestions()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    private fun setQuestions(){

        que = myQuestionList!![myCurrentPage - 1]

        tv_question.text = que!!.question

        iv_image.setImageResource(que!!.image)

        id_progress.progress = myCurrentPage
        tv_progress.text = "${myCurrentPage}/${myQuestionList!!.size}"

        tv_option_one.text = que!!.option1
        tv_option_two.text = que!!.option2
        tv_option_three.text = que!!.option3
        tv_option_four.text = que!!.option4


    }

    private fun defaultOptionView(){
        val options: ArrayList<TextView> = ArrayList()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for(option in options){
            option.setTextColor(Color.parseColor("#5ABAFF"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_bg)
        }
    }

    private fun selectedOptionView(option: TextView){

        defaultOptionView()

        option.setTextColor(Color.parseColor("ffffff"))
        option.setTypeface(option.typeface, Typeface.BOLD)
        option.background = ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
    }

    private fun answerView(opt: Int, drawableView: Int){
        when(opt){
            1 -> tv_option_one.background = ContextCompat.getDrawable(this, drawableView)
            2 -> tv_option_two.background = ContextCompat.getDrawable(this, drawableView)
            3 -> tv_option_three.background = ContextCompat.getDrawable(this, drawableView)
            4 -> tv_option_four.background = ContextCompat.getDrawable(this, drawableView)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one)
                mySelectedOption = 1
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two)
                mySelectedOption = 2
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three)
                mySelectedOption = 3
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four)
                mySelectedOption = 4
            }
            R.id.btn_submit -> {
                if(mySelectedOption == 0){
                    myCurrentPage++
                    if(myCurrentPage <= myQuestionList!!.size) {
                        defaultOptionView()
                        setQuestions()
                    }else{
                        Toast.makeText(this, "Quiz is over..", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    answerView(que!!.correctOption, R.drawable.correct_answer_bg)
                    if(que!!.correctOption != mySelectedOption){
                        answerView(mySelectedOption, R.drawable.wrong_answer_bg)
                    }
                    mySelectedOption = 0
                    btn_submit.text = "GO TO NEXT"
                    if(myCurrentPage == myQuestionList!!.size)
                        btn_submit.text = "FINISH"
                }
            }
        }
    }
}