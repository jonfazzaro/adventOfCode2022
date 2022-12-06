import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class RockPaperScissorsShould {

    @ParameterizedTest
    @CsvSource(
        "B, X, 1",
        "A, Y, 8",
        "C, Z, 6",
        "A, X, 4",
        "C, X, 7",
        "C, Y, 2",
    )
    fun `score the round` (player1: String, player2: String, expected:Int) {
        assertEquals(expected, RockPaperScissors().score(player1, player2))
    }

}