package alok.ranjan.quizapplication_alok

data class Questions (
    val id: Int,
    val question: String,
    val image: Int,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val correctOption: Int
)