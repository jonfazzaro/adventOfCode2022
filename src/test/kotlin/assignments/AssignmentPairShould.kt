package assignments

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AssignmentPairShould {

    @Test
    fun `parse a pair of assignments` () {
        val pair = pair("1-2,3-4")
        assertEquals(Assignment("1-2"), pair.first)
        assertEquals(Assignment("3-4"), pair.second)
    }

    @Test
    fun `return true given a pair that does not overlap` () {
        assertTrue(pair("1-3,5 -6").isValid())
    }

    @Test
    fun `returns false given a pair where the first contains the second` () {
        assertFalse(pair("1-5, 2-3").isValid())
    }

    @Test
    fun `returns false given a pair where the second contains the first` () {
        assertFalse(pair("12-23, 7-78").isValid())
    }

    private fun pair(input: String): AssignmentPair {
        return AssignmentPair(input)
    }

}