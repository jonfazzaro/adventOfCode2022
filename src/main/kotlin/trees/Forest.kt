package trees

class Forest(private val input: String) {

    val rows: List<List<Int>> = parseRows()

    fun isVisible(row: Int, col: Int): Boolean {
        return isEdge(row, col)
                || isVisibleFrom(Direction.North, row, col)
                || isVisibleFrom(Direction.South, row, col)
                || isVisibleFrom(Direction.East, row, col)
                || isVisibleFrom(Direction.West, row, col)
    }

    fun visibleCount(): Int {
        return (0..lastRow())
            .sumOf { row ->
                (0..lastColumn())
                    .count { col ->
                        isVisible(row, col)
                    }
            }
    }

    private fun isVisibleFrom(direction: Direction, row: Int, col: Int): Boolean {
        return (treesToThe(direction, row, col).maxOfOrNull { it } ?: 0) < rows[row][col]
    }

    private fun parseRows(): List<List<Int>> {
        return input.split("\n")
            .map {
                it.toCharArray()
                    .map { c: Char -> c.digitToInt() }
            }
    }

    private fun isEdge(row: Int, col: Int): Boolean {
        return (row == 0 || row == lastRow())
                || (col == 0 || col == lastColumn())
    }

    private fun lastColumn() = rows[0].count() - 1

    private fun lastRow() = rows.count() - 1

    private fun treesToThe(direction: Direction, ofRow: Int, ofCol: Int): List<Int> {
        return when (direction) {
            Direction.East -> (ofCol + 1..lastColumn()).map { rows[ofRow][it] }
            Direction.West -> (0 until ofCol).map { rows[ofRow][it] }
            Direction.North -> (0 until ofRow).map { rows[it][ofCol] }
            Direction.South -> (ofRow + 1..lastRow()).map { rows[it][ofCol] }
        }
    }
}

enum class Direction {
    North,
    South,
    East,
    West
}
