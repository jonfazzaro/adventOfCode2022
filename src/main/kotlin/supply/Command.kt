package supply

class Command(command: String) {
    private val params = command.split(" ")
    val count = params[1].toInt()
    val from = params[3].toInt()
    val to = params[5].toInt()
}