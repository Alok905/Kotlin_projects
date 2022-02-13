package com.example.calc_testing

import alok.ranjan.quizapplication_alok.Constants
import alok.ranjan.quizapplication_alok.Questions
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quiz_question.*
import java.lang.reflect.Type
import kotlin.reflect.typeOf

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPage = 1
    private var mSelectedOption = 0
    private var myQuestionList: ArrayList<Questions> = ArrayList()
    private var que: Questions? = null
    private var isBtnClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        myQuestionList = Constants.getQuestions()

        setQuestions()

        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)
    }

    private fun setQuestions(){

        defaultOptionView()

        que = myQuestionList[mCurrentPage - 1]

        tvQuestion.text = que!!.question
        ivImage.setImageResource(que!!.image)
        idProgress.progress = mCurrentPage
        tvProgress.text = "$mCurrentPage/${myQuestionList.size}"

        tvOptionOne.text = que!!.option1
        tvOptionTwo.text = que!!.option2
        tvOptionThree.text = que!!.option3
        tvOptionFour.text = que!!.option4

        btnSubmit.text = "SUBMIT"
    }

    private fun defaultOptionView(){
        val tvList = ArrayList<TextView>()
        tvList.add(tvOptionOne)
        tvList.add(tvOptionTwo)
        tvList.add(tvOptionThree)
        tvList.add(tvOptionFour)

        for(tv in tvList){
            tv.typeface = Typeface.DEFAULT
            tv.background = ContextCompat.getDrawable(this, R.drawable.default_option_bg)
            tv.setTextColor(Color.parseColor("#147cda"))
        }
    }

    private fun selectedOptionView(option: Int){

        defaultOptionView()

        when(option){
            1 -> {
                tvOptionOne.setTypeface(tvOptionOne.typeface, Typeface.BOLD)
                tvOptionOne.setTextColor(Color.parseColor("#000000"))
                tvOptionOne.background = ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
            }
            2 -> {
                tvOptionTwo.setTypeface(tvOptionTwo.typeface, Typeface.BOLD)
                tvOptionTwo.setTextColor(Color.parseColor("#000000"))
                tvOptionTwo.background = ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
            }
            3 -> {
                tvOptionThree.setTypeface(tvOptionThree.typeface, Typeface.BOLD)
                tvOptionThree.setTextColor(Color.parseColor("#000000"))
                tvOptionThree.background = ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
            }
            4 -> {
                tvOptionFour.setTypeface(tvOptionFour.typeface, Typeface.BOLD)
                tvOptionFour.setTextColor(Color.parseColor("#000000"))
                tvOptionFour.background = ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
            }
        }
    }

    private fun answerView(option: Int, drawableView: Int){
        when(option) {
            1 -> tvOptionOne.background = ContextCompat.getDrawable(this, drawableView)
            2 -> tvOptionTwo.background = ContextCompat.getDrawable(this, drawableView)
            3 -> tvOptionThree.background = ContextCompat.getDrawable(this, drawableView)
            4 -> tvOptionFour.background = ContextCompat.getDrawable(this, drawableView)
        }

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.tvOptionOne -> if(!isBtnClicked){
                selectedOptionView(1)
                mSelectedOption = 1
            }
            R.id.tvOptionTwo -> if(!isBtnClicked){
                selectedOptionView(2)
                mSelectedOption = 2
            }
            R.id.tvOptionThree -> if(!isBtnClicked){
                selectedOptionView(3)
                mSelectedOption = 3
            }
            R.id.tvOptionFour -> if(!isBtnClicked){
                selectedOptionView(4)
                mSelectedOption = 4
            }
            R.id.btnSubmit -> {
                if(mSelectedOption != 0){
                    isBtnClicked = true
                    answerView(que!!.correctOption, R.drawable.correct_answer_bg)
                    if(mSelectedOption != que!!.correctOption) {
                        answerView(mSelectedOption, R.drawable.wrong_answer_bg)
                    }
                    mSelectedOption = 0
                    if(mCurrentPage == myQuestionList.size){
                        btnSubmit.text = "FINISH"
                    }else{
                        btnSubmit.text = "Go to next"
                    }
                }else{
                    mCurrentPage++
                    if(mCurrentPage <= myQuestionList.size) {
                        setQuestions()
                        isBtnClicked = false
                    }else{
                        Toast.makeText(this, "Quiz is over", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}


