package files

class File(
    val size: Long,
    private val name: String
) {

    override fun toString(): String {
        return "$size $name"
    }

    override fun equals(other: Any?): Boolean {
        return other.toString() == this.toString()
    }

    override fun hashCode(): Int {
        var result = size.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }
}