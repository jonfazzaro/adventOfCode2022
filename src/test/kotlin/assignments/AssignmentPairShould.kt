package assignments

import org.junit.jupiter.api.Nested
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

    @Nested
    inner class `when checking containment` {
        @Test
        fun `return false given a pair that does not overlap`() {
            assertFalse(pair("1-3,5 -6").hasContainment())
        }

        @Test
        fun `returns true given a pair where the first contains the second`() {
            assertTrue(pair("1-5, 2-3").hasContainment())
        }

        @Test
        fun `returns true given a pair where the second contains the first`() {
            assertTrue(pair("12-23, 7-78").hasContainment())
        }
    }

    @Nested
    inner class `when checking overlap` {
        @Test
        fun `return false given a pair that does not overlap`() {
            assertFalse(pair("1-3,5 -6").hasOverlap())
        }

        @Test
        fun `returns true given a pair where the first contains the second`() {
            assertTrue(pair("1-5, 2-3").hasOverlap())
        }

        @Test
        fun `returns true given a pair where the second contains the first`() {
            assertTrue(pair("12-23, 7-78").hasOverlap())
        }
    }

    private fun pair(input: String): AssignmentPair {
        return AssignmentPair(input)
    }

}