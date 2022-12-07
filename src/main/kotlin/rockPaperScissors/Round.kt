package rockPaperScissors

class Round(
    private var played: Shape,
    private val against: Shape
) {

    constructor(against: Shape, result: Result) : this(against, against) {
        played = when (result) {
            Result.Win -> defeats(against)
            Result.Lose -> against.defeats()
            else -> against
        }
    }

    fun score(): Int {
        return gameScore() + played.value
    }

    private fun defeats(against: Shape): Shape {
        return listOf(Rock(), Paper(), Scissors()).first {
            it.defeats()::class == against::class
        }
    }

    private fun gameScore() =
        when (played.vs(against)) {
            Result.Win -> 6
            Result.Draw -> 3
            else -> 0
        }
}