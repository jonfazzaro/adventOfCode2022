package assignments

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AssignmentPairsShould {


    @Test
    fun `match the example` () {
        val input = """2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8"""

        assertEquals(2, AssignmentPairs(input).containsCount())
    }

    @Test
    fun `match the second example` () {
        val input = """2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8"""

        assertEquals(4, AssignmentPairs(input).overlapCount())
    }

}