package rockPaperScissors

class Game {

    fun score(log: String): Int {
        return log.trim().split("\n")
            .sumOf { parse(it).score() }
    }

    fun scoreFromResults(log: String): Int {
        return log.trim().split("\n")
            .sumOf { parseForResult(it).score() }
    }

    private fun parseForResult(round: String): Round {
        val codes = round.trim().split(" ")
        return Round(shape(codes[0]), result(codes[1]))
    }

    private fun parse(round: String): Round {
        val shapes = round.trim().split(" ").map { shape(it) }
        return Round(shapes[1], shapes[0])
    }

    private fun shape(code: String): Shape =
        when (code) {
            "A", "X" -> Rock()
            "B", "Y" -> Paper()
            "C", "Z" -> Scissors()
            else -> Rock()
        }

    private fun result(code: String): Result =
        when (code) {
            "X" -> Result.Lose
            "Y" -> Result.Draw
            "Z" -> Result.Win
            else -> Result.Lose
        }

}


