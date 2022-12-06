package rockPaperScissors

class Scissors() : Shape() {
    override val value = 3
    override fun defeats() = Paper()
}