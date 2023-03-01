package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition: Int = 0
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var isPicked: Boolean = false
    private var mUserName: String? = null
    private var mWrongAnswers: Int = 0
    private var progressBar: ProgressBar? = null
    private var tvProgress :TextView?= null
    private var tvQuestion: TextView? = null
    private var ivFLag: ImageView? = null
    private var tvOption1: TextView? = null
    private var tvOption2: TextView? = null
    private var tvOption3: TextView? = null
    private var tvOption4: TextView? = null
    private var btnSubmit: Button? = null
    private var anotherSelected : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constans.USER_NAME)

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.TVprogress)
        tvQuestion = findViewById(R.id.TVquestion)
        ivFLag = findViewById(R.id.IVflag)
        tvOption1 = findViewById(R.id.TVoptionOne)
        tvOption2 = findViewById(R.id.TVoptionTwo)
        tvOption3 = findViewById(R.id.TVoptionThree)
        tvOption4 = findViewById(R.id.TVoptionFour)
        btnSubmit = findViewById(R.id.btnSubmit)



        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)
        mQuestionList = Constans.getQuestions()
        setQuestion()
    }

    private fun setQuestion() {
        mCurrentPosition  +=1
        val question: Question = mQuestionList!![mCurrentPosition -1]
        ivFLag?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOption1?.text = question.optionOne
        tvOption2?.text = question.optionTwo
        tvOption3?.text = question.optionThree
        tvOption4?.text = question.optionFour

        if(mCurrentPosition == mQuestionList!!.size){
            btnSubmit?.text = "Finish"
        }
        else{
            btnSubmit?.text = "Submit"
        }
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        tvOption1?.let{
            options.add(0,it)
        }
        tvOption2?.let{
            options.add(1,it)
        }
        tvOption3?.let{
            options.add(2,it)
        }
        tvOption4?.let{
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor(("#FFFFFF")))
            option.setBackgroundResource(R.drawable.default_border)
            option.typeface = Typeface.DEFAULT
        }
    }

    private fun setBackground(view: TextView?, num: Int){
        view?.setBackgroundResource(num)
    }



    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setBackgroundResource(R.drawable.selected_border)
        tv.setTypeface(tv.typeface, Typeface.BOLD)
    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.TVoptionOne -> tvOption1?.let{
                selectedOptionView(it,1)
                isPicked = true
            }
            R.id.TVoptionTwo -> tvOption2?.let{
                selectedOptionView(it,2)
                isPicked = true
            }
            R.id.TVoptionThree -> tvOption3?.let{
                selectedOptionView(it,3)
                isPicked = true
            }
            R.id.TVoptionFour -> tvOption4?.let{
                selectedOptionView(it,4)
                isPicked = true
            }
            R.id.btnSubmit -> {
                if (isPicked) {
                    defaultOptionsView()
                    if (mSelectedOptionPosition == 0) {
                        when {
                            mCurrentPosition <mQuestionList!!.size -> {
                                setQuestion()
                                isPicked = false
                            }
                            else->{
                                val intent = Intent(this,ResultsActivity::class.java)
                                intent.putExtra(Constans.USER_NAME,mUserName)
                                intent.putExtra(Constans.WRONG_ANSWERS,mWrongAnswers)
                                intent.putExtra(Constans.TOTAL_QUESTIONS,mQuestionList?.size)
                                startActivity(intent)
                                finish()
                            }
                        }
                    }
                    else {
                        val question = mQuestionList?.get(mCurrentPosition - 1)
                        if (question!!.CorrectAnswer != mSelectedOptionPosition) {
                            answerView(question.CorrectAnswer, R.drawable.incorrect_answer)
                            mWrongAnswers += 1
                        }

                        answerView(mSelectedOptionPosition, R.drawable.correct_answer)
                        if (mCurrentPosition == mQuestionList!!.size)
                            btnSubmit?.text = "finish"
                        else
                            btnSubmit?.text = "Next question"

                        mSelectedOptionPosition = 0
                    }

                }
                else
                    Toast.makeText(this,"Select answer", Toast.LENGTH_SHORT).show()
            }

        }

    }
    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1-> setBackground(tvOption1, drawableView)
            2-> setBackground(tvOption2, drawableView)
            3-> setBackground(tvOption3, drawableView)
            4-> setBackground(tvOption4, drawableView)
        }
    }

}