package trees

import trees.Direction.*

class Forest(input: String) {

    fun visibleCount(): Int {
        return trees.count { isVisible(it) }
    }

    fun scenicHighScore(): Int {
        return trees.maxOf { scenicScore(it) }
    }

    private fun scenicScore(tree: Tree): Int {
        return viewToThe(North, tree) *
                viewToThe(South, tree) *
                viewToThe(East, tree) *
                viewToThe(West, tree)
    }

    private fun isVisible(tree: Tree): Boolean {
        return isEdge(tree)
                || isVisibleFromThe(North, tree)
                || isVisibleFromThe(South, tree)
                || isVisibleFromThe(East, tree)
                || isVisibleFromThe(West, tree)
    }

    private fun isVisibleFromThe(direction: Direction, ofTree: Tree): Boolean {
        return (treesToThe(direction, ofTree).maxOfOrNull { it.height } ?: 0) < ofTree.height
    }

    private fun parseTrees(): List<Tree> {
        return rowIndexes()
            .flatMap { row ->
                columnIndexes()
                    .map { col ->
                        tree(row, col)
                    }
            }
    }

    private fun isEdge(tree: Tree): Boolean {
        return (tree.row == 0 || tree.row == lastRow())
                || (tree.col == 0 || tree.col == lastColumn())
    }

    private fun viewToThe(direction: Direction, tree: Tree): Int {
        val trees = treesToThe(direction, tree)
        if (isVisibleFromThe(direction, tree))
            return trees.count()
        return trees.indexOfFirst { tree.height <= it.height } + 1
    }

    private fun treesToThe(direction: Direction, ofTree: Tree): List<Tree> {
        return when (direction) {
            East -> (ofTree.col + 1..lastColumn()).map { tree(ofTree.row, it) }
            West -> (0 until ofTree.col).reversed().map { tree(ofTree.row, it) }
            North -> (0 until ofTree.row).reversed().map { tree(it, ofTree.col) }
            South -> (ofTree.row + 1..lastRow()).map { tree(it, ofTree.col) }
        }
    }

    private val rows: List<String> = input.split("\n")
    private val width = rows[0].length
    private val length = rows.count()
    private val trees = parseTrees()

    private fun tree(row: Int, col: Int): Tree =
        Tree(row, col, height(row, col))

    private fun height(row: Int, col: Int) = rows[row][col].digitToInt()

    private fun columnIndexes() = (0..lastColumn())

    private fun rowIndexes() = (0..lastRow())

    private fun lastColumn() = width - 1

    private fun lastRow() = length - 1

}