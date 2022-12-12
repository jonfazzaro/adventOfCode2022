package supply

class Shipyard(private val input: String) {
    val columns = columns()

    private fun columns(): List<CrateStack> {
        val lines = lines()
        return columnIndexes(lines)
            .map { column(it, lines) }
    }

    fun top(): String {
        return columns
            .map { it.top() }
            .joinToString("")
    }

    private fun columnIndexes(lines: List<String>) =
        IntRange(0, width(lines) - 1).map { (it * 4) + 1 }

    private fun lines() = input.split("\n").dropLast(1)

    private fun width(lines: List<String>) = (lines[0].length + 1) / 4

    private fun column(
        index: Int,
        lines: List<String>
    ) = CrateStack(lines.map { it[index] }.filter { it != ' ' })
}