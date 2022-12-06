package rockPaperScissors

import java.lang.reflect.Type

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