package supply

open class CrateMover(private val shipyard: Shipyard) {

    fun execute(command: String) {
        command.split("\n")
            .map { Command(it) }
            .forEach { execute(it) }
    }

    private fun execute(
        command: Command
    ) {
        val fromColumn = shipyard.columns[command.from - 1]
        val toColumn = shipyard.columns[command.to - 1]

        move(command.count, fromColumn, toColumn)
    }

    protected open fun move(
        count: Int,
        fromColumn: CrateStack,
        toColumn: CrateStack,
    ) {
        for (i in 0 until count)
            move(toColumn, fromColumn)
    }

    private fun move(
        toColumn: CrateStack,
        fromColumn: CrateStack
    ) {
        toColumn.push(fromColumn.pop())
    }

}