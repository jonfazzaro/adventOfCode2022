package communications

class DataStream(
    private val input: String,
    private val blockSize: Int = 4
) {

    fun startOfPacket(): Int {
        return input.toCharArray().dropLast(blockSize-1)
            .mapIndexed { i:Int, _: Char -> block(i) }
            .indexOfFirst { hasNoRepeatingChars(it) } + blockSize
    }

    private fun hasNoRepeatingChars(block: String) = block.length == set(block).length

    private fun set(block: String) = block.split("")
        .filter { it.isNotEmpty() }
        .toSet()
        .joinToString("")

    private fun block(at: Int) = input.substring(at, at + blockSize)

}
