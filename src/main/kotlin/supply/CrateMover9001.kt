package supply

class CrateMover9001(state: String) : CrateMover(state) {

    override fun move(count: Int, fromColumn: CrateStack, toColumn: CrateStack) {
        toColumn.push(fromColumn.pop(count))
    }
}
