package rockPaperScissors

class Round(
    private val played: Shape,
    private val against: Shape
) {

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