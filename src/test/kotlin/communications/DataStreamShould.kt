package communications

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class DataStreamShould {

    @ParameterizedTest
    @CsvSource(
        "mjqjpqmgbljsphdztnvjfqwrcgsmlb, 7",
        "bvwbjplbgvbhsrlpgdmjqwftvncz, 5",
        "nppdvjthqldpwncqszvftbrmjlhg, 6",
        "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg, 10",
        "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw, 11",
    )
    fun `detects the start-of-packet index` (input: String, expectedIndex: Int) {
        assertEquals(expectedIndex, DataStream(input).startOfPacket())
    }

    @ParameterizedTest
    @CsvSource(
        "mjqjpqmgbljsphdztnvjfqwrcgsmlb, 19",
        "bvwbjplbgvbhsrlpgdmjqwftvncz, 23",
        "nppdvjthqldpwncqszvftbrmjlhg, 23",
        "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg, 29",
        "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw, 26",
    )
    fun `detects the start-of-message index` (input: String, expectedIndex: Int) {
        assertEquals(expectedIndex, DataStream(input, 14).startOfPacket())
    }

}