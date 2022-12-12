package supply

open class CrateMover(private val state: String) {

    private val columns = columns()

    fun top(): String {
        return columns
            .map { it.top() }
            .joinToString("")
    }

    fun execute(command: String) {
        command.split("\n")
            .map { Command(it) }
            .forEach { execute(it) }
    }

    private fun execute(
        command: Command
    ) {
        val fromColumn = columns[command.from - 1]
        val toColumn = columns[command.to - 1]

        move(command.count, fromColumn, toColumn)
    }

    protected open fun move(
        count: Int,
        fromColumn: CrateStack,
        toColumn: CrateStack,
    ) {
        for (i in 0 until count)
            if (fromColumn.any())
                move(toColumn, fromColumn)
    }

    private fun move(
        toColumn: CrateStack,
        fromColumn: CrateStack
    ) {
        toColumn.push(fromColumn.pop())
    }

    private fun columns(): List<CrateStack> {
        val lines = lines()
        return columnIndexes(lines)
            .map { column(it, lines) }
    }

    private fun columnIndexes(lines: List<String>) =
        IntRange(0, width(lines) - 1).map { (it * 4) + 1 }

    private fun lines() = state.split("\n").dropLast(1)

    private fun width(lines: List<String>) = (lines[0].length + 1) / 4

    private fun column(
        index: Int,
        lines: List<String>
    ) = CrateStack(lines.map { it[index] }.filter { it != ' ' })

}
