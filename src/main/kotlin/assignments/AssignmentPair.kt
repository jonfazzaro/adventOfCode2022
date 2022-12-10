package assignments

class AssignmentPair(input: String) {
    fun hasContainment(): Boolean {
        return first.contains(second)
                || second.contains(first)
    }

    fun hasOverlap(): Boolean {
        return first.overlaps(second)
    }

    val first: Assignment = Assignment(input.split(",")[0])
    val second: Assignment = Assignment(input.split(",")[1])
}
