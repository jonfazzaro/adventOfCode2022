package files

class Shell(var directory: Directory = Directory()) {
    fun parse(input: String) {
        val lines = input.split("\n")
        lines.forEach { parseLine(it) }
    }

    fun root(from: Directory = directory): Directory {
        return from.parent?.let { root(it) } ?: from
    }

    fun size(under: Long): Long {
        return directoriesUnder(under)
            .sumOf { it.size() }
    }

    private fun directoriesUnder(sizeLimit: Long) = root().directories()
        .filter { it.size() <= sizeLimit }

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

    fun directoryToDeleteToFreeUp(space: Long): Directory {
        val unused = TOTAL_DISK_SPACE - root().size()
        val delta = space - unused
        return root().directories()
            .filter { delta <= it.size() }
            .minByOrNull { it.size() }!!
    }

    val TOTAL_DISK_SPACE = 70000000

}

