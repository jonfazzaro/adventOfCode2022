package rockPaperScissors

class Round(
    private val played: Shape,
    private var against: Shape
) {
    constructor(played: Shape, result: Result) : this(played, played) {
        against = when(result) {
            Result.Win -> played.defeats()
            Result.Lose -> played.defeats().defeats()
            else -> played
        }
    }

    fun score(): Int {
        return gameScore() + played.value
    }

    private fun gameScore() =
        when (played.vs(against)) {
            Result.Win -> 6
            Result.Draw -> 3
            else -> 0
        }
}