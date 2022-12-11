package supply

class SupplyCrane(private val state: String) {

    private val columns = columns()

    fun top(): String {
        return columns
            .map { it.elementAtOrElse(0) { ' ' } }
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

    private fun move(
        count: Int,
        fromColumn: MutableList<Char>,
        toColumn: MutableList<Char>
    ) {
        for (i in 0 until count)
            if (fromColumn.any())
                move(toColumn, fromColumn)
    }

    private fun move(
        toColumn: MutableList<Char>,
        fromColumn: MutableList<Char>
    ) {
        toColumn.add(
            0,
            fromColumn.removeFirst()
        )
    }

    private fun columns(): List<MutableList<Char>> {
        val lines = state.split("\n").dropLast(1)
        val width = (lines[0].length + 1) / 4
        val columnIndexes = IntRange(0, width - 1).map { (it * 4) + 1 }
        return columnIndexes.map { column(it, lines) }
    }

    private fun column(
        index: Int,
        lines: List<String>
    ) = lines.map { it[index] }.filter { it != ' ' }.toMutableList()

}
