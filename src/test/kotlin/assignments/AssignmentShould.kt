package assignments

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class AssignmentShould {

    @Test
    fun `parses a range of sections` () {
        assertEquals(IntRange(1,3), Assignment("1-3").sections)
    }

    @Nested
    inner class `When determining containment` {

        @Test
        fun `return false given a pair that does not overlap`() {
            assertFalse(Assignment("1-2").contains(Assignment("3-4")))
        }

        @Test
        fun `return true given a pair that overlaps completely`() {
            assertTrue(Assignment("1-4").contains(Assignment("2-3")))
        }

        @Test
        fun `return false given a pair that overlaps partially`() {
            assertFalse(Assignment("1-4").contains(Assignment("2-5")))
        }
    }

    @Nested
    inner class `When determining overlap` {

        @Test
        fun `return false given a pair that does not overlap`() {
            assertFalse(Assignment("1-2").overlaps(Assignment("3-4")))
        }

        @Test
        fun `return true given a pair that overlaps completely`() {
            assertTrue(Assignment("1-4").overlaps(Assignment("2-3")))
        }

        @Test
        fun `return true given a pair that overlaps partially`() {
            assertTrue(Assignment("1-4").overlaps(Assignment("2-5")))
        }
    }
}