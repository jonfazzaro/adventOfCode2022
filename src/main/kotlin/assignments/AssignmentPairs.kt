package assignments

class AssignmentPairs(input: String) {

    fun containsCount() = items.count { it.hasContainment() }

    fun overlapCount(): Int {
        return items.count { it.hasOverlap() }
    }

    private var items: List<AssignmentPair> = parse(input)

    private fun parse(input: String) =
        input.split("\n").map { AssignmentPair(it) }

}
