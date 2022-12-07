package rucksacks

class Rucksack(private val input: String) {
    fun commonItem(): String {
        return commonLetter(firstCompartment(), secondCompartment())
    }

    fun items() : Set<String> {
        return input.split("").toSet()
    }

    private fun commonLetter(first: String, second: String) : String {
        return first
            .split("")
            .intersect(second.split("").toSet())
            .elementAt(1)
    }

    private fun secondCompartment() =
        input.substring(input.length / 2, input.length)

    private fun firstCompartment() =
        input.substring(0, input.length / 2)

    override fun toString(): String {
        return input
    }
}

fun String.value():Int {
    val cipher = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    return cipher.indexOf(this)
}



