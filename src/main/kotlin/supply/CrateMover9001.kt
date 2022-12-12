package supply

class CrateMover9001(shipyard: Shipyard) : CrateMover(shipyard) {

    override fun move(count: Int, fromColumn: CrateStack, toColumn: CrateStack) {
        toColumn.push(fromColumn.pop(count))
    }
}
