package supply

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class SupplyCraneShould {

    @ParameterizedTest
    @CsvSource(
        "NDP, [N] [D] [P]| 1   2   3 ",
        "ABC, [A] [B] [C]| 1   2   3 ",
    )
    fun `given a state, gets its top row` (expected:String, input:String) {
        assertEquals(expected, SupplyCrane(input.replace("|", "\n")).top())
    }

    @Test
    fun `given a two-line state, gets its top elements` () {
        assertEquals("CAB",
            SupplyCrane("    [A] [B]\n[C]        \n 1   2   3 ").top())
    }

    @Test
    fun `moves 1 crate given a command` () {
        val crane = SupplyCrane("""    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 """)
        crane.execute("move 1 from 2 to 1")
        assertEquals("DCP", crane.top())
    }

    @Test
    fun `moves 2 crates given a command` () {
        val crane = SupplyCrane("""[D]        
[N] [C]    
[Z] [M] [P]
 1   2   3 """)
        crane.execute("move 2 from 1 to 3")
        assertEquals("ZCN", crane.top())
    }

    @Test
    fun `moves 3 crates given a command` () {
        val crane = SupplyCrane("""[D]        
[N] [C]    
[Z] [M] [P]
 1   2   3 """)
        crane.execute("move 3 from 1 to 3")
        assertEquals(" CZ", crane.top())
    }
    
    @Test
    fun `matches the example` () {
        val crane = SupplyCrane("""    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 """)

        val moves = """move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2"""

        crane.execute(moves)
        assertEquals("CMZ", crane.top())
    }

}