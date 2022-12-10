package assignments

class Assignment(input: String) {

    val sections: IntRange = parse(input)

    fun contains(other: Assignment): Boolean {
        return this.sections.toSet()
            .intersect(other.sections) == other.sections.toSet()
    }

    private fun parse(s: String): IntRange {
        val terms = s.split("-")
        return IntRange(terms[0].trim().toInt(), terms[1].trim().toInt())
    }

    override fun equals(other: Any?): Boolean {
        return this.hashCode() == (other as Assignment).hashCode()
    }

    override fun hashCode(): Int {
        return sections.hashCode()
    }

}