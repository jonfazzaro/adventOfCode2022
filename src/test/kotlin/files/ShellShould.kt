package files

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class ShellShould {

    @Test
    fun `have a current directory`() {
        assertEquals("/", shell.directory.path())
    }

    @Test
    fun `change directory`() {
        shell.parse("$ cd a")
        assertEquals("/a", shell.directory.path())
    }

    @Test
    fun `change directory again`() {
        shell.parse("$ cd b")
        assertEquals("/b", shell.directory.path())
    }

    @Test
    fun `drill down through directories`() {
        shell.parse(
            "$ cd b\n" +
                    "$ cd c\n" +
                    "$ cd d\n" +
                    "$ cd .."
        )
        assertEquals("/b/c", shell.directory.path())
    }

    @Test
    fun `change directory up`() {
        shell.parse("$ cd ..")
        assertEquals("/", shell.directory.path())
    }

    @Test
    fun `list and read directory contents`() {
        shell.parse(
            "$ ls\n" +
                    "1234 i.txt"
        )
        assertIterableEquals(
            listOf(
                File(1234, "i.txt")
            ), shell.directory.files
        )
    }

    @Test
    fun `parse subdirectories`() {
        shell.parse(
            "$ cd x\n" +
                    "$ ls\n" +
                    "dir e\n" +
                    "$ cd e"
        )
        assertEquals("/x/e", shell.directory.path())
    }

    @Test
    fun `totals the size of files in a directory`() {
        shell.parse(
            "$ cd x\n" +
                    "$ ls\n" +
                    "1234 i.txt\n" +
                    "5678 t\n" +
                    "dir e"
        )
        assertEquals(1234 + 5678, shell.directory.size())
    }

    @Test
    fun `totals the size of files in a directory hierarchy`() {
        shell.parse(
            "$ cd x\n" +
                    "$ ls\n" +
                    "1234 i.txt\n" +
                    "5678 t\n" +
                    "dir e\n" +
                    "$ cd e\n" +
                    "$ ls\n" +
                    "98 f\n" +
                    "234 qa\n" +
                    "$ cd ..\n" +
                    "$ cd .."
        )
        assertEquals("/", shell.directory.path())
        assertEquals(
            1234 + 5678 + 98 + 234,
            shell.directory.size()
        )
    }

    @Test
    fun `lists each directory`() {
        shell.parse( "5328 fr\n" +
                    "$ cd x\n" +
                    "$ ls\n" +
                    "1234 i.txt\n" +
                    "5678 t\n" +
                    "dir e\n" +
                    "$ cd e\n" +
                    "$ ls\n" +
                    "98 f\n" +
                    "234 qa\n" +
                    "$ cd /"
        )
        assertIterableEquals(listOf<Long>(12572, 7244, 332),
            shell.root().directories().map { it.size() })

    }

    @Test
    fun `match the example` () {
        val input = "$ cd /\n" +
                "$ ls\n" +
                "dir a\n" +
                "14848514 b.txt\n" +
                "8504156 c.dat\n" +
                "dir d\n" +
                "$ cd a\n" +
                "$ ls\n" +
                "dir e\n" +
                "29116 f\n" +
                "2557 g\n" +
                "62596 h.lst\n" +
                "$ cd e\n" +
                "$ ls\n" +
                "584 i\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd d\n" +
                "$ ls\n" +
                "4060174 j\n" +
                "8033020 d.log\n" +
                "5626152 d.ext\n" +
                "7214296 k"
        shell.parse(input)
        assertEquals(95437, shell.size(100000))
    }

    @Test
    fun `match the second example` () {
        val input = "$ cd /\n" +
                "$ ls\n" +
                "dir a\n" +
                "14848514 b.txt\n" +
                "8504156 c.dat\n" +
                "dir d\n" +
                "$ cd a\n" +
                "$ ls\n" +
                "dir e\n" +
                "29116 f\n" +
                "2557 g\n" +
                "62596 h.lst\n" +
                "$ cd e\n" +
                "$ ls\n" +
                "584 i\n" +
                "$ cd ..\n" +
                "$ cd ..\n" +
                "$ cd d\n" +
                "$ ls\n" +
                "4060174 j\n" +
                "8033020 d.log\n" +
                "5626152 d.ext\n" +
                "7214296 k"
        shell.parse(input)
        assertEquals(24933642, shell.directoryToDeleteToFreeUp(30000000).size())
    }

    @BeforeEach
    fun arrange() {
        shell = Shell()
    }

    private lateinit var shell: Shell
}