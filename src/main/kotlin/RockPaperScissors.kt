import java.lang.reflect.Type

class RockPaperScissors {

    fun score(player1: String, player2: String): Int {
        val played = shape(player2)
        return gameScore(played, shape(player1)) + played.value
    }

    private fun gameScore(played: Shape, player1: Shape) =
        when (played.vs(player1)) {
            Result.Win -> 6
            Result.Draw -> 3
            else -> 0
        }

    private fun shape(code: String): Shape =
        when (code) {
            "A", "X" -> Rock()
            "B", "Y" -> Paper()
            "C", "Z" -> Scissors()
            else -> Rock()
        }
}

abstract class Shape {
    abstract val value: Int
    abstract val defeats: Type

    fun vs(shape: Shape): Result {
        return when (shape::class.java) {
            this::class.java -> Result.Draw
            defeats -> Result.Win
            else -> Result.Lose
        }
    }
}

class Scissors() : Shape() {
    override val value = 3
    override val defeats: Type = Paper::class.java
}

class Paper() : Shape() {
    override val value = 2
    override val defeats: Type = Rock::class.java
}

class Rock() : Shape() {
    override val value = 1
    override val defeats: Type = Scissors::class.java
}

enum class Result() {
    Win(),
    Lose(),
    Draw()
}