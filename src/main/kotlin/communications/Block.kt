package communications

class Block(
    message: String,
    start: Int,
    blockSize: Int
) {

    private val value = message.substring(start, start + blockSize)

    fun hasRepeatingChars(): Boolean {
        return value.length != set().length
    }

    private fun set() = value.toCharArray()
        .toSet()
        .joinToString("")
}