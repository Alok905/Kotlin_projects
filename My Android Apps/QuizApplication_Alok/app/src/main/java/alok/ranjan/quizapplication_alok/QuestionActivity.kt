package alok.ranjan.quizapplication_alok

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    var myQuestionList: ArrayList<Questions>? = null
    var myCurrentPage: Int = 1
    var mySelectedOption: Int = 0
    var a_question: Questions? = null
    var myCorrectAnswers: Int = 0
    var buttonPressed: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        myQuestionList = Constants.getQuestions()

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    private fun setQuestion(){

        defaultOptionView()

        a_question = myQuestionList!![myCurrentPage - 1]

        tv_question.text = a_question!!.question

        iv_image.setImageResource(a_question!!.image)

        id_progress.progress = myCurrentPage
        tv_progress.text = "$myCurrentPage/${myQuestionList!!.size}"

        tv_option_one.text = a_question!!.option1
        tv_option_two.text = a_question!!.option2
        tv_option_three.text = a_question!!.option3
        tv_option_four.text = a_question!!.option4

        btn_submit.text = "SUBMIT"

    }

    private fun defaultOptionView(){
        val optionList: ArrayList<TextView> = ArrayList<TextView>()

        optionList.add(0, tv_option_one)
        optionList.add(1, tv_option_two)
        optionList.add(2, tv_option_three)
        optionList.add(3, tv_option_four)

        for(option in optionList){
            option.typeface = Typeface.DEFAULT
            option.setTextColor(Color.parseColor("#2C2C2C"))
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_bg)
        }
    }

    private fun selectedOptionView(tv: TextView){

        defaultOptionView()

        tv.setTextColor(Color.parseColor("#eeeeee"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
    }

    private fun answerView(selectedOpt: Int, drawableView: Int){

        when(selectedOpt){
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
                R.id.tv_option_one -> if(!buttonPressed){
                    selectedOptionView(tv_option_one)
                    mySelectedOption = 1
                }
                R.id.tv_option_two -> if(!buttonPressed){
                    selectedOptionView(tv_option_two)
                    mySelectedOption = 2
                }
                R.id.tv_option_three -> if(!buttonPressed){
                    selectedOptionView(tv_option_three)
                    mySelectedOption = 3
                }
                R.id.tv_option_four -> if(!buttonPressed){
                    selectedOptionView(tv_option_four)
                    mySelectedOption = 4
                }
                R.id.btn_submit -> {
                    if(mySelectedOption == 0){
                        myCurrentPage++
                        if(myCurrentPage <= myQuestionList!!.size){
                            buttonPressed = false
                            setQuestion()
                        }else{
                            Constants.score = myCorrectAnswers
                            Constants.total_question = myQuestionList!!.size
                            val intent = Intent(this, ResultActivity::class.java)
                            startActivity(intent)
                        }
                    }else{
                        buttonPressed = true
                        answerView(a_question!!.correctOption, R.drawable.correct_option_bg)
                        if(mySelectedOption != a_question!!.correctOption){
                            answerView(mySelectedOption, R.drawable.wrong_option_bg)

                            /* to make correct option BLACK and BOLD */
                            when(a_question!!.correctOption){
                                1 -> {
                                    tv_option_one.setTypeface(tv_option_one.typeface, Typeface.BOLD)
                                    tv_option_one.setTextColor(Color.parseColor("#000000"))
                                }
                                2 -> {
                                    tv_option_two.setTypeface(tv_option_two.typeface, Typeface.BOLD)
                                    tv_option_two.setTextColor(Color.parseColor("#000000"))
                                }
                                3 -> {
                                    tv_option_three.setTypeface(tv_option_three.typeface, Typeface.BOLD)
                                    tv_option_three.setTextColor(Color.parseColor("#000000"))
                                }
                                4 -> {
                                    tv_option_four.setTypeface(tv_option_four.typeface, Typeface.BOLD)
                                    tv_option_four.setTextColor(Color.parseColor("#000000"))
                                }
                            }

                        }else{
                            myCorrectAnswers++
                        }

                        mySelectedOption = 0

                        btn_submit.text = "Go to NEXT"
                        if(myCurrentPage == myQuestionList!!.size){
                            btn_submit.text = "FINISH"
                        }
                    }
                }
            }
    }
}