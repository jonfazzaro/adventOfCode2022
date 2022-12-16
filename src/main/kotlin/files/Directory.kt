package files

class Directory(
    private var name: String = "",
    var parent: Directory? = null
) {
    init {
        parent?.add(this)
    }

    private val directories = mutableListOf<Directory>()
    val files = mutableListOf<File>()

    fun path(): String {
        return "${parent?.path() ?: ""}/$name"
            .replace("//", "/")
    }

    fun size(): Long {
        return directories.sumOf { it.size() } +
                files.sumOf { it.size }
    }

    private fun add(directory: Directory) {
        if (!directories.contains(directory))
            directories.add(directory)
    }

    fun directories(start: Directory = this): List<Directory> {
        return listOf(start) + start.directories.flatMap { directories(it) }
    }
}