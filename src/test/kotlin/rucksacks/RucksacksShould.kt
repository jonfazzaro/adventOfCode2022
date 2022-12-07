package rucksacks

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals

class RucksacksShould {

    @ParameterizedTest(name = "return {1} given {0}")
    @CsvSource(
        "vJrwpWtwJgWrhcsFMMfFFhFp, 16",
        "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL, 38",
        "PmmdzqPrVvPwwTWBwg, 42",
        "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn, 22",
        "ttgJtRGJQctTZtZT, 20",
        "CrZsJsPPZsGzwwsLwLmpwMDw, 19",
    )
    fun `find priority of common letter`(input: String, expected: Int) {
        assertEquals(expected, Rucksack(input).commonItem().value())
    }

    @Test
    fun `total the values of the priority items`() {
        val input = """vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw"""

        assertEquals(157, RucksackList(input).value())
    }

    @Test
    fun `given a three sacks, find the common letter`() {
        val sacks = RucksackGroup(
            """vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg"""
        )
        assertEquals(18, sacks.value())
    }

    @Test
    fun `given a three more sacks, find their common letter`() {
        val sacks = RucksackGroup(
            """wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw"""
        )
        assertEquals(52, sacks.value())
    }

    @Test
    fun `group and total a list of sacks`() {
        val input = """vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw"""

        assertEquals(70, RucksackList(input).groupedValue())
    }

}