class CalorieCounter {
    fun count(list: String): Int {
        return when {
            list.isEmpty() -> 0
            else -> greatestSum(list)
        }
    }

    private fun greatestSum(list: String) =
        split(list).maxOf {
            parseGroup(it).sum()
        }

    private fun split(list: String) =
        list.split("\n\n")

    private fun parseGroup(group: String) =
        group.split("\n")
            .map { it.trim().toInt() }
            .toList()

}
