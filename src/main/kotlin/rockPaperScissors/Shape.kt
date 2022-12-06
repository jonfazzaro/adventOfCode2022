package rockPaperScissors

abstract class Shape {
    abstract val value: Int
    abstract fun defeats(): Shape

    fun vs(shape: Shape): Result {
        return when (shape::class) {
            this::class-> Result.Draw
            defeats()::class -> Result.Win
            else -> Result.Lose
        }
    }

}