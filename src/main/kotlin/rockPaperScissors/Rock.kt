package rockPaperScissors

class Rock() : Shape() {
    override val value = 1
    override fun defeats() = Scissors()
}