package alok.ranjan.quizappself

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    var myCurrentPage: Int = 1
    var mySelectedOption: Int = 0
    var myQuestions: ArrayList<Questions>? = null
    var que: Questions? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        myQuestions = Constants.getQuestions()

        setQuestions()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    private fun setQuestions(){

        que = myQuestions!![myCurrentPage - 1]

        tv_question.text = que!!.question

        iv_image.setImageResource(que!!.image)

        id_progress.progress = myCurrentPage
        tv_progress.text = "${myCurrentPage}/${myQuestions!!.size}"

        tv_option_one.text = que!!.option1
        tv_option_two.text = que!!.option2
        tv_option_three.text = que!!.option3
        tv_option_four.text = que!!.option4

        btn_submit.text = "SUBMIT"

    }

    private fun defaultOptionView(){
        val options: ArrayList<TextView> = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)

        for(option in options){
            option.typeface = Typeface.DEFAULT
            option.setTextColor(Color.parseColor("#DBF0FF"))
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_bg
            )
        }
    }

    private fun selectedOptionView(tv: TextView){

        defaultOptionView()

        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.setTextColor(Color.parseColor("#0F9BFF"))
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option_bg
        )
    }

    private fun answerView(opt: Int, drawableView: Int){
        when(opt){
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
            tv_option_four.background = ContextCompat.getDrawable(this, drawableView)
            }
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
                    myCurrentPage ++
                    if(myCurrentPage <= myQuestions!!.size) {
                        defaultOptionView()
                        setQuestions()
                    }else{
                        Toast.makeText(this, "Quiz is over..", Toast.LENGTH_SHORT).show()
                    }

                }else{
                    answerView(que!!.correctOption, R.drawable.correct_option_bg)
                    if(mySelectedOption != que!!.correctOption){
                        answerView(mySelectedOption, R.drawable.wrong_option_bg)
                    }
                    mySelectedOption = 0
                    btn_submit.text = "GO TO NEXT"
                    if(myCurrentPage == myQuestions!!.size)
                        btn_submit.text = "FINISH"
                }
            }
        }
    }
}

