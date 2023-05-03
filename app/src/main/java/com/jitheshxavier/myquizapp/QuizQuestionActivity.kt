package com.jitheshxavier.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var questionTextView: TextView? = null
    private var flagImageView: ImageView? = null
    private var progressBar: ProgressBar? = null
    private var progressTextView: TextView? = null
    private var optionOneTextView: TextView? = null
    private var optionTwoTextView: TextView? = null
    private var optionThreeTextView: TextView? = null
    private var optionFourTextView: TextView? = null
    private var submitButton: Button? = null

    private var mSelectedOptionPosition: Int = 0
    private var mCurrentPosition: Int = 1
    private var questions: ArrayList<Question>?= null
    private var mUsername: String? = null
    private var correctAnswersCount: Int = 0
    private var isOptionSelected: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUsername = intent.getStringExtra(Constants.USER_NAME)
        questionTextView = findViewById(R.id.textViewQuestion)
        flagImageView = findViewById(R.id.imageViewFlag)
        progressBar = findViewById(R.id.progressBar)
        progressTextView = findViewById(R.id.textViewProgress)
        optionOneTextView = findViewById(R.id.textViewOptionOne)
        optionTwoTextView = findViewById(R.id.textViewOptionTwo)
        optionThreeTextView = findViewById(R.id.textViewOptionThree)
        optionFourTextView = findViewById(R.id.textViewOptionFour)
        submitButton = findViewById(R.id.submitButton)

        optionOneTextView?.setOnClickListener(this)
        optionTwoTextView?.setOnClickListener(this)
        optionThreeTextView?.setOnClickListener(this)
        optionFourTextView?.setOnClickListener(this)
        submitButton?.setOnClickListener(this)

        mCurrentPosition = 1
        questions = Constants.getQuestions()
        setQuestion()
        defaultOptionView()
    }

    private fun setQuestion() {
        defaultOptionView()
        val question = questions!![mCurrentPosition - 1]
        progressBar?.progress = mCurrentPosition
        progressTextView?.text = "$mCurrentPosition/${progressBar?.max}"
        flagImageView?.setImageResource(question.image)
        optionOneTextView?.text = question.optionOne
        optionTwoTextView?.text = question.optionTwo
        optionThreeTextView?.text = question.optionThree
        optionFourTextView?.text = question.optionFour

        if(mCurrentPosition == questions!!.size) {
            submitButton?.text = "FINISH"
        } else {
            submitButton?.text = "SUBMIT"
        }
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        optionOneTextView?.let {
            options.add(0, it)
        }
        optionTwoTextView?.let {
            options.add(1, it)
        }
        optionThreeTextView?.let {
            options.add(2, it)
        }
        optionFourTextView?.let {
            options.add(3, it)
        }

        for(option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_bg)
        }
    }

    private fun selectedOptionView(textView: TextView, selectedPosition: Int) {
        defaultOptionView()
        mSelectedOptionPosition = selectedPosition
        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
    }

    private fun isAlreadyChoseOption(): Boolean {
        return if (mSelectedOptionPosition == 0 && isOptionSelected) {
            Toast.makeText(this, "Please go to next question", Toast.LENGTH_SHORT).show()
            true
        } else {
            false
        }
    }

    override fun onClick(view: View?) {

        when(view?.id) {
            R.id.textViewOptionOne -> {
                if (isAlreadyChoseOption()) return
                isOptionSelected = true
                optionOneTextView?.let {
                    selectedOptionView(it, 1)
                }
            }
            R.id.textViewOptionTwo -> {
                if (isAlreadyChoseOption()) return
                isOptionSelected = true
                optionTwoTextView?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.textViewOptionThree -> {
                if (isAlreadyChoseOption()) return
                isOptionSelected = true
                optionThreeTextView?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.textViewOptionFour -> {
                if (isAlreadyChoseOption()) return
                isOptionSelected = true
                optionFourTextView?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.submitButton -> {
                if (!isOptionSelected) {
                    Toast.makeText(this, "Please choose an option", Toast.LENGTH_SHORT).show()
                    return
                }
                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= questions!!.size -> {
                            setQuestion()
                            isOptionSelected = false
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUsername)
                            intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswersCount)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, questions?.size)
                            startActivity(intent);
                            finish()
                        }
                    }
                } else {
                    val question = questions?.get(mCurrentPosition - 1)

                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_bg)
                    } else {
                        correctAnswersCount ++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_bg)

                    if (mCurrentPosition == questions!!.size) {
                        submitButton?.text = "FINISH"
                    } else {
                        submitButton?.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {

        when(answer) {
            1 -> {
               optionOneTextView?.background = ContextCompat.getDrawable(
                   this, drawableView
               )
            }
            2 -> {
                optionTwoTextView?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                optionThreeTextView?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                optionFourTextView?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }
}