package communications

class DataStream(
    private val input: String,
    private val blockSize: Int = 4
) {

    fun startOfPacket(): Int {
        return input.toCharArray()
            .dropLast(blockSize - 1)
            .mapIndexed { i: Int, _: Char -> Block(input, i, blockSize) }
            .indexOfFirst { !it.hasRepeatingChars() } + blockSize
    }

}

