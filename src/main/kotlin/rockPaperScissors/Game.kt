package rockPaperScissors

class Game {

    fun score(log: String): Int {
        return log.trim().split("\n")
            .sumOf { parse(it).score() }
    }

    private fun parse(it: String): Round {
        val shapes = it.trim().split(" ").map { shape(it) }
        return Round(shapes[1], shapes[0])
    }

    private fun shape(code: String): Shape =
        when (code) {
            "A", "X" -> Rock()
            "B", "Y" -> Paper()
            "C", "Z" -> Scissors()
            else -> Rock()
        }
}


