package assignments

class AssignmentPair(input: String) {
    fun isValid(): Boolean {
        return !first.contains(second)
                && !second.contains(first)
    }

    val first: Assignment = Assignment(input.split(",")[0])
    val second: Assignment = Assignment(input.split(",")[1])
}
