package rockPaperScissors

import java.lang.reflect.Type

class Rock() : Shape() {
    override val value = 1
    override val defeats: Type = Scissors::class.java
}