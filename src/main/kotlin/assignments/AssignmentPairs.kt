package assignments

class AssignmentPairs(input: String) {

    fun errorCount() = items.count { !it.isValid() }

    private var items: List<AssignmentPair> = parse(input)

    private fun parse(input: String) =
        input.split("\n").map { AssignmentPair(it) }

}
