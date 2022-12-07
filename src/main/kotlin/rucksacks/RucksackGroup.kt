package rucksacks

class RucksackGroup(input: String) {
    private val sacks = input.split("\n").map { Rucksack(it) }

    fun value(): Int {
        return commonItem().value()
    }

    private fun commonItem(): String {
        return sacks[0].items()
            .intersect(sacks[1].items())
            .intersect(sacks[2].items())
            .elementAt(1)
    }

}
