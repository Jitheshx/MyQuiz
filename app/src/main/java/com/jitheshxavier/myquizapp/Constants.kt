package com.jitheshxavier.myquizapp

object Constants {

    const val USER_NAME = "user_name"
    const val TOTAL_QUESTIONS = "total_questions"
    const val CORRECT_ANSWERS = "correct_answers"

    fun  getQuestions(): ArrayList<Question> {
        val questions = ArrayList<Question>()

        val question1 = Question(
            id = 1,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1
        )
        questions.add(question1)

        val question2 = Question(
            id = 1,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_australia,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            2
        )
        questions.add(question2)

        val question3 = Question(
            id = 1,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_belgium,
            "Argentina",
            "Ausralia",
            "Belgium",
            "Austria",
            3
        )
        questions.add(question3)

        val question4 = Question(
            id = 1,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_brazil,
            "Brazil",
            "Ausralia",
            "Armenia",
            "Austria",
            1
        )
        questions.add(question4)

        val question5 = Question(
            id = 1,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_denmark,
            "Argentina",
            "Australia",
            "Armenia",
            "Denmark",
            4
        )
        questions.add(question5)

        val question6 = Question(
            id = 1,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_fiji,
            "Argentina",
            "Fiji",
            "Armenia",
            "Austria",
            2
        )
        questions.add(question6)

        val question7 = Question(
            id = 1,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_germany,
            "Argentina",
            "Australia",
            "Germany",
            "Austria",
            3
        )
        questions.add(question7)

        val question8 = Question(
            id = 1,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_india,
            "Argentina",
            "Australia",
            "Armenia",
            "India",
            1
        )
        questions.add(question8)

        val question9 = Question(
            id = 1,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait",
            "Australia",
            "Armenia",
            "Austria",
            1
        )
        questions.add(question9)

        val question10 = Question(
            id = 1,
            "What country does this flag belongs to?",
            R.drawable.ic_flag_of_new_zealand,
            "Argentina",
            "Australia",
            "Armenia",
            "New zealand",
            4
        )
        questions.add(question10)

        return  questions
    }
}