package rockPaperScissors

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class GameShould {

    @ParameterizedTest(name = "Given input {0}, scores {1}.")
    @CsvSource(
        "B X, 1",
        "A Y, 8",
        "C Z, 6",
        "A X, 4",
        "C X, 7",
        "C Y, 2",
    )
    fun `score the round`(round: String, expected: Int) {
        assertEquals(expected, Game().score(round))
    }

    @Test
    fun `total scores of multiple rounds`() {
        val log = """B X
        A Y
        C Z
        A X
        C X
        C Y"""

        assertEquals(28, Game().score(log))
    }

}