package com.example.quizapp

object Constans {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val WRONG_ANSWERS: String = "correct_answers"


    fun getQuestions(): ArrayList <Question>{
        val questionsList = ArrayList<Question>()
        val que1 = Question(
            1,"What country does this flag belong to?",
            R.drawable.flag_afganistan,
            "Ukraine", "Peru",
            "Afghanistan", "Ethiopia",
            3
        )
        questionsList.add(que1)

        val que2 = Question(
            2,"What country does this flag belong to?",
            R.drawable.flag_australia,
            "Bangladesh", "Australia",
            "Island", "Peru",
            2
        )
        questionsList.add(que2)

        val que3 = Question(
            3,"What country does this flag belong to?",
            R.drawable.flag_austriya,
            "Ireland", "Austria",
            "Bhutan", "Benin",
            2
        )
        questionsList.add(que3)

        val que4 = Question(
            4,"What country does this flag belong to?",
            R.drawable.flag_fillipiny,
            "Bolivia", "Poland",
            "Philippines", "Estonia",
            3
        )
        questionsList.add(que4)

        val que5 = Question(
            5,"What country does this flag belong to?",
            R.drawable.flag_iran,
            "Iran", "Paraguay",
            "Afghanistan", "Quatar",
            1
        )
        questionsList.add(que5)

        val que6 = Question(
            6,"What country does this flag belong to?",
            R.drawable.flag_islandiya,
            "Romania", "Island",
            "San Marino", "Ethiopia",
            2
        )
        questionsList.add(que6)

        val que7 = Question(
            7,"What country does this flag belong to?",
            R.drawable.flag_kolumbiya,
            "Lithuania", "Morocco",
            "Singapore", "Columbia",
            4
        )
        questionsList.add(que7)
        val que8 = Question(
            8,"What country does this flag belong to?",
            R.drawable.flag_liviya,
            "Libya", "Palestine",
            "Afghanistan", "Turkmenistan",
            1
        )
        questionsList.add(que8)
        val que9 = Question(
            9,"What country does this flag belong to?",
            R.drawable.flag_marokko,
            "Morocco", "Zambia",
            "Venezuela", "Zimbabwe",
            1
        )
        questionsList.add(que9)

        val que10 = Question(
            10,"What country does this flag belong to?",
            R.drawable.flag_tailand,
            "Thailand", "Syria",
            "U.A.E.", "Sudan",
            1
        )
        questionsList.add(que10)
        return questionsList
    }
}