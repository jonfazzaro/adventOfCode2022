package files

class Shell(var directory: Directory = Directory()) {
    fun parse(input: String) {
        val lines = input.split("\n")
        lines.forEach { parseLine(it) }
    }

    fun root(from: Directory = directory): Directory {
        return from.parent?.let { root(it) } ?: from
    }

    fun size(under: Long) : Long {
        return root().directories()
            .map { it.size() }
            .filter { it <= under }
            .sum()
    }

    private fun parseLine(it: String) {
        val tokens = it.split(" ")
        when (tokens[0]) {
            "$" -> command(tokens)
            "dir" -> {}
            else -> addFile(tokens[0].toLong(), tokens[1])
        }
    }

    private fun command(tokens: List<String>) {
        run(tokens[1], tokens.drop(2))
    }

    private fun addFile(size: Long, name: String) {
        directory.files.add(File(size, name))
    }

    private fun run(verb: String, args: List<String>) {
        if (verb == "cd")
            cd(args[0])
    }

    private fun cd(path: String) {
        directory = when (path) {
            ".." -> directory.parent ?: Directory()
            "/" -> root(directory)
            else -> Directory(path, directory)
        }
    }


}

