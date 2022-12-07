package rucksacks

class LinePager(input: String, private val pageSize: Int) {
    private val lines = input.split("\n")

    fun pages() : List<String> {
        return IntRange(0, pageCount(lines, pageSize)).map { it ->
            input(page(lines, it, pageSize))
        }
    }

    private fun input(pages: List<String>) = pages.joinToString("\n")

    private fun page(
        lines: List<String>,
        pageNumber: Int,
        pageSize: Int
    ) = lines.drop(pageNumber * pageSize).take(pageSize)

    private fun pageCount(lines: List<String>, pageSize: Int) =
        (lines.count() / pageSize) - 1
}