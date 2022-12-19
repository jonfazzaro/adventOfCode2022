package trees

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ForestShould {

    @Test
    fun `return the total count of visible trees`() {
        assertEquals(21, subject.visibleCount())
    }

    @Test
    fun `finds the highest scenic score`() {
        assertEquals(8, subject.scenicHighScore())
    }

    @BeforeEach
    fun arrange() {
        subject = Forest(
            "30373\n" +
                    "25512\n" +
                    "65332\n" +
                    "33549\n" +
                    "35390"
        )
    }

    private lateinit var subject: Forest

}