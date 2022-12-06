class CalorieCounter {

    fun top(list: String, groups: Int = 1) =
        when {
            list.isEmpty() -> 0
            else -> sumTop(groups, list)
        }

    private fun sumTop(groups: Int, list: String) =
        sumsOf(split(list))
            .sortedDescending()
            .take(groups)
            .sum()

    private fun sumsOf(groups: List<String>) =
        groups.map {
            parseValues(it).sum()
        }

    private fun split(list: String) =
        list.split("\n\n")

    private fun parseValues(group: String) =
        group.split("\n")
            .map { it.trim().toInt() }
            .toList()

}
