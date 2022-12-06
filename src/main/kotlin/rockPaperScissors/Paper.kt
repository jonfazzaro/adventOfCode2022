package rockPaperScissors

class Paper() : Shape() {
    override val value = 2
    override fun defeats() = Rock()
}