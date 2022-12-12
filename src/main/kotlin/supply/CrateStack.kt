package supply

class CrateStack(elements: List<Char>) {
    private var items = elements.toMutableList()

    fun top() : Char = items.elementAtOrElse(0) { ' ' }

    fun push(element: Char) = items.add(0, element)

    fun pop() : Char = items.removeFirst()

    fun pop(count: Int): List<Char> {
        val taken = items.take(count)
        items = items.drop(count).toMutableList()
        return taken
    }

    fun push(elements: List<Char>) {
        items.addAll(0, elements)
    }

}