package rucksacks

class RucksackList(private val input: String) {
    private val items: List<Rucksack> = parse()

    fun value(): Int = items.sumOf { value(it) }

    fun groupedValue(): Int = groups().sumOf { it.value() }

    private fun value(it: Rucksack) = it.commonItem().value()

    private fun parse(): List<Rucksack> {
        return input.split("\n").map { Rucksack(it) }
    }

    private fun groups(): List<RucksackGroup> {
        return LinePager(input, 3).pages().map { RucksackGroup(it) }
    }

}

