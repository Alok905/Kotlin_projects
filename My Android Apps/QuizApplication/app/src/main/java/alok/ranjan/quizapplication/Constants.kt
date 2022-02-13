package alok.ranjan.quizapplication

object Constants{
    fun getQuestions(): ArrayList<Questions> {
        val questionList = ArrayList<Questions>()

        val que1 = Questions(1, "What sesson does this image belong to ?",
            R.drawable.winter, "Autumn", "Winter", "Rainy", "Summer", 2)

        questionList.add(que1)

        val que2 = Questions(2, "What sesson does this image belong to ?",
            R.drawable.autumn, "Autumn", "Winter", "Rainy", "Summer", 1)

        questionList.add(que2)

        val que3 = Questions(3, "What sesson does this image belong to ?",
            R.drawable.rainy, "Autumn", "Winter", "Rainy", "Summer", 3)

        questionList.add(que3)

        val que4 = Questions(4, "What sesson does this image belong to ?",
            R.drawable.summer, "Autumn", "Winter", "Rainy", "Summer", 4)

        questionList.add(que4)

        return questionList
    }
}