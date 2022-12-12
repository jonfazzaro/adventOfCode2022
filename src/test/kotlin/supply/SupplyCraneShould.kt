package supply

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class SupplyCraneShould {

    private lateinit var crane: CrateMover
    private lateinit var shipyard: Shipyard

    @ParameterizedTest
    @CsvSource(
        "NDP, [N] [D] [P]| 1   2   3 ",
        "ABC, [A] [B] [C]| 1   2   3 ",
    )
    fun `given a state, gets its top row`(expected: String, input: String) {
        assertEquals(expected, Shipyard(input.replace("|", "\n")).top())
    }

    @Test
    fun `given a two-line state, gets its top elements`() {
        assertEquals(
            "CAB",
            Shipyard("    [A] [B]\n[C]        \n 1   2   3 ").top()
        )
    }

    @Test
    fun `moves 1 crate given a command`() {
        arrange(
            """    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 """
        )
        crane.execute("move 1 from 2 to 1")
        assertEquals("DCP", shipyard.top())
    }

    @Test
    fun `moves 2 crates given a command`() {
        val shipyard = Shipyard(
            """[D]        
[N] [C]    
[Z] [M] [P]
 1   2   3 """
        )
        val crane = CrateMover(shipyard)
        crane.execute("move 2 from 1 to 3")
        assertEquals("ZCN", shipyard.top())
    }

    @Test
    fun `moves 3 crates given a command`() {
        val shipyard = Shipyard(
            """[D]        
[N] [C]    
[Z] [M] [P]
 1   2   3 """
        )
        val crane = CrateMover(shipyard)
        crane.execute("move 3 from 1 to 3")
        assertEquals(" CZ", shipyard.top())
    }

    @Test
    fun `matches the example`() {
        arrange(
            """    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 """
        )

        crane.execute(
            """move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2"""
        )

        assertEquals("CMZ", shipyard.top())
    }

    @Test
    fun `matches the example for part 2`() {
        arrange9001(
            """    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 """
        )

        crane.execute(
            """move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2"""
        )

        assertEquals("MCD", shipyard.top())
    }

    private fun arrange9001(input: String) {
        shipyard = Shipyard(input)
        crane = CrateMover9001(shipyard)
    }

    private fun arrange(input: String) {
        shipyard = Shipyard(input)
        crane = CrateMover(shipyard)
    }
}
